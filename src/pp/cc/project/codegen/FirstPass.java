package pp.cc.project.codegen;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import pp.cc.project.antlr.FrartellBaseListener;
import pp.cc.project.antlr.FrartellParser;
import pp.cc.project.dataobjects.ParseException;
import pp.cc.project.dataobjects.Scope;
import pp.cc.project.dataobjects.Scopes;
import pp.cc.project.dataobjects.type.ArrayType;
import pp.cc.project.dataobjects.type.NoneType;
import pp.cc.project.dataobjects.type.StringType;
import pp.cc.project.dataobjects.type.Type;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Frank
 *
 * First walk through the parse tree<br>
 * Type checking and variable offset calculation
 */
public class FirstPass extends FrartellBaseListener {

    private FirstPassResult result; // Results of this first walk through the parse tree
    private Scopes scopes; // Variable scopes used to calculate offsets and store types
    private List<String> errors; // List containing parse errors

    /**
     * Walk the parse tree and perform type checking, stores the result of variable assignments in a {@link FirstPassResult}
     * @param tree The parse tree to walk
     * @return The result of the type checking phase
     * @throws ParseException Thrown when an error occurs during parsing
     */
    public FirstPassResult check(ParseTree tree) throws ParseException {
        this.scopes = new Scopes();
        this.result = new FirstPassResult();
        this.errors = new ArrayList<>();

        // Walk the parse tree
        new ParseTreeWalker().walk(this, tree);

        // Throw a parse excpetion if error occurred
        if (!errors.isEmpty()) {
            throw new ParseException(errors);
        }

        return this.result;
    }

    /* Overridden listener methods */

    @Override
    public void enterBlock(@NotNull FrartellParser.BlockContext ctx) {
        openScope();
    }

    @Override
    public void exitBlock(@NotNull FrartellParser.BlockContext ctx) {
        closeScope();
    }

    @Override
    public void exitIntType(@NotNull FrartellParser.IntTypeContext ctx) {
        setType(ctx, Type.INT);
    }

    @Override
    public void exitStringType(@NotNull FrartellParser.StringTypeContext ctx) {
        setType(ctx, new StringType(ctx.getText().length() - 2));
    }

    @Override
    public void exitBoolType(@NotNull FrartellParser.BoolTypeContext ctx) {
        setType(ctx, Type.BOOL);
    }

    @Override
    public void exitArrayDeclTarget(@NotNull FrartellParser.ArrayDeclTargetContext ctx) {
        String id = ctx.ID().getText();
        Type type = getType(ctx.getParent().getChild(0));
        Type arrayType = new ArrayType(Integer.parseInt(ctx.INTEGER().getText()), type);

        // Add the array to the current scope with its length and type
        if (!this.scopes.put(id, arrayType)) {
            addError(ctx, "Tried declaring '%s' multiple times.", id);
        }

        // Set the variable offset
        setOffset(ctx, this.scopes.getOffset(id));
        setType(ctx, type);
        setType(ctx.ID(), arrayType);
        setEntry(ctx, ctx);
    }

    @Override
    public void exitIdDeclTarget(@NotNull FrartellParser.IdDeclTargetContext ctx) {
        String id = ctx.ID().getText();
        Type type = getType(ctx.getParent().getChild(0));

        // If we can not declare this variable
        if (!this.scopes.put(id, type)) {
            addError(ctx, "Tried declaring '%s' multiple times.", id);
        }

        // Set the variable offset
        setOffset(ctx, this.scopes.getOffset(id));
        setType(ctx, type);
        setEntry(ctx, ctx);
    }

    @Override
    public void exitDeclStat(@NotNull FrartellParser.DeclStatContext ctx) {
        // Variables may be initialized without a value
        if (ctx.expr() != null) {
            checkType(ctx.expr(), getType(getEntry(ctx.decltarget())));
        }

        // Set the variable type
        setType(ctx, getType(ctx.expr()));
        setEntry(ctx, getEntry(ctx.decltarget()));
    }

