// Generated from C:/Development/Git/PPFinalProject/src/pp/cc/project/antlr\Frartell.g4 by ANTLR 4.5
package pp.cc.project.antlr;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FrartellParser}.
 */
public interface FrartellListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link FrartellParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(@NotNull FrartellParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link FrartellParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(@NotNull FrartellParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link FrartellParser#progname}.
	 * @param ctx the parse tree
	 */
	void enterProgname(@NotNull FrartellParser.PrognameContext ctx);
	/**
	 * Exit a parse tree produced by {@link FrartellParser#progname}.
	 * @param ctx the parse tree
	 */
	void exitProgname(@NotNull FrartellParser.PrognameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignStat}
	 * labeled alternative in {@link FrartellParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterAssignStat(@NotNull FrartellParser.AssignStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignStat}
	 * labeled alternative in {@link FrartellParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitAssignStat(@NotNull FrartellParser.AssignStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifStat}
	 * labeled alternative in {@link FrartellParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterIfStat(@NotNull FrartellParser.IfStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifStat}
	 * labeled alternative in {@link FrartellParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitIfStat(@NotNull FrartellParser.IfStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code whileStat}
	 * labeled alternative in {@link FrartellParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterWhileStat(@NotNull FrartellParser.WhileStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code whileStat}
	 * labeled alternative in {@link FrartellParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitWhileStat(@NotNull FrartellParser.WhileStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcCalltStat}
	 * labeled alternative in {@link FrartellParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterFuncCalltStat(@NotNull FrartellParser.FuncCalltStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcCalltStat}
	 * labeled alternative in {@link FrartellParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitFuncCalltStat(@NotNull FrartellParser.FuncCalltStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code returnStat}
	 * labeled alternative in {@link FrartellParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterReturnStat(@NotNull FrartellParser.ReturnStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code returnStat}
	 * labeled alternative in {@link FrartellParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitReturnStat(@NotNull FrartellParser.ReturnStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayExpr}
	 * labeled alternative in {@link FrartellParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterArrayExpr(@NotNull FrartellParser.ArrayExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayExpr}
	 * labeled alternative in {@link FrartellParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitArrayExpr(@NotNull FrartellParser.ArrayExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link FrartellParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAtomExpr(@NotNull FrartellParser.AtomExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link FrartellParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAtomExpr(@NotNull FrartellParser.AtomExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcCallExpr}
	 * labeled alternative in {@link FrartellParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFuncCallExpr(@NotNull FrartellParser.FuncCallExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcCallExpr}
	 * labeled alternative in {@link FrartellParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFuncCallExpr(@NotNull FrartellParser.FuncCallExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multExpr}
	 * labeled alternative in {@link FrartellParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMultExpr(@NotNull FrartellParser.MultExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multExpr}
	 * labeled alternative in {@link FrartellParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMultExpr(@NotNull FrartellParser.MultExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code indexExpr}
	 * labeled alternative in {@link FrartellParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIndexExpr(@NotNull FrartellParser.IndexExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code indexExpr}
	 * labeled alternative in {@link FrartellParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIndexExpr(@NotNull FrartellParser.IndexExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eqExpr}
	 * labeled alternative in {@link FrartellParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEqExpr(@NotNull FrartellParser.EqExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eqExpr}
	 * labeled alternative in {@link FrartellParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEqExpr(@NotNull FrartellParser.EqExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link FrartellParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNotExpr(@NotNull FrartellParser.NotExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link FrartellParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNotExpr(@NotNull FrartellParser.NotExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryMinExpr}
	 * labeled alternative in {@link FrartellParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryMinExpr(@NotNull FrartellParser.UnaryMinExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryMinExpr}
	 * labeled alternative in {@link FrartellParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryMinExpr(@NotNull FrartellParser.UnaryMinExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addExpr}
	 * labeled alternative in {@link FrartellParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddExpr(@NotNull FrartellParser.AddExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addExpr}
	 * labeled alternative in {@link FrartellParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddExpr(@NotNull FrartellParser.AddExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ternExpr}
	 * labeled alternative in {@link FrartellParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterTernExpr(@NotNull FrartellParser.TernExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ternExpr}
	 * labeled alternative in {@link FrartellParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitTernExpr(@NotNull FrartellParser.TernExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code compExpr}
	 * labeled alternative in {@link FrartellParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCompExpr(@NotNull FrartellParser.CompExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code compExpr}
	 * labeled alternative in {@link FrartellParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCompExpr(@NotNull FrartellParser.CompExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code powExpr}
	 * labeled alternative in {@link FrartellParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPowExpr(@NotNull FrartellParser.PowExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code powExpr}
	 * labeled alternative in {@link FrartellParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPowExpr(@NotNull FrartellParser.PowExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link FrartellParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBoolExpr(@NotNull FrartellParser.BoolExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link FrartellParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBoolExpr(@NotNull FrartellParser.BoolExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idTarget}
	 * labeled alternative in {@link FrartellParser#target}.
	 * @param ctx the parse tree
	 */
	void enterIdTarget(@NotNull FrartellParser.IdTargetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idTarget}
	 * labeled alternative in {@link FrartellParser#target}.
	 * @param ctx the parse tree
	 */
	void exitIdTarget(@NotNull FrartellParser.IdTargetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayTarget}
	 * labeled alternative in {@link FrartellParser#target}.
	 * @param ctx the parse tree
	 */
	void enterArrayTarget(@NotNull FrartellParser.ArrayTargetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayTarget}
	 * labeled alternative in {@link FrartellParser#target}.
	 * @param ctx the parse tree
	 */
	void exitArrayTarget(@NotNull FrartellParser.ArrayTargetContext ctx);
	/**
	 * Enter a parse tree produced by {@link FrartellParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(@NotNull FrartellParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link FrartellParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(@NotNull FrartellParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link FrartellParser#declfunc}.
	 * @param ctx the parse tree
	 */
	void enterDeclfunc(@NotNull FrartellParser.DeclfuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link FrartellParser#declfunc}.
	 * @param ctx the parse tree
	 */
	void exitDeclfunc(@NotNull FrartellParser.DeclfuncContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idDeclTarget}
	 * labeled alternative in {@link FrartellParser#decltarget}.
	 * @param ctx the parse tree
	 */
	void enterIdDeclTarget(@NotNull FrartellParser.IdDeclTargetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idDeclTarget}
	 * labeled alternative in {@link FrartellParser#decltarget}.
	 * @param ctx the parse tree
	 */
	void exitIdDeclTarget(@NotNull FrartellParser.IdDeclTargetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayDeclTarget}
	 * labeled alternative in {@link FrartellParser#decltarget}.
	 * @param ctx the parse tree
	 */
	void enterArrayDeclTarget(@NotNull FrartellParser.ArrayDeclTargetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayDeclTarget}
	 * labeled alternative in {@link FrartellParser#decltarget}.
	 * @param ctx the parse tree
	 */
	void exitArrayDeclTarget(@NotNull FrartellParser.ArrayDeclTargetContext ctx);
	/**
	 * Enter a parse tree produced by {@link FrartellParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(@NotNull FrartellParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link FrartellParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(@NotNull FrartellParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link FrartellParser#args}.
	 * @param ctx the parse tree
	 */
	void enterArgs(@NotNull FrartellParser.ArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link FrartellParser#args}.
	 * @param ctx the parse tree
	 */
	void exitArgs(@NotNull FrartellParser.ArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link FrartellParser#pars}.
	 * @param ctx the parse tree
	 */
	void enterPars(@NotNull FrartellParser.ParsContext ctx);
	/**
	 * Exit a parse tree produced by {@link FrartellParser#pars}.
	 * @param ctx the parse tree
	 */
	void exitPars(@NotNull FrartellParser.ParsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parExprAtom}
	 * labeled alternative in {@link FrartellParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterParExprAtom(@NotNull FrartellParser.ParExprAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parExprAtom}
	 * labeled alternative in {@link FrartellParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitParExprAtom(@NotNull FrartellParser.ParExprAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intAtom}
	 * labeled alternative in {@link FrartellParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterIntAtom(@NotNull FrartellParser.IntAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intAtom}
	 * labeled alternative in {@link FrartellParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitIntAtom(@NotNull FrartellParser.IntAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolAtom}
	 * labeled alternative in {@link FrartellParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterBoolAtom(@NotNull FrartellParser.BoolAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolAtom}
	 * labeled alternative in {@link FrartellParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitBoolAtom(@NotNull FrartellParser.BoolAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idAtom}
	 * labeled alternative in {@link FrartellParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterIdAtom(@NotNull FrartellParser.IdAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idAtom}
	 * labeled alternative in {@link FrartellParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitIdAtom(@NotNull FrartellParser.IdAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringAtom}
	 * labeled alternative in {@link FrartellParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterStringAtom(@NotNull FrartellParser.StringAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringAtom}
	 * labeled alternative in {@link FrartellParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitStringAtom(@NotNull FrartellParser.StringAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intType}
	 * labeled alternative in {@link FrartellParser#type}.
	 * @param ctx the parse tree
	 */
	void enterIntType(@NotNull FrartellParser.IntTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intType}
	 * labeled alternative in {@link FrartellParser#type}.
	 * @param ctx the parse tree
	 */
	void exitIntType(@NotNull FrartellParser.IntTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolType}
	 * labeled alternative in {@link FrartellParser#type}.
	 * @param ctx the parse tree
	 */
	void enterBoolType(@NotNull FrartellParser.BoolTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolType}
	 * labeled alternative in {@link FrartellParser#type}.
	 * @param ctx the parse tree
	 */
	void exitBoolType(@NotNull FrartellParser.BoolTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringType}
	 * labeled alternative in {@link FrartellParser#type}.
	 * @param ctx the parse tree
	 */
	void enterStringType(@NotNull FrartellParser.StringTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringType}
	 * labeled alternative in {@link FrartellParser#type}.
	 * @param ctx the parse tree
	 */
	void exitStringType(@NotNull FrartellParser.StringTypeContext ctx);
}