// Generated from C:/Development/Git/PPFinalProject/src/pp/cc/project/antlr\Frartell.g4 by ANTLR 4.5
package pp.cc.project.antlr;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link FrartellParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface FrartellVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link FrartellParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(@NotNull FrartellParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link FrartellParser#progname}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgname(@NotNull FrartellParser.PrognameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignStat}
	 * labeled alternative in {@link FrartellParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignStat(@NotNull FrartellParser.AssignStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifStat}
	 * labeled alternative in {@link FrartellParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStat(@NotNull FrartellParser.IfStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code whileStat}
	 * labeled alternative in {@link FrartellParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStat(@NotNull FrartellParser.WhileStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funcCalltStat}
	 * labeled alternative in {@link FrartellParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncCalltStat(@NotNull FrartellParser.FuncCalltStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code returnStat}
	 * labeled alternative in {@link FrartellParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStat(@NotNull FrartellParser.ReturnStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayExpr}
	 * labeled alternative in {@link FrartellParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayExpr(@NotNull FrartellParser.ArrayExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link FrartellParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomExpr(@NotNull FrartellParser.AtomExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funcCallExpr}
	 * labeled alternative in {@link FrartellParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncCallExpr(@NotNull FrartellParser.FuncCallExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multExpr}
	 * labeled alternative in {@link FrartellParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultExpr(@NotNull FrartellParser.MultExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code indexExpr}
	 * labeled alternative in {@link FrartellParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexExpr(@NotNull FrartellParser.IndexExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code eqExpr}
	 * labeled alternative in {@link FrartellParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqExpr(@NotNull FrartellParser.EqExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link FrartellParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpr(@NotNull FrartellParser.NotExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryMinExpr}
	 * labeled alternative in {@link FrartellParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryMinExpr(@NotNull FrartellParser.UnaryMinExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addExpr}
	 * labeled alternative in {@link FrartellParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddExpr(@NotNull FrartellParser.AddExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ternExpr}
	 * labeled alternative in {@link FrartellParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTernExpr(@NotNull FrartellParser.TernExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code compExpr}
	 * labeled alternative in {@link FrartellParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompExpr(@NotNull FrartellParser.CompExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code powExpr}
	 * labeled alternative in {@link FrartellParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPowExpr(@NotNull FrartellParser.PowExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link FrartellParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolExpr(@NotNull FrartellParser.BoolExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idTarget}
	 * labeled alternative in {@link FrartellParser#target}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdTarget(@NotNull FrartellParser.IdTargetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayTarget}
	 * labeled alternative in {@link FrartellParser#target}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayTarget(@NotNull FrartellParser.ArrayTargetContext ctx);
	/**
	 * Visit a parse tree produced by {@link FrartellParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl(@NotNull FrartellParser.DeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link FrartellParser#declfunc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclfunc(@NotNull FrartellParser.DeclfuncContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idDeclTarget}
	 * labeled alternative in {@link FrartellParser#decltarget}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdDeclTarget(@NotNull FrartellParser.IdDeclTargetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayDeclTarget}
	 * labeled alternative in {@link FrartellParser#decltarget}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayDeclTarget(@NotNull FrartellParser.ArrayDeclTargetContext ctx);
	/**
	 * Visit a parse tree produced by {@link FrartellParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(@NotNull FrartellParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link FrartellParser#args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgs(@NotNull FrartellParser.ArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link FrartellParser#pars}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPars(@NotNull FrartellParser.ParsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parExprAtom}
	 * labeled alternative in {@link FrartellParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParExprAtom(@NotNull FrartellParser.ParExprAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intAtom}
	 * labeled alternative in {@link FrartellParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntAtom(@NotNull FrartellParser.IntAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolAtom}
	 * labeled alternative in {@link FrartellParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolAtom(@NotNull FrartellParser.BoolAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idAtom}
	 * labeled alternative in {@link FrartellParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdAtom(@NotNull FrartellParser.IdAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringAtom}
	 * labeled alternative in {@link FrartellParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringAtom(@NotNull FrartellParser.StringAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intType}
	 * labeled alternative in {@link FrartellParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntType(@NotNull FrartellParser.IntTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolType}
	 * labeled alternative in {@link FrartellParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolType(@NotNull FrartellParser.BoolTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringType}
	 * labeled alternative in {@link FrartellParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringType(@NotNull FrartellParser.StringTypeContext ctx);
}