    @Override
    public void exitIdTarget(@NotNull FrartellParser.IdTargetContext ctx) {
        String id = ctx.ID().getText();
        Type type = this.scopes.getType(id);

        // If the type is a NoneType it was not declared
        if (type instanceof NoneType) {
            addError(ctx, "Variable '%s' not declared", id);

        // Else, set the type, offset and flow graph entry
        } else {
            setType(ctx, type);
            setOffset(ctx, this.scopes.getOffset(id));
            setEntry(ctx, ctx);
        }
    }

    @Override
    public void exitArrayTarget(@NotNull FrartellParser.ArrayTargetContext ctx) {
        String id = ctx.ID().getText();
        Type type = this.scopes.getType(id);

        // If this is an array
        if (type instanceof ArrayType) {
            Type elemType = ((ArrayType) type).getElemType();

            // Set the type, offset and flow graph entry
            setType(ctx, elemType);
            setOffset(ctx, this.scopes.getOffset(id));
            setEntry(ctx, ctx);

        // Add an error if it is not an array or if it was not declared
        } else {
            if (type instanceof NoneType) {
                addError(ctx, "Variable '%s' not declared", id);
            } else {
                addError(ctx, "Variable '%s' is not an array", id);
            }
        }
    }

    @Override
    public void exitAtomExpr(@NotNull FrartellParser.AtomExprContext ctx) {
        // Set the type and flow graph entry to that of the atom
        setType(ctx, getType(ctx.atom()));
        setEntry(ctx, getEntry(ctx.atom()));
    }

    @Override
    public void exitArrayExpr(@NotNull FrartellParser.ArrayExprContext ctx) {
        // Get the type of the first element
        Type exprType = getType(ctx.expr(0));

        // Get the type of the array
        Type arrayType = getType(ctx.getParent().getChild(1).getChild(0));

        int argSize = ctx.expr() != null ? ctx.expr().size() : 0;

        if (arrayType != null && (arrayType.size() / exprType.size()) != argSize) {
            addError(ctx, "Array was instantiated with length of %d but is assigned %d elements.", (arrayType.size() / exprType.size()), argSize);
        } else if (arrayType == null) {
            addError(ctx, "%s is not an array.", ctx.getParent().getChild(1).getText());
        }

        // Check if all elements are the same
        if (!ctx.expr().stream().allMatch(expr -> getType(expr).getClass().equals(exprType.getClass()))) {
            addError(ctx, "Not all elements of %s are of the same type.", ctx.getText());
        }

        setType(ctx, exprType);
    }

    @Override
    public void exitBoolAtom(@NotNull FrartellParser.BoolAtomContext ctx) {
        // Set the type and flow graph entry
        setType(ctx, Type.BOOL);
        setEntry(ctx, ctx);
    }

    @Override
    public void exitIntAtom(@NotNull FrartellParser.IntAtomContext ctx) {
        // Set the type and flow graph entry
        setType(ctx, Type.INT);
        setEntry(ctx, ctx);
    }

    @Override
    public void exitIdAtom(@NotNull FrartellParser.IdAtomContext ctx) {
        String id = ctx.ID().getText();
        Type type = this.scopes.getType(id);

        // If the type is a NoneType it was not declared
        if (type instanceof NoneType) {
            addError(ctx, "Variable '%s' is not declared.", id);

        // Else, set the type, offset and flow graph entry
        } else {
            setType(ctx, type);
            setOffset(ctx, this.scopes.getOffset(id));
            setEntry(ctx, ctx);
        }
    }

    @Override
    public void exitStringAtom(@NotNull FrartellParser.StringAtomContext ctx) {
        // Set the type and flow graph entry
        setType(ctx, new StringType(ctx.getText().length() - 2));
        setEntry(ctx, ctx);
    }

    @Override
    public void exitParExprAtom(@NotNull FrartellParser.ParExprAtomContext ctx) {
        // Set the type and flow graph entry to that of the expression between parentheses
        setType(ctx, getType(ctx.expr()));
        setEntry(ctx, getEntry(ctx.expr()));
    }

