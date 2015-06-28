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
		PROGRAM=11, MINUS=12, POW=13, MOD=14, PLUS=15, DIV=16, MULT=17, GREQ=18, 
		LWEQ=19, GR=20, LW=21, AND=22, OR=23, EQ=24, NEQ=25, NOT=26, ASSIGN=27, 
		DOT=28, QMARK=29, COLON=30, OPAR=31, CPAR=32, OBRACE=33, CBRACE=34, OSQ=35, 
		CSQ=36, SEMCOL=37, COMMA=38, ID=39, INTEGER=40, STRING=41, COMMENT=42, 
		BLOCKCOMMENT=43, WS=44;
	public static final int
		RULE_program = 0, RULE_progname = 1, RULE_stat = 2, RULE_expr = 3, RULE_block = 4, 
		RULE_target = 5, RULE_decltarget = 6, RULE_declfunc = 7, RULE_pars = 8, 
		RULE_args = 9, RULE_atom = 10, RULE_type = 11;
	public static final String[] ruleNames = {
		"program", "progname", "stat", "expr", "block", "target", "decltarget", 
		"declfunc", "pars", "args", "atom", "type"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'True'", "'False'", "'if'", "'else'", "'while'", "'int'", "'bool'", 
		"'String'", "'def'", "'return'", "'program'", "'-'", "'^'", "'%'", "'+'", 
		"'/'", "'*'", "'>='", "'<='", "'>'", "'<'", "'&&'", "'||'", "'=='", "'!='", 
		"'!'", "'='", "'.'", "'?'", "':'", "'('", "')'", "'{'", "'}'", "'['", 
		"']'", "';'", "','"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "TRUE", "FALSE", "IF", "ELSE", "WHILE", "INT", "BOOL", "STR", "DEF", 
		"RETURN", "PROGRAM", "MINUS", "POW", "MOD", "PLUS", "DIV", "MULT", "GREQ", 
		"LWEQ", "GR", "LW", "AND", "OR", "EQ", "NEQ", "NOT", "ASSIGN", "DOT", 
		"QMARK", "COLON", "OPAR", "CPAR", "OBRACE", "CBRACE", "OSQ", "CSQ", "SEMCOL", 
		"COMMA", "ID", "INTEGER", "STRING", "COMMENT", "BLOCKCOMMENT", "WS"
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
		public PrognameContext progname() {
			return getRuleContext(PrognameContext.class,0);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
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
			setState(25);
			_la = _input.LA(1);
			if (_la==PROGRAM) {
				{
				setState(24); 
				progname();
				}
			}

			setState(31);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << INT) | (1L << BOOL) | (1L << STR) | (1L << DEF) | (1L << RETURN) | (1L << OBRACE) | (1L << ID))) != 0)) {
				{
				setState(29);
				switch (_input.LA(1)) {
				case IF:
				case WHILE:
				case INT:
				case BOOL:
				case STR:
				case RETURN:
				case OBRACE:
				case ID:
					{
					setState(27); 
					stat();
					}
					break;
				case DEF:
					{
					setState(28); 
					declfunc();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(33);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(34); 
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

	public static class PrognameContext extends ParserRuleContext {
		public TerminalNode PROGRAM() { return getToken(FrartellParser.PROGRAM, 0); }
		public TerminalNode ID() { return getToken(FrartellParser.ID, 0); }
		public TerminalNode SEMCOL() { return getToken(FrartellParser.SEMCOL, 0); }
		public PrognameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_progname; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).enterProgname(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).exitProgname(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FrartellVisitor ) return ((FrartellVisitor<? extends T>)visitor).visitProgname(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrognameContext progname() throws RecognitionException {
		PrognameContext _localctx = new PrognameContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_progname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36); 
			match(PROGRAM);
			setState(37); 
			match(ID);
			setState(38); 
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
	public static class BlockStatContext extends StatContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public BlockStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).enterBlockStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).exitBlockStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FrartellVisitor ) return ((FrartellVisitor<? extends T>)visitor).visitBlockStat(this);
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
	public static class DeclStatContext extends StatContext {
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
		public DeclStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).enterDeclStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FrartellListener ) ((FrartellListener)listener).exitDeclStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FrartellVisitor ) return ((FrartellVisitor<? extends T>)visitor).visitDeclStat(this);
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
		enterRule(_localctx, 4, RULE_stat);
		int _la;
		try {
			setState(77);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new AssignStatContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(40); 
				target();
				setState(41); 
				match(ASSIGN);
				setState(42); 
				expr(0);
				setState(43); 
				match(SEMCOL);
				}
				break;
			case 2:
				_localctx = new DeclStatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(45); 
				type();
				setState(46); 
				decltarget();
				setState(49);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(47); 
					match(ASSIGN);
					setState(48); 
					expr(0);
					}
				}

				setState(51); 
				match(SEMCOL);
				}
				break;
			case 3:
				_localctx = new IfStatContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(53); 
				match(IF);
				setState(54); 
				match(OPAR);
				setState(55); 
				expr(0);
				setState(56); 
				match(CPAR);
				setState(57); 
				block();
				setState(60);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(58); 
					match(ELSE);
					setState(59); 
					block();
					}
				}

				}
				break;
			case 4:
				_localctx = new WhileStatContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(62); 
				match(WHILE);
				setState(63); 
				match(OPAR);
				setState(64); 
				expr(0);
				setState(65); 
				match(CPAR);
				setState(66); 
				block();
				}
				break;
			case 5:
				_localctx = new FuncCalltStatContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(68); 
				match(ID);
				setState(69); 
				args();
				setState(70); 
				match(SEMCOL);
				}
				break;
			case 6:
				_localctx = new ReturnStatContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(72); 
				match(RETURN);
				setState(73); 
				expr(0);
				setState(74); 
				match(SEMCOL);
				}
				break;
			case 7:
				_localctx = new BlockStatContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(76); 
				block();
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
		public List<TerminalNode> OPAR() { return getTokens(FrartellParser.OPAR); }
		public TerminalNode OPAR(int i) {
			return getToken(FrartellParser.OPAR, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> CPAR() { return getTokens(FrartellParser.CPAR); }
		public TerminalNode CPAR(int i) {
			return getToken(FrartellParser.CPAR, i);
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
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				_localctx = new UnaryMinExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(80); 
				match(MINUS);
				setState(81); 
				expr(13);
				}
				break;
			case 2:
				{
				_localctx = new NotExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(82); 
				match(NOT);
				setState(83); 
				expr(12);
				}
				break;
			case 3:
				{
				_localctx = new TernExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(84); 
				match(OPAR);
				setState(85); 
				expr(0);
				setState(86); 
				match(CPAR);
				setState(87); 
				match(QMARK);
				setState(88); 
				match(OPAR);
				setState(89); 
				expr(0);
				setState(90); 
				match(CPAR);
				setState(91); 
				match(COLON);
				setState(92); 
				match(OPAR);
				setState(93); 
				expr(0);
				setState(94); 
				match(CPAR);
				}
				break;
			case 4:
				{
				_localctx = new FuncCallExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(96); 
				match(ID);
				setState(97); 
				args();
				}
				break;
			case 5:
				{
				_localctx = new IndexExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(98); 
				match(ID);
				setState(99); 
				match(OSQ);
				setState(100); 
				expr(0);
				setState(101); 
				match(CSQ);
				}
				break;
			case 6:
				{
				_localctx = new ArrayExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(103); 
				match(OSQ);
				setState(112);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << MINUS) | (1L << NOT) | (1L << OPAR) | (1L << OSQ) | (1L << ID) | (1L << INTEGER) | (1L << STRING))) != 0)) {
					{
					setState(104); 
					expr(0);
					setState(109);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(105); 
						match(COMMA);
						setState(106); 
						expr(0);
						}
						}
						setState(111);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(114); 
				match(CSQ);
				}
				break;
			case 7:
				{
				_localctx = new AtomExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(115); 
				atom();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(138);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(136);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new MultExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(118);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(119);
						((MultExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MOD) | (1L << DIV) | (1L << MULT))) != 0)) ) {
							((MultExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(120); 
						expr(10);
						}
						break;
					case 2:
						{
						_localctx = new PowExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(121);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(122); 
						match(POW);
						setState(123); 
						expr(9);
						}
						break;
					case 3:
						{
						_localctx = new AddExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(124);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(125);
						((AddExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MINUS || _la==PLUS) ) {
							((AddExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(126); 
						expr(8);
						}
						break;
					case 4:
						{
						_localctx = new EqExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(127);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(128);
						((EqExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQ || _la==NEQ) ) {
							((EqExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(129); 
						expr(7);
						}
						break;
					case 5:
						{
						_localctx = new CompExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(130);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(131);
						((CompExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GREQ) | (1L << LWEQ) | (1L << GR) | (1L << LW))) != 0)) ) {
							((CompExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(132); 
						expr(6);
						}
						break;
					case 6:
						{
						_localctx = new BoolExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(133);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(134);
						((BoolExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==AND || _la==OR) ) {
							((BoolExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(135); 
						expr(5);
						}
						break;
					}
					} 
				}
				setState(140);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
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

	public static class BlockContext extends ParserRuleContext {
		public TerminalNode OBRACE() { return getToken(FrartellParser.OBRACE, 0); }
		public TerminalNode CBRACE() { return getToken(FrartellParser.CBRACE, 0); }
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
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
		enterRule(_localctx, 8, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141); 
			match(OBRACE);
			setState(145);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << INT) | (1L << BOOL) | (1L << STR) | (1L << RETURN) | (1L << OBRACE) | (1L << ID))) != 0)) {
				{
				{
				setState(142); 
				stat();
				}
				}
				setState(147);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(148); 
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
		enterRule(_localctx, 10, RULE_target);
		try {
			setState(156);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				_localctx = new IdTargetContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(150); 
				match(ID);
				}
				break;
			case 2:
				_localctx = new ArrayTargetContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(151); 
				match(ID);
				setState(152); 
				match(OSQ);
				setState(153); 
				expr(0);
				setState(154); 
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
			setState(163);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				_localctx = new IdDeclTargetContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(158); 
				match(ID);
				}
				break;
			case 2:
				_localctx = new ArrayDeclTargetContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(159); 
				match(ID);
				setState(160); 
				match(OSQ);
				setState(161); 
				match(INTEGER);
				setState(162); 
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
		enterRule(_localctx, 14, RULE_declfunc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165); 
			match(DEF);
			setState(166); 
			match(ID);
			setState(167); 
			pars();
			setState(168); 
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
		enterRule(_localctx, 16, RULE_pars);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170); 
			match(OPAR);
			setState(182);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << STR))) != 0)) {
				{
				setState(171); 
				type();
				setState(172); 
				match(ID);
				setState(179);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(173); 
					match(COMMA);
					setState(174); 
					type();
					setState(175); 
					match(ID);
					}
					}
					setState(181);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(184); 
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
		enterRule(_localctx, 18, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186); 
			match(OPAR);
			setState(195);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << MINUS) | (1L << NOT) | (1L << OPAR) | (1L << OSQ) | (1L << ID) | (1L << INTEGER) | (1L << STRING))) != 0)) {
				{
				setState(187); 
				expr(0);
				setState(192);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(188); 
					match(COMMA);
					setState(189); 
					expr(0);
					}
					}
					setState(194);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(197); 
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
			setState(207);
			switch (_input.LA(1)) {
			case OPAR:
				_localctx = new ParExprAtomContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(199); 
				match(OPAR);
				setState(200); 
				expr(0);
				setState(201); 
				match(CPAR);
				}
				break;
			case INTEGER:
				_localctx = new IntAtomContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(203); 
				match(INTEGER);
				}
				break;
			case TRUE:
			case FALSE:
				_localctx = new BoolAtomContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(204);
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
				setState(205); 
				match(ID);
				}
				break;
			case STRING:
				_localctx = new StringAtomContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(206); 
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
			setState(212);
			switch (_input.LA(1)) {
			case INT:
				_localctx = new IntTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(209); 
				match(INT);
				}
				break;
			case BOOL:
				_localctx = new BoolTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(210); 
				match(BOOL);
				}
				break;
			case STR:
				_localctx = new StringTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(211); 
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
		case 3: 
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: 
			return precpred(_ctx, 9);
		case 1: 
			return precpred(_ctx, 8);
		case 2: 
			return precpred(_ctx, 7);
		case 3: 
			return precpred(_ctx, 6);
		case 4: 
			return precpred(_ctx, 5);
		case 5: 
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3.\u00d9\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\5\2\34\n\2\3\2\3\2\7\2 \n\2\f\2\16\2#\13\2\3\2"+
		"\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\64\n\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4?\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4P\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\7\5n\n\5\f\5\16\5q\13\5\5\5s\n\5\3\5\3\5\5\5w\n\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7"+
		"\5\u008b\n\5\f\5\16\5\u008e\13\5\3\6\3\6\7\6\u0092\n\6\f\6\16\6\u0095"+
		"\13\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u009f\n\7\3\b\3\b\3\b\3\b\3"+
		"\b\5\b\u00a6\n\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u00b4"+
		"\n\n\f\n\16\n\u00b7\13\n\5\n\u00b9\n\n\3\n\3\n\3\13\3\13\3\13\3\13\7\13"+
		"\u00c1\n\13\f\13\16\13\u00c4\13\13\5\13\u00c6\n\13\3\13\3\13\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\5\f\u00d2\n\f\3\r\3\r\3\r\5\r\u00d7\n\r\3\r\2\3"+
		"\b\16\2\4\6\b\n\f\16\20\22\24\26\30\2\b\4\2\20\20\22\23\4\2\16\16\21\21"+
		"\3\2\32\33\3\2\24\27\3\2\30\31\3\2\3\4\u00f2\2\33\3\2\2\2\4&\3\2\2\2\6"+
		"O\3\2\2\2\bv\3\2\2\2\n\u008f\3\2\2\2\f\u009e\3\2\2\2\16\u00a5\3\2\2\2"+
		"\20\u00a7\3\2\2\2\22\u00ac\3\2\2\2\24\u00bc\3\2\2\2\26\u00d1\3\2\2\2\30"+
		"\u00d6\3\2\2\2\32\34\5\4\3\2\33\32\3\2\2\2\33\34\3\2\2\2\34!\3\2\2\2\35"+
		" \5\6\4\2\36 \5\20\t\2\37\35\3\2\2\2\37\36\3\2\2\2 #\3\2\2\2!\37\3\2\2"+
		"\2!\"\3\2\2\2\"$\3\2\2\2#!\3\2\2\2$%\7\2\2\3%\3\3\2\2\2&\'\7\r\2\2\'("+
		"\7)\2\2()\7\'\2\2)\5\3\2\2\2*+\5\f\7\2+,\7\35\2\2,-\5\b\5\2-.\7\'\2\2"+
		".P\3\2\2\2/\60\5\30\r\2\60\63\5\16\b\2\61\62\7\35\2\2\62\64\5\b\5\2\63"+
		"\61\3\2\2\2\63\64\3\2\2\2\64\65\3\2\2\2\65\66\7\'\2\2\66P\3\2\2\2\678"+
		"\7\5\2\289\7!\2\29:\5\b\5\2:;\7\"\2\2;>\5\n\6\2<=\7\6\2\2=?\5\n\6\2><"+
		"\3\2\2\2>?\3\2\2\2?P\3\2\2\2@A\7\7\2\2AB\7!\2\2BC\5\b\5\2CD\7\"\2\2DE"+
		"\5\n\6\2EP\3\2\2\2FG\7)\2\2GH\5\24\13\2HI\7\'\2\2IP\3\2\2\2JK\7\f\2\2"+
		"KL\5\b\5\2LM\7\'\2\2MP\3\2\2\2NP\5\n\6\2O*\3\2\2\2O/\3\2\2\2O\67\3\2\2"+
		"\2O@\3\2\2\2OF\3\2\2\2OJ\3\2\2\2ON\3\2\2\2P\7\3\2\2\2QR\b\5\1\2RS\7\16"+
		"\2\2Sw\5\b\5\17TU\7\34\2\2Uw\5\b\5\16VW\7!\2\2WX\5\b\5\2XY\7\"\2\2YZ\7"+
		"\37\2\2Z[\7!\2\2[\\\5\b\5\2\\]\7\"\2\2]^\7 \2\2^_\7!\2\2_`\5\b\5\2`a\7"+
		"\"\2\2aw\3\2\2\2bc\7)\2\2cw\5\24\13\2de\7)\2\2ef\7%\2\2fg\5\b\5\2gh\7"+
		"&\2\2hw\3\2\2\2ir\7%\2\2jo\5\b\5\2kl\7(\2\2ln\5\b\5\2mk\3\2\2\2nq\3\2"+
		"\2\2om\3\2\2\2op\3\2\2\2ps\3\2\2\2qo\3\2\2\2rj\3\2\2\2rs\3\2\2\2st\3\2"+
		"\2\2tw\7&\2\2uw\5\26\f\2vQ\3\2\2\2vT\3\2\2\2vV\3\2\2\2vb\3\2\2\2vd\3\2"+
		"\2\2vi\3\2\2\2vu\3\2\2\2w\u008c\3\2\2\2xy\f\13\2\2yz\t\2\2\2z\u008b\5"+
		"\b\5\f{|\f\n\2\2|}\7\17\2\2}\u008b\5\b\5\13~\177\f\t\2\2\177\u0080\t\3"+
		"\2\2\u0080\u008b\5\b\5\n\u0081\u0082\f\b\2\2\u0082\u0083\t\4\2\2\u0083"+
		"\u008b\5\b\5\t\u0084\u0085\f\7\2\2\u0085\u0086\t\5\2\2\u0086\u008b\5\b"+
		"\5\b\u0087\u0088\f\6\2\2\u0088\u0089\t\6\2\2\u0089\u008b\5\b\5\7\u008a"+
		"x\3\2\2\2\u008a{\3\2\2\2\u008a~\3\2\2\2\u008a\u0081\3\2\2\2\u008a\u0084"+
		"\3\2\2\2\u008a\u0087\3\2\2\2\u008b\u008e\3\2\2\2\u008c\u008a\3\2\2\2\u008c"+
		"\u008d\3\2\2\2\u008d\t\3\2\2\2\u008e\u008c\3\2\2\2\u008f\u0093\7#\2\2"+
		"\u0090\u0092\5\6\4\2\u0091\u0090\3\2\2\2\u0092\u0095\3\2\2\2\u0093\u0091"+
		"\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0096\3\2\2\2\u0095\u0093\3\2\2\2\u0096"+
		"\u0097\7$\2\2\u0097\13\3\2\2\2\u0098\u009f\7)\2\2\u0099\u009a\7)\2\2\u009a"+
		"\u009b\7%\2\2\u009b\u009c\5\b\5\2\u009c\u009d\7&\2\2\u009d\u009f\3\2\2"+
		"\2\u009e\u0098\3\2\2\2\u009e\u0099\3\2\2\2\u009f\r\3\2\2\2\u00a0\u00a6"+
		"\7)\2\2\u00a1\u00a2\7)\2\2\u00a2\u00a3\7%\2\2\u00a3\u00a4\7*\2\2\u00a4"+
		"\u00a6\7&\2\2\u00a5\u00a0\3\2\2\2\u00a5\u00a1\3\2\2\2\u00a6\17\3\2\2\2"+
		"\u00a7\u00a8\7\13\2\2\u00a8\u00a9\7)\2\2\u00a9\u00aa\5\22\n\2\u00aa\u00ab"+
		"\5\n\6\2\u00ab\21\3\2\2\2\u00ac\u00b8\7!\2\2\u00ad\u00ae\5\30\r\2\u00ae"+
		"\u00b5\7)\2\2\u00af\u00b0\7(\2\2\u00b0\u00b1\5\30\r\2\u00b1\u00b2\7)\2"+
		"\2\u00b2\u00b4\3\2\2\2\u00b3\u00af\3\2\2\2\u00b4\u00b7\3\2\2\2\u00b5\u00b3"+
		"\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b9\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b8"+
		"\u00ad\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bb\7\""+
		"\2\2\u00bb\23\3\2\2\2\u00bc\u00c5\7!\2\2\u00bd\u00c2\5\b\5\2\u00be\u00bf"+
		"\7(\2\2\u00bf\u00c1\5\b\5\2\u00c0\u00be\3\2\2\2\u00c1\u00c4\3\2\2\2\u00c2"+
		"\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c6\3\2\2\2\u00c4\u00c2\3\2"+
		"\2\2\u00c5\u00bd\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7"+
		"\u00c8\7\"\2\2\u00c8\25\3\2\2\2\u00c9\u00ca\7!\2\2\u00ca\u00cb\5\b\5\2"+
		"\u00cb\u00cc\7\"\2\2\u00cc\u00d2\3\2\2\2\u00cd\u00d2\7*\2\2\u00ce\u00d2"+
		"\t\7\2\2\u00cf\u00d2\7)\2\2\u00d0\u00d2\7+\2\2\u00d1\u00c9\3\2\2\2\u00d1"+
		"\u00cd\3\2\2\2\u00d1\u00ce\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d0\3\2"+
		"\2\2\u00d2\27\3\2\2\2\u00d3\u00d7\7\b\2\2\u00d4\u00d7\7\t\2\2\u00d5\u00d7"+
		"\7\n\2\2\u00d6\u00d3\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d6\u00d5\3\2\2\2\u00d7"+
		"\31\3\2\2\2\26\33\37!\63>Oorv\u008a\u008c\u0093\u009e\u00a5\u00b5\u00b8"+
		"\u00c2\u00c5\u00d1\u00d6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}