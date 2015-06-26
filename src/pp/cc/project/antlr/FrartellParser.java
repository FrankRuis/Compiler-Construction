// Generated from C:/Development/Git/PPFinalProject/src/pp/cc/project/antlr\Frartell.g4 by ANTLR 4.5
package pp.cc.project.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FrartellParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TRUE=1, FALSE=2, IF=3, ELSE=4, WHILE=5, INT=6, BOOL=7, STR=8, DEF=9, RETURN=10, 
		MINUS=11, POW=12, MOD=13, PLUS=14, DIV=15, MULT=16, GREQ=17, LWEQ=18, 
		GR=19, LW=20, AND=21, OR=22, EQ=23, NEQ=24, NOT=25, ASSIGN=26, DOT=27, 
		QMARK=28, COLON=29, OPAR=30, CPAR=31, OBRACE=32, CBRACE=33, OSQ=34, CSQ=35, 
		SEMCOL=36, COMMA=37, ID=38, INTEGER=39, STRING=40, COMMENT=41, BLOCKCOMMENT=42, 
		WS=43;
	public static final int
		RULE_program = 0, RULE_stat = 1, RULE_expr = 2, RULE_target = 3, RULE_decl = 4, 
		RULE_declfunc = 5, RULE_decltarget = 6, RULE_block = 7, RULE_args = 8, 
		RULE_pars = 9, RULE_atom = 10, RULE_type = 11;
	public static final String[] ruleNames = {
		"program", "stat", "expr", "target", "decl", "declfunc", "decltarget", 
		"block", "args", "pars", "atom", "type"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'True'", "'False'", "'if'", "'else'", "'while'", "'int'", "'bool'", 
		"'String'", "'def'", "'return'", "'-'", "'^'", "'%'", "'+'", "'/'", "'*'", 
		"'>='", "'<='", "'>'", "'<'", "'&&'", "'||'", "'=='", "'!='", "'!'", "'='", 
		"'.'", "'?'", "':'", "'('", "')'", "'{'", "'}'", "'['", "']'", "';'", 
		"','"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "TRUE", "FALSE", "IF", "ELSE", "WHILE", "INT", "BOOL", "STR", "DEF", 
		"RETURN", "MINUS", "POW", "MOD", "PLUS", "DIV", "MULT", "GREQ", "LWEQ", 
		"GR", "LW", "AND", "OR", "EQ", "NEQ", "NOT", "ASSIGN", "DOT", "QMARK", 
		"COLON", "OPAR", "CPAR", "OBRACE", "CBRACE", "OSQ", "CSQ", "SEMCOL", "COMMA", 
		"ID", "INTEGER", "STRING", "COMMENT", "BLOCKCOMMENT", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override
	@NotNull
	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Frartell.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public FrartellParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(FrartellParser.EOF, 0); }
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public List<DeclfuncContext> declfunc() {
			return getRuleContexts(DeclfuncContext.class);
		}
		public DeclfuncContext declfunc(int i) {
			return getRuleContext(DeclfuncContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FrartellVisitor ) return ((FrartellVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << INT) | (1L << BOOL) | (1L << STR) | (1L << DEF) | (1L << RETURN) | (1L << ID))) != 0)) {
				{
				setState(27);
				switch (_input.LA(1)) {
				case IF:
				case WHILE:
				case RETURN:
				case ID:
					{
					setState(24); 
					stat();
					}
					break;
				case INT:
				case BOOL:
				case STR:
					{
					setState(25); 
					decl();
					}
					break;
				case DEF:
					{
					setState(26); 
					declfunc();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(31);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(32); 
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatContext extends ParserRuleContext {
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
	 
		public StatContext() { }
		public void copyFrom(StatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IfStatContext extends StatContext {
		public TerminalNode IF() { return getToken(FrartellParser.IF, 0); }
		public TerminalNode OPAR() { return getToken(FrartellParser.OPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CPAR() { return getToken(FrartellParser.CPAR, 0); }
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(FrartellParser.ELSE, 0); }
		public IfStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).enterIfStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).exitIfStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FrartellVisitor ) return ((FrartellVisitor<? extends T>)visitor).visitIfStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FuncCalltStatContext extends StatContext {
		public TerminalNode ID() { return getToken(FrartellParser.ID, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public TerminalNode SEMCOL() { return getToken(FrartellParser.SEMCOL, 0); }
		public FuncCalltStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).enterFuncCalltStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).exitFuncCalltStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FrartellVisitor ) return ((FrartellVisitor<? extends T>)visitor).visitFuncCalltStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ReturnStatContext extends StatContext {
		public TerminalNode RETURN() { return getToken(FrartellParser.RETURN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMCOL() { return getToken(FrartellParser.SEMCOL, 0); }
		public ReturnStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).enterReturnStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).exitReturnStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FrartellVisitor ) return ((FrartellVisitor<? extends T>)visitor).visitReturnStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignStatContext extends StatContext {
		public TargetContext target() {
			return getRuleContext(TargetContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(FrartellParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMCOL() { return getToken(FrartellParser.SEMCOL, 0); }
		public AssignStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).enterAssignStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).exitAssignStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FrartellVisitor ) return ((FrartellVisitor<? extends T>)visitor).visitAssignStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WhileStatContext extends StatContext {
		public TerminalNode WHILE() { return getToken(FrartellParser.WHILE, 0); }
		public TerminalNode OPAR() { return getToken(FrartellParser.OPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CPAR() { return getToken(FrartellParser.CPAR, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public WhileStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).enterWhileStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).exitWhileStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FrartellVisitor ) return ((FrartellVisitor<? extends T>)visitor).visitWhileStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stat);
		int _la;
		try {
			setState(62);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new AssignStatContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(34); 
				target();
				setState(35); 
				match(ASSIGN);
				setState(36); 
				expr(0);
				setState(37); 
				match(SEMCOL);
				}
				break;
			case 2:
				_localctx = new IfStatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(39); 
				match(IF);
				setState(40); 
				match(OPAR);
				setState(41); 
				expr(0);
				setState(42); 
				match(CPAR);
				setState(43); 
				block();
				setState(46);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(44); 
					match(ELSE);
					setState(45); 
					block();
					}
				}

				}
				break;
			case 3:
				_localctx = new WhileStatContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(48); 
				match(WHILE);
				setState(49); 
				match(OPAR);
				setState(50); 
				expr(0);
				setState(51); 
				match(CPAR);
				setState(52); 
				block();
				}
				break;
			case 4:
				_localctx = new FuncCalltStatContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(54); 
				match(ID);
				setState(55); 
				args();
				setState(56); 
				match(SEMCOL);
				}
				break;
			case 5:
				_localctx = new ReturnStatContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(58); 
				match(RETURN);
				setState(59); 
				expr(0);
				setState(60); 
				match(SEMCOL);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ArrayExprContext extends ExprContext {
		public TerminalNode OSQ() { return getToken(FrartellParser.OSQ, 0); }
		public TerminalNode CSQ() { return getToken(FrartellParser.CSQ, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(FrartellParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FrartellParser.COMMA, i);
		}
		public ArrayExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).enterArrayExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).exitArrayExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FrartellVisitor ) return ((FrartellVisitor<? extends T>)visitor).visitArrayExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AtomExprContext extends ExprContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public AtomExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).enterAtomExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).exitAtomExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FrartellVisitor ) return ((FrartellVisitor<? extends T>)visitor).visitAtomExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FuncCallExprContext extends ExprContext {
		public TerminalNode ID() { return getToken(FrartellParser.ID, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public FuncCallExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).enterFuncCallExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).exitFuncCallExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FrartellVisitor ) return ((FrartellVisitor<? extends T>)visitor).visitFuncCallExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MULT() { return getToken(FrartellParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(FrartellParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(FrartellParser.MOD, 0); }
		public MultExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).enterMultExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).exitMultExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FrartellVisitor ) return ((FrartellVisitor<? extends T>)visitor).visitMultExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IndexExprContext extends ExprContext {
		public TerminalNode ID() { return getToken(FrartellParser.ID, 0); }
		public TerminalNode OSQ() { return getToken(FrartellParser.OSQ, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CSQ() { return getToken(FrartellParser.CSQ, 0); }
		public IndexExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).enterIndexExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).exitIndexExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FrartellVisitor ) return ((FrartellVisitor<? extends T>)visitor).visitIndexExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode EQ() { return getToken(FrartellParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(FrartellParser.NEQ, 0); }
		public EqExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).enterEqExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).exitEqExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FrartellVisitor ) return ((FrartellVisitor<? extends T>)visitor).visitEqExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotExprContext extends ExprContext {
		public TerminalNode NOT() { return getToken(FrartellParser.NOT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NotExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).enterNotExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).exitNotExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FrartellVisitor ) return ((FrartellVisitor<? extends T>)visitor).visitNotExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnaryMinExprContext extends ExprContext {
		public TerminalNode MINUS() { return getToken(FrartellParser.MINUS, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public UnaryMinExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).enterUnaryMinExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).exitUnaryMinExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FrartellVisitor ) return ((FrartellVisitor<? extends T>)visitor).visitUnaryMinExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(FrartellParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(FrartellParser.MINUS, 0); }
		public AddExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).enterAddExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).exitAddExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FrartellVisitor ) return ((FrartellVisitor<? extends T>)visitor).visitAddExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TernExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode QMARK() { return getToken(FrartellParser.QMARK, 0); }
		public TerminalNode COLON() { return getToken(FrartellParser.COLON, 0); }
		public TernExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).enterTernExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).exitTernExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FrartellVisitor ) return ((FrartellVisitor<? extends T>)visitor).visitTernExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CompExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LW() { return getToken(FrartellParser.LW, 0); }
		public TerminalNode GR() { return getToken(FrartellParser.GR, 0); }
		public TerminalNode GREQ() { return getToken(FrartellParser.GREQ, 0); }
		public TerminalNode LWEQ() { return getToken(FrartellParser.LWEQ, 0); }
		public CompExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).enterCompExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).exitCompExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FrartellVisitor ) return ((FrartellVisitor<? extends T>)visitor).visitCompExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PowExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode POW() { return getToken(FrartellParser.POW, 0); }
		public PowExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).enterPowExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).exitPowExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FrartellVisitor ) return ((FrartellVisitor<? extends T>)visitor).visitPowExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode AND() { return getToken(FrartellParser.AND, 0); }
		public TerminalNode OR() { return getToken(FrartellParser.OR, 0); }
		public BoolExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).enterBoolExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).exitBoolExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FrartellVisitor ) return ((FrartellVisitor<? extends T>)visitor).visitBoolExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				_localctx = new UnaryMinExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(65); 
				match(MINUS);
				setState(66); 
				expr(13);
				}
				break;
			case 2:
				{
				_localctx = new NotExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(67); 
				match(NOT);
				setState(68); 
				expr(12);
				}
				break;
			case 3:
				{
				_localctx = new FuncCallExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(69); 
				match(ID);
				setState(70); 
				args();
				}
				break;
			case 4:
				{
				_localctx = new IndexExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(71); 
				match(ID);
				setState(72); 
				match(OSQ);
				setState(73); 
				expr(0);
				setState(74); 
				match(CSQ);
				}
				break;
			case 5:
				{
				_localctx = new ArrayExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(76); 
				match(OSQ);
				setState(85);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << MINUS) | (1L << NOT) | (1L << OPAR) | (1L << OSQ) | (1L << ID) | (1L << INTEGER) | (1L << STRING))) != 0)) {
					{
					setState(77); 
					expr(0);
					setState(82);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(78); 
						match(COMMA);
						setState(79); 
						expr(0);
						}
						}
						setState(84);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(87); 
				match(CSQ);
				}
				break;
			case 6:
				{
				_localctx = new AtomExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(88); 
				atom();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(117);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(115);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new TernExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(91);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(92); 
						match(QMARK);
						setState(93); 
						expr(0);
						setState(94); 
						match(COLON);
						setState(95); 
						expr(11);
						}
						break;
					case 2:
						{
						_localctx = new MultExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(97);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(98);
						((MultExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MOD) | (1L << DIV) | (1L << MULT))) != 0)) ) {
							((MultExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(99); 
						expr(10);
						}
						break;
					case 3:
						{
						_localctx = new PowExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(100);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(101); 
						match(POW);
						setState(102); 
						expr(9);
						}
						break;
					case 4:
						{
						_localctx = new AddExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(103);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(104);
						((AddExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MINUS || _la==PLUS) ) {
							((AddExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(105); 
						expr(8);
						}
						break;
					case 5:
						{
						_localctx = new EqExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(106);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(107);
						((EqExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQ || _la==NEQ) ) {
							((EqExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(108); 
						expr(7);
						}
						break;
					case 6:
						{
						_localctx = new CompExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(109);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(110);
						((CompExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GREQ) | (1L << LWEQ) | (1L << GR) | (1L << LW))) != 0)) ) {
							((CompExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(111); 
						expr(6);
						}
						break;
					case 7:
						{
						_localctx = new BoolExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(112);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(113);
						((BoolExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==AND || _la==OR) ) {
							((BoolExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(114); 
						expr(5);
						}
						break;
					}
					} 
				}
				setState(119);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class TargetContext extends ParserRuleContext {
		public TargetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_target; }
	 
		public TargetContext() { }
		public void copyFrom(TargetContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IdTargetContext extends TargetContext {
		public TerminalNode ID() { return getToken(FrartellParser.ID, 0); }
		public IdTargetContext(TargetContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).enterIdTarget(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).exitIdTarget(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FrartellVisitor ) return ((FrartellVisitor<? extends T>)visitor).visitIdTarget(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayTargetContext extends TargetContext {
		public TerminalNode ID() { return getToken(FrartellParser.ID, 0); }
		public TerminalNode OSQ() { return getToken(FrartellParser.OSQ, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CSQ() { return getToken(FrartellParser.CSQ, 0); }
		public ArrayTargetContext(TargetContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).enterArrayTarget(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).exitArrayTarget(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FrartellVisitor ) return ((FrartellVisitor<? extends T>)visitor).visitArrayTarget(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TargetContext target() throws RecognitionException {
		TargetContext _localctx = new TargetContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_target);
		try {
			setState(126);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				_localctx = new IdTargetContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(120); 
				match(ID);
				}
				break;
			case 2:
				_localctx = new ArrayTargetContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(121); 
				match(ID);
				setState(122); 
				match(OSQ);
				setState(123); 
				expr(0);
				setState(124); 
				match(CSQ);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public DecltargetContext decltarget() {
			return getRuleContext(DecltargetContext.class,0);
		}
		public TerminalNode SEMCOL() { return getToken(FrartellParser.SEMCOL, 0); }
		public TerminalNode ASSIGN() { return getToken(FrartellParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).exitDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FrartellVisitor ) return ((FrartellVisitor<? extends T>)visitor).visitDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128); 
			type();
			setState(129); 
			decltarget();
			setState(132);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(130); 
				match(ASSIGN);
				setState(131); 
				expr(0);
				}
			}

			setState(134); 
			match(SEMCOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclfuncContext extends ParserRuleContext {
		public TerminalNode DEF() { return getToken(FrartellParser.DEF, 0); }
		public TerminalNode ID() { return getToken(FrartellParser.ID, 0); }
		public ParsContext pars() {
			return getRuleContext(ParsContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public DeclfuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declfunc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).enterDeclfunc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).exitDeclfunc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FrartellVisitor ) return ((FrartellVisitor<? extends T>)visitor).visitDeclfunc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclfuncContext declfunc() throws RecognitionException {
		DeclfuncContext _localctx = new DeclfuncContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_declfunc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136); 
			match(DEF);
			setState(137); 
			match(ID);
			setState(138); 
			pars();
			setState(139); 
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DecltargetContext extends ParserRuleContext {
		public DecltargetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decltarget; }
	 
		public DecltargetContext() { }
		public void copyFrom(DecltargetContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ArrayDeclTargetContext extends DecltargetContext {
		public TerminalNode ID() { return getToken(FrartellParser.ID, 0); }
		public TerminalNode OSQ() { return getToken(FrartellParser.OSQ, 0); }
		public TerminalNode INTEGER() { return getToken(FrartellParser.INTEGER, 0); }
		public TerminalNode CSQ() { return getToken(FrartellParser.CSQ, 0); }
		public ArrayDeclTargetContext(DecltargetContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).enterArrayDeclTarget(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).exitArrayDeclTarget(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FrartellVisitor ) return ((FrartellVisitor<? extends T>)visitor).visitArrayDeclTarget(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdDeclTargetContext extends DecltargetContext {
		public TerminalNode ID() { return getToken(FrartellParser.ID, 0); }
		public IdDeclTargetContext(DecltargetContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).enterIdDeclTarget(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).exitIdDeclTarget(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FrartellVisitor ) return ((FrartellVisitor<? extends T>)visitor).visitIdDeclTarget(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecltargetContext decltarget() throws RecognitionException {
		DecltargetContext _localctx = new DecltargetContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_decltarget);
		try {
			setState(146);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				_localctx = new IdDeclTargetContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(141); 
				match(ID);
				}
				break;
			case 2:
				_localctx = new ArrayDeclTargetContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(142); 
				match(ID);
				setState(143); 
				match(OSQ);
				setState(144); 
				match(INTEGER);
				setState(145); 
				match(CSQ);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public TerminalNode OBRACE() { return getToken(FrartellParser.OBRACE, 0); }
		public TerminalNode CBRACE() { return getToken(FrartellParser.CBRACE, 0); }
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FrartellVisitor ) return ((FrartellVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148); 
			match(OBRACE);
			setState(153);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << INT) | (1L << BOOL) | (1L << STR) | (1L << RETURN) | (1L << ID))) != 0)) {
				{
				setState(151);
				switch (_input.LA(1)) {
				case IF:
				case WHILE:
				case RETURN:
				case ID:
					{
					setState(149); 
					stat();
					}
					break;
				case INT:
				case BOOL:
				case STR:
					{
					setState(150); 
					decl();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(155);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(156); 
			match(CBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgsContext extends ParserRuleContext {
		public TerminalNode OPAR() { return getToken(FrartellParser.OPAR, 0); }
		public TerminalNode CPAR() { return getToken(FrartellParser.CPAR, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(FrartellParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FrartellParser.COMMA, i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).enterArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).exitArgs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FrartellVisitor ) return ((FrartellVisitor<? extends T>)visitor).visitArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158); 
			match(OPAR);
			setState(167);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << MINUS) | (1L << NOT) | (1L << OPAR) | (1L << OSQ) | (1L << ID) | (1L << INTEGER) | (1L << STRING))) != 0)) {
				{
				setState(159); 
				expr(0);
				setState(164);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(160); 
					match(COMMA);
					setState(161); 
					expr(0);
					}
					}
					setState(166);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(169); 
			match(CPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParsContext extends ParserRuleContext {
		public TerminalNode OPAR() { return getToken(FrartellParser.OPAR, 0); }
		public TerminalNode CPAR() { return getToken(FrartellParser.CPAR, 0); }
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TerminalNode> ID() { return getTokens(FrartellParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(FrartellParser.ID, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(FrartellParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FrartellParser.COMMA, i);
		}
		public ParsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pars; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).enterPars(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).exitPars(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FrartellVisitor ) return ((FrartellVisitor<? extends T>)visitor).visitPars(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParsContext pars() throws RecognitionException {
		ParsContext _localctx = new ParsContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_pars);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171); 
			match(OPAR);
			setState(183);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << STR))) != 0)) {
				{
				setState(172); 
				type();
				setState(173); 
				match(ID);
				setState(180);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(174); 
					match(COMMA);
					setState(175); 
					type();
					setState(176); 
					match(ID);
					}
					}
					setState(182);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(185); 
			match(CPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtomContext extends ParserRuleContext {
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
	 
		public AtomContext() { }
		public void copyFrom(AtomContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IdAtomContext extends AtomContext {
		public TerminalNode ID() { return getToken(FrartellParser.ID, 0); }
		public IdAtomContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).enterIdAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).exitIdAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FrartellVisitor ) return ((FrartellVisitor<? extends T>)visitor).visitIdAtom(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntAtomContext extends AtomContext {
		public TerminalNode INTEGER() { return getToken(FrartellParser.INTEGER, 0); }
		public IntAtomContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).enterIntAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).exitIntAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FrartellVisitor ) return ((FrartellVisitor<? extends T>)visitor).visitIntAtom(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringAtomContext extends AtomContext {
		public TerminalNode STRING() { return getToken(FrartellParser.STRING, 0); }
		public StringAtomContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).enterStringAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).exitStringAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FrartellVisitor ) return ((FrartellVisitor<? extends T>)visitor).visitStringAtom(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolAtomContext extends AtomContext {
		public TerminalNode TRUE() { return getToken(FrartellParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(FrartellParser.FALSE, 0); }
		public BoolAtomContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).enterBoolAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).exitBoolAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FrartellVisitor ) return ((FrartellVisitor<? extends T>)visitor).visitBoolAtom(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParExprAtomContext extends AtomContext {
		public TerminalNode OPAR() { return getToken(FrartellParser.OPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CPAR() { return getToken(FrartellParser.CPAR, 0); }
		public ParExprAtomContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).enterParExprAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).exitParExprAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FrartellVisitor ) return ((FrartellVisitor<? extends T>)visitor).visitParExprAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_atom);
		int _la;
		try {
			setState(195);
			switch (_input.LA(1)) {
			case OPAR:
				_localctx = new ParExprAtomContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(187); 
				match(OPAR);
				setState(188); 
				expr(0);
				setState(189); 
				match(CPAR);
				}
				break;
			case INTEGER:
				_localctx = new IntAtomContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(191); 
				match(INTEGER);
				}
				break;
			case TRUE:
			case FALSE:
				_localctx = new BoolAtomContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(192);
				_la = _input.LA(1);
				if ( !(_la==TRUE || _la==FALSE) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case ID:
				_localctx = new IdAtomContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(193); 
				match(ID);
				}
				break;
			case STRING:
				_localctx = new StringAtomContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(194); 
				match(STRING);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	 
		public TypeContext() { }
		public void copyFrom(TypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IntTypeContext extends TypeContext {
		public TerminalNode INT() { return getToken(FrartellParser.INT, 0); }
		public IntTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).enterIntType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).exitIntType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FrartellVisitor ) return ((FrartellVisitor<? extends T>)visitor).visitIntType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringTypeContext extends TypeContext {
		public TerminalNode STR() { return getToken(FrartellParser.STR, 0); }
		public StringTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).enterStringType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).exitStringType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FrartellVisitor ) return ((FrartellVisitor<? extends T>)visitor).visitStringType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolTypeContext extends TypeContext {
		public TerminalNode BOOL() { return getToken(FrartellParser.BOOL, 0); }
		public BoolTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).enterBoolType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).exitBoolType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FrartellVisitor ) return ((FrartellVisitor<? extends T>)visitor).visitBoolType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_type);
		try {
			setState(200);
			switch (_input.LA(1)) {
			case INT:
				_localctx = new IntTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(197); 
				match(INT);
				}
				break;
			case BOOL:
				_localctx = new BoolTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(198); 
				match(BOOL);
				}
				break;
			case STR:
				_localctx = new StringTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(199); 
				match(STR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 2: 
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: 
			return precpred(_ctx, 11);
		case 1: 
			return precpred(_ctx, 9);
		case 2: 
			return precpred(_ctx, 8);
		case 3: 
			return precpred(_ctx, 7);
		case 4: 
			return precpred(_ctx, 6);
		case 5: 
			return precpred(_ctx, 5);
		case 6: 
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3-\u00cd\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\7\2\36\n\2\f\2\16\2!\13\2\3\2\3\2\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\61\n\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3A\n\3\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4S\n\4\f\4\16\4V\13\4"+
		"\5\4X\n\4\3\4\3\4\5\4\\\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4v\n\4\f\4\16"+
		"\4y\13\4\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u0081\n\5\3\6\3\6\3\6\3\6\5\6\u0087"+
		"\n\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\5\b\u0095\n\b\3\t"+
		"\3\t\3\t\7\t\u009a\n\t\f\t\16\t\u009d\13\t\3\t\3\t\3\n\3\n\3\n\3\n\7\n"+
		"\u00a5\n\n\f\n\16\n\u00a8\13\n\5\n\u00aa\n\n\3\n\3\n\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\7\13\u00b5\n\13\f\13\16\13\u00b8\13\13\5\13\u00ba\n"+
		"\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00c6\n\f\3\r\3\r\3"+
		"\r\5\r\u00cb\n\r\3\r\2\3\6\16\2\4\6\b\n\f\16\20\22\24\26\30\2\b\4\2\17"+
		"\17\21\22\4\2\r\r\20\20\3\2\31\32\3\2\23\26\3\2\27\30\3\2\3\4\u00e5\2"+
		"\37\3\2\2\2\4@\3\2\2\2\6[\3\2\2\2\b\u0080\3\2\2\2\n\u0082\3\2\2\2\f\u008a"+
		"\3\2\2\2\16\u0094\3\2\2\2\20\u0096\3\2\2\2\22\u00a0\3\2\2\2\24\u00ad\3"+
		"\2\2\2\26\u00c5\3\2\2\2\30\u00ca\3\2\2\2\32\36\5\4\3\2\33\36\5\n\6\2\34"+
		"\36\5\f\7\2\35\32\3\2\2\2\35\33\3\2\2\2\35\34\3\2\2\2\36!\3\2\2\2\37\35"+
		"\3\2\2\2\37 \3\2\2\2 \"\3\2\2\2!\37\3\2\2\2\"#\7\2\2\3#\3\3\2\2\2$%\5"+
		"\b\5\2%&\7\34\2\2&\'\5\6\4\2\'(\7&\2\2(A\3\2\2\2)*\7\5\2\2*+\7 \2\2+,"+
		"\5\6\4\2,-\7!\2\2-\60\5\20\t\2./\7\6\2\2/\61\5\20\t\2\60.\3\2\2\2\60\61"+
		"\3\2\2\2\61A\3\2\2\2\62\63\7\7\2\2\63\64\7 \2\2\64\65\5\6\4\2\65\66\7"+
		"!\2\2\66\67\5\20\t\2\67A\3\2\2\289\7(\2\29:\5\22\n\2:;\7&\2\2;A\3\2\2"+
		"\2<=\7\f\2\2=>\5\6\4\2>?\7&\2\2?A\3\2\2\2@$\3\2\2\2@)\3\2\2\2@\62\3\2"+
		"\2\2@8\3\2\2\2@<\3\2\2\2A\5\3\2\2\2BC\b\4\1\2CD\7\r\2\2D\\\5\6\4\17EF"+
		"\7\33\2\2F\\\5\6\4\16GH\7(\2\2H\\\5\22\n\2IJ\7(\2\2JK\7$\2\2KL\5\6\4\2"+
		"LM\7%\2\2M\\\3\2\2\2NW\7$\2\2OT\5\6\4\2PQ\7\'\2\2QS\5\6\4\2RP\3\2\2\2"+
		"SV\3\2\2\2TR\3\2\2\2TU\3\2\2\2UX\3\2\2\2VT\3\2\2\2WO\3\2\2\2WX\3\2\2\2"+
		"XY\3\2\2\2Y\\\7%\2\2Z\\\5\26\f\2[B\3\2\2\2[E\3\2\2\2[G\3\2\2\2[I\3\2\2"+
		"\2[N\3\2\2\2[Z\3\2\2\2\\w\3\2\2\2]^\f\r\2\2^_\7\36\2\2_`\5\6\4\2`a\7\37"+
		"\2\2ab\5\6\4\rbv\3\2\2\2cd\f\13\2\2de\t\2\2\2ev\5\6\4\ffg\f\n\2\2gh\7"+
		"\16\2\2hv\5\6\4\13ij\f\t\2\2jk\t\3\2\2kv\5\6\4\nlm\f\b\2\2mn\t\4\2\2n"+
		"v\5\6\4\top\f\7\2\2pq\t\5\2\2qv\5\6\4\brs\f\6\2\2st\t\6\2\2tv\5\6\4\7"+
		"u]\3\2\2\2uc\3\2\2\2uf\3\2\2\2ui\3\2\2\2ul\3\2\2\2uo\3\2\2\2ur\3\2\2\2"+
		"vy\3\2\2\2wu\3\2\2\2wx\3\2\2\2x\7\3\2\2\2yw\3\2\2\2z\u0081\7(\2\2{|\7"+
		"(\2\2|}\7$\2\2}~\5\6\4\2~\177\7%\2\2\177\u0081\3\2\2\2\u0080z\3\2\2\2"+
		"\u0080{\3\2\2\2\u0081\t\3\2\2\2\u0082\u0083\5\30\r\2\u0083\u0086\5\16"+
		"\b\2\u0084\u0085\7\34\2\2\u0085\u0087\5\6\4\2\u0086\u0084\3\2\2\2\u0086"+
		"\u0087\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u0089\7&\2\2\u0089\13\3\2\2\2"+
		"\u008a\u008b\7\13\2\2\u008b\u008c\7(\2\2\u008c\u008d\5\24\13\2\u008d\u008e"+
		"\5\20\t\2\u008e\r\3\2\2\2\u008f\u0095\7(\2\2\u0090\u0091\7(\2\2\u0091"+
		"\u0092\7$\2\2\u0092\u0093\7)\2\2\u0093\u0095\7%\2\2\u0094\u008f\3\2\2"+
		"\2\u0094\u0090\3\2\2\2\u0095\17\3\2\2\2\u0096\u009b\7\"\2\2\u0097\u009a"+
		"\5\4\3\2\u0098\u009a\5\n\6\2\u0099\u0097\3\2\2\2\u0099\u0098\3\2\2\2\u009a"+
		"\u009d\3\2\2\2\u009b\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009e\3\2"+
		"\2\2\u009d\u009b\3\2\2\2\u009e\u009f\7#\2\2\u009f\21\3\2\2\2\u00a0\u00a9"+
		"\7 \2\2\u00a1\u00a6\5\6\4\2\u00a2\u00a3\7\'\2\2\u00a3\u00a5\5\6\4\2\u00a4"+
		"\u00a2\3\2\2\2\u00a5\u00a8\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a6\u00a7\3\2"+
		"\2\2\u00a7\u00aa\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a9\u00a1\3\2\2\2\u00a9"+
		"\u00aa\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ac\7!\2\2\u00ac\23\3\2\2\2"+
		"\u00ad\u00b9\7 \2\2\u00ae\u00af\5\30\r\2\u00af\u00b6\7(\2\2\u00b0\u00b1"+
		"\7\'\2\2\u00b1\u00b2\5\30\r\2\u00b2\u00b3\7(\2\2\u00b3\u00b5\3\2\2\2\u00b4"+
		"\u00b0\3\2\2\2\u00b5\u00b8\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6\u00b7\3\2"+
		"\2\2\u00b7\u00ba\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b9\u00ae\3\2\2\2\u00b9"+
		"\u00ba\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00bc\7!\2\2\u00bc\25\3\2\2\2"+
		"\u00bd\u00be\7 \2\2\u00be\u00bf\5\6\4\2\u00bf\u00c0\7!\2\2\u00c0\u00c6"+
		"\3\2\2\2\u00c1\u00c6\7)\2\2\u00c2\u00c6\t\7\2\2\u00c3\u00c6\7(\2\2\u00c4"+
		"\u00c6\7*\2\2\u00c5\u00bd\3\2\2\2\u00c5\u00c1\3\2\2\2\u00c5\u00c2\3\2"+
		"\2\2\u00c5\u00c3\3\2\2\2\u00c5\u00c4\3\2\2\2\u00c6\27\3\2\2\2\u00c7\u00cb"+
		"\7\b\2\2\u00c8\u00cb\7\t\2\2\u00c9\u00cb\7\n\2\2\u00ca\u00c7\3\2\2\2\u00ca"+
		"\u00c8\3\2\2\2\u00ca\u00c9\3\2\2\2\u00cb\31\3\2\2\2\26\35\37\60@TW[uw"+
		"\u0080\u0086\u0094\u0099\u009b\u00a6\u00a9\u00b6\u00b9\u00c5\u00ca";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}