    @Override
    public void exitAddExpr(@NotNull FrartellParser.AddExprContext ctx) {
        // Check if the addition is between two ints
        checkType(ctx.expr(0), Type.INT);
        checkType(ctx.expr(1), Type.INT);

        // Set the type to int
        setType(ctx, Type.INT);
        setEntry(ctx, getEntry(ctx.expr(0)));
    }

    @Override
    public void exitMultExpr(@NotNull FrartellParser.MultExprContext ctx) {
        // Check if the multiplication was between two ints
        checkType(ctx.expr(0), Type.INT);
        checkType(ctx.expr(1), Type.INT);

        // Set the type to int
        setType(ctx, Type.INT);
        setEntry(ctx, getEntry(ctx.expr(0)));
    }

    @Override
    public void exitPowExpr(@NotNull FrartellParser.PowExprContext ctx) {
        // Check if the exponentiation was between two ints
        checkType(ctx.expr(0), Type.INT);
        checkType(ctx.expr(1), Type.INT);

        // Set the type to int
        setType(ctx, Type.INT);
        setEntry(ctx, getEntry(ctx.expr(0)));
    }

    @Override
    public void exitUnaryMinExpr(@NotNull FrartellParser.UnaryMinExprContext ctx) {
        // Check if the target expression is an int
        checkType(ctx.expr(), Type.INT);

        // Set the type to int
        setType(ctx, Type.INT);
        setEntry(ctx, getEntry(ctx.expr()));
    }

    @Override
    public void exitNotExpr(@NotNull FrartellParser.NotExprContext ctx) {
        // Check if the target is a boolean
        checkType(ctx.expr(), Type.BOOL);

        // Set the type to bool
        setType(ctx, Type.BOOL);
        setEntry(ctx, getEntry(ctx.expr()));
    }

    @Override
    public void exitTernExpr(@NotNull FrartellParser.TernExprContext ctx) {
        // Check if the first expression is a boolean and the two remaining expressions are of the same type
        checkType(ctx.expr(0), Type.BOOL);
        checkType(ctx.expr(1), getType(ctx.expr(2)));

        // Set the type to that of the second expression
        setType(ctx, getType(ctx.expr(1)));
        setEntry(ctx, getEntry(ctx.expr(0)));
    }

    @Override
    public void exitIndexExpr(@NotNull FrartellParser.IndexExprContext ctx) {
        String id = ctx.ID().getText();
        // Get the type of the variable
        Type type = this.scopes.getType(id);

        // If the type is an array
        if (type instanceof ArrayType) {
            // Get the array element type
            Type elemType = ((ArrayType) type).getElemType();

            // Set the type to that of the element type
            setType(ctx, elemType);
            setOffset(ctx, this.scopes.getOffset(id));
            setEntry(ctx, ctx);

        // Else, add an error
        } else {
            if (type instanceof NoneType) {
                addError(ctx, "Variable '%s' not declared", id);
            } else {
                addError(ctx, "Variable '%s' is not an array", id);
            }
        }
    }

    @Override
    public void exitEqExpr(@NotNull FrartellParser.EqExprContext ctx) {
        // Make sure both expressions are of the same type
        checkType(ctx.expr(0), getType(ctx.expr(1)));
        setType(ctx, Type.BOOL);
        setEntry(ctx, getEntry(ctx.expr(0)));
    }

    @Override
    public void exitCompExpr(@NotNull FrartellParser.CompExprContext ctx) {
        // An array should not be compared
        if (getType(ctx.expr(0)) instanceof ArrayType) {
            addError(ctx, "Can not compare an array.");
        } else {
            // Make sure both expressions are of the same type
            checkType(ctx.expr(0), getType(ctx.expr(1)));
            setType(ctx, Type.BOOL);
            setEntry(ctx, getEntry(ctx.expr(0)));
        }
    }

