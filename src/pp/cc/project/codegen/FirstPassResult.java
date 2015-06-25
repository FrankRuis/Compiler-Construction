package pp.cc.project.codegen;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import pp.cc.project.dataobjects.type.Type;

/**
 * @author Frank
 */
public class FirstPassResult {
    private final ParseTreeProperty<ParserRuleContext> entries = new ParseTreeProperty<>();

    private final ParseTreeProperty<Type> types = new ParseTreeProperty<>();

    private final ParseTreeProperty<Integer> offsets = new ParseTreeProperty<>();

    public void setEntry(ParseTree node, ParserRuleContext entry) {
        this.entries.put(node, entry);
    }

    public ParserRuleContext getEntry(ParseTree node) {
        return this.entries.get(node);
    }

    public void setOffset(ParseTree node, int offset) {
        this.offsets.put(node, offset);
    }

    public int getOffset(ParseTree node) {
        return this.offsets.get(node);
    }

    public void setType(ParseTree node, Type type) {
        this.types.put(node, type);
    }

    public Type getType(ParseTree node) {
        return this.types.get(node);
    }
}
