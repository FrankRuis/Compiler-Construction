package pp.cc.project.codegen;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import pp.cc.project.dataobjects.type.Type;

/**
 * @author Frank
 *
 * Contains the results of the type checking phase
 */
public class FirstPassResult {
    // Mapping parse tree nodes to their their entry in the control flow graph
    private final ParseTreeProperty<ParserRuleContext> entries = new ParseTreeProperty<>();
    // Mapping from expressions to types
    private final ParseTreeProperty<Type> types = new ParseTreeProperty<>();
    // Mapping from variables to their offset in memory
    private final ParseTreeProperty<Integer> offsets = new ParseTreeProperty<>();

    /**
     * Adds an association from a parse tree node to the flow graph entry
     * @param node The parse tree node
     * @param entry The flow graph entry
     */
    public void setEntry(ParseTree node, ParserRuleContext entry) {
        this.entries.put(node, entry);
    }

    /**
     * Get the flow graph entry associated with the given parse tree node
     * @param node The parse tree node
     * @return The flow graph entry
     */
    public ParserRuleContext getEntry(ParseTree node) {
        return this.entries.get(node);
    }

    /**
     * Set the offset of the variable at the given parse tree node
     * @param node The parse tree node
     * @param offset The offset
     */
    public void setOffset(ParseTree node, int offset) {
        this.offsets.put(node, offset);
    }

    /**
     * Get the offset of the variable at the given parse tree node
     * @param node The parse tree node
     * @return The offset
     */
    public int getOffset(ParseTree node) {
        return this.offsets.get(node);
    }

    /**
     * Set the type of the variable at the given parse tree node
     * @param node The parse tree node
     * @param type The variable type
     */
    public void setType(ParseTree node, Type type) {
        this.types.put(node, type);
    }

    /**
     * Get the type of the variable at the given parse tree node
     * @param node The parse tree node
     * @return The variable type
     */
    public Type getType(ParseTree node) {
        return this.types.get(node);
    }
}