    @Override
    public void exitBoolExpr(@NotNull FrartellParser.BoolExprContext ctx) {
        // Check if both expressions are of the type bool
        checkType(ctx.expr(0), Type.BOOL);
        checkType(ctx.expr(1), Type.BOOL);

        // Set the type to bool
        setType(ctx, Type.BOOL);
        setEntry(ctx, getEntry(ctx.expr(0)));
    }

    @Override
    public void exitAssignStat(@NotNull FrartellParser.AssignStatContext ctx) {
        // Check if the target and expression are of the same type
        checkType(ctx.target(), getType(ctx.expr()));
        setEntry(ctx, getEntry(ctx.expr()));
    }

    @Override
    public void exitIfStat(@NotNull FrartellParser.IfStatContext ctx) {
        // Check if the if condition is a boolean
        checkType(ctx.expr(), Type.BOOL);
        setEntry(ctx, getEntry(ctx.expr()));
    }

    @Override
    public void exitWhileStat(@NotNull FrartellParser.WhileStatContext ctx) {
        // Check if the while condition is a boolean
        checkType(ctx.expr(), Type.BOOL);
        setEntry(ctx, getEntry(ctx.expr()));
    }

    @Override
    public void exitFuncCalltStat(@NotNull FrartellParser.FuncCalltStatContext ctx) {
        //TODO Function call
    }

    @Override
    public void exitReturnStat(@NotNull FrartellParser.ReturnStatContext ctx) {
        //TODO Return statement
    }

    /**
     * Check the inferred type of a given parse tree,
     * add an error it is not the expected type.
     * @param node The parse tree node to check
     * @param expected The expected type
     */
    private void checkType(ParserRuleContext node, Type expected) {
        Type actual = getType(node);

        if (actual == null) {
            throw new IllegalArgumentException("Missing inferred type of " + node.getText());
        }

        if (!actual.equals(expected)) {
            addError(node, "Expected type '%s' but found '%s'", expected, actual);
        }
    }

    /**
     * Add an error at the given parse tree node
     * @param node The parse tree node
     * @param message The error message
     * @param args The arguments for the String.format method
     */
    private void addError(ParserRuleContext node, String message, Object... args) {
        addError(node.getStart(), message, args);
    }

    /**
     * Add an error at the given token
     * @param token The token
     * @param message The error message
     * @param args The arguments for the String.format method
     */
    private void addError(Token token, String message, Object... args) {
        int line = token.getLine();
        int column = token.getCharPositionInLine();
        message = String.format(message, args);
        message = String.format("Line %d:%d - %s", line, column, message);
        this.errors.add(message);
    }

    /**
     * Add an offset to the result
     * @param node The parse tree node of the variable
     * @param offset The offset to add
     */
    private void setOffset(ParseTree node, Integer offset) {
        this.result.setOffset(node, offset);
    }

    /**
     * Add a type to the result
     * @param node The parse tree node of the variable
     * @param type The type to add
     */
    private void setType(ParseTree node, Type type) {
        this.result.setType(node, type);
    }

    /**
     * Get the type of the variable at the given parse tree node
     * @param node The node to get the type for
     * @return The type of the variable at the given parse tree node
     */
    private Type getType(ParseTree node) {
        return this.result.getType(node);
    }

    /**
     * Add a flow graph entry to the result
     * @param node The parse tree node
     * @param entry The entry to add
     */
    private void setEntry(ParseTree node, ParserRuleContext entry) {
        if (entry == null) {
            throw new IllegalArgumentException("Null flow graph entry.");
        }
        this.result.setEntry(node, entry);
    }

    /**
     * Get the flow graph entry of a given expression or statement
     * @param node The expression or statement
     * @return The corresponding entry
     */
    private ParserRuleContext getEntry(ParseTree node) {
        return this.result.getEntry(node);
    }

    /**
     * Open a new scope
     * @return the opened scope
     */
    private Scope openScope() {
        return this.scopes.openScope();
    }

    /**
     * Close the current scope
     * @return True if the scope was closed successfully, else false
     */
    private boolean closeScope() {
        return this.scopes.closeScope();
    }

    /**
     * @return the list of errors
     */
    public List<String> getErrors() {
        return errors;
    }
}
