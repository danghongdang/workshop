// Generated from /Users/zhanghongzhang/Develop/workshop20200415-master/sharding-parser/src/main/antlr4/imports/Keyword.g4 by ANTLR 4.8
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Keyword extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, USE=2, INSERT=3, SELECT=4, TABLE=5, COLUMN=6, INTO=7, VALUES=8, 
		VALUE=9, FROM=10, WHERE=11, AND=12, OR=13, NOT=14, BETWEEN=15, IN=16, 
		UPDATE=17, SET=18;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"WS", "USE", "INSERT", "SELECT", "TABLE", "COLUMN", "INTO", "VALUES", 
			"VALUE", "FROM", "WHERE", "AND", "OR", "NOT", "BETWEEN", "IN", "UPDATE", 
			"SET", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", 
			"N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "UL_"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WS", "USE", "INSERT", "SELECT", "TABLE", "COLUMN", "INTO", "VALUES", 
			"VALUE", "FROM", "WHERE", "AND", "OR", "NOT", "BETWEEN", "IN", "UPDATE", 
			"SET"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public Keyword(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Keyword.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\24\u00f7\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\3\2\6\2_\n\2\r\2\16\2`\3\2\3\2\3\3\3\3\3\3\3\3\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3"+
		"\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3"+
		"\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'"+
		"\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\2\2/\3\3\5\4\7\5\t\6\13\7\r"+
		"\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\2)"+
		"\2+\2-\2/\2\61\2\63\2\65\2\67\29\2;\2=\2?\2A\2C\2E\2G\2I\2K\2M\2O\2Q\2"+
		"S\2U\2W\2Y\2[\2\3\2\35\5\2\13\f\17\17\"\"\4\2CCcc\4\2DDdd\4\2EEee\4\2"+
		"FFff\4\2GGgg\4\2HHhh\4\2IIii\4\2JJjj\4\2KKkk\4\2LLll\4\2MMmm\4\2NNnn\4"+
		"\2OOoo\4\2PPpp\4\2QQqq\4\2RRrr\4\2SSss\4\2TTtt\4\2UUuu\4\2VVvv\4\2WWw"+
		"w\4\2XXxx\4\2YYyy\4\2ZZzz\4\2[[{{\4\2\\\\||\2\u00dc\2\3\3\2\2\2\2\5\3"+
		"\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2"+
		"\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3"+
		"\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\3^\3"+
		"\2\2\2\5d\3\2\2\2\7h\3\2\2\2\to\3\2\2\2\13v\3\2\2\2\r|\3\2\2\2\17\u0083"+
		"\3\2\2\2\21\u0088\3\2\2\2\23\u008f\3\2\2\2\25\u0095\3\2\2\2\27\u009a\3"+
		"\2\2\2\31\u00a0\3\2\2\2\33\u00a4\3\2\2\2\35\u00a7\3\2\2\2\37\u00ab\3\2"+
		"\2\2!\u00b3\3\2\2\2#\u00b6\3\2\2\2%\u00bd\3\2\2\2\'\u00c1\3\2\2\2)\u00c3"+
		"\3\2\2\2+\u00c5\3\2\2\2-\u00c7\3\2\2\2/\u00c9\3\2\2\2\61\u00cb\3\2\2\2"+
		"\63\u00cd\3\2\2\2\65\u00cf\3\2\2\2\67\u00d1\3\2\2\29\u00d3\3\2\2\2;\u00d5"+
		"\3\2\2\2=\u00d7\3\2\2\2?\u00d9\3\2\2\2A\u00db\3\2\2\2C\u00dd\3\2\2\2E"+
		"\u00df\3\2\2\2G\u00e1\3\2\2\2I\u00e3\3\2\2\2K\u00e5\3\2\2\2M\u00e7\3\2"+
		"\2\2O\u00e9\3\2\2\2Q\u00eb\3\2\2\2S\u00ed\3\2\2\2U\u00ef\3\2\2\2W\u00f1"+
		"\3\2\2\2Y\u00f3\3\2\2\2[\u00f5\3\2\2\2]_\t\2\2\2^]\3\2\2\2_`\3\2\2\2`"+
		"^\3\2\2\2`a\3\2\2\2ab\3\2\2\2bc\b\2\2\2c\4\3\2\2\2de\5O(\2ef\5K&\2fg\5"+
		"/\30\2g\6\3\2\2\2hi\5\67\34\2ij\5A!\2jk\5K&\2kl\5/\30\2lm\5I%\2mn\5M\'"+
		"\2n\b\3\2\2\2op\5K&\2pq\5/\30\2qr\5=\37\2rs\5/\30\2st\5+\26\2tu\5M\'\2"+
		"u\n\3\2\2\2vw\5M\'\2wx\5\'\24\2xy\5)\25\2yz\5=\37\2z{\5/\30\2{\f\3\2\2"+
		"\2|}\5+\26\2}~\5C\"\2~\177\5=\37\2\177\u0080\5O(\2\u0080\u0081\5? \2\u0081"+
		"\u0082\5A!\2\u0082\16\3\2\2\2\u0083\u0084\5\67\34\2\u0084\u0085\5A!\2"+
		"\u0085\u0086\5M\'\2\u0086\u0087\5C\"\2\u0087\20\3\2\2\2\u0088\u0089\5"+
		"Q)\2\u0089\u008a\5\'\24\2\u008a\u008b\5=\37\2\u008b\u008c\5O(\2\u008c"+
		"\u008d\5/\30\2\u008d\u008e\5K&\2\u008e\22\3\2\2\2\u008f\u0090\5Q)\2\u0090"+
		"\u0091\5\'\24\2\u0091\u0092\5=\37\2\u0092\u0093\5O(\2\u0093\u0094\5/\30"+
		"\2\u0094\24\3\2\2\2\u0095\u0096\5\61\31\2\u0096\u0097\5I%\2\u0097\u0098"+
		"\5C\"\2\u0098\u0099\5? \2\u0099\26\3\2\2\2\u009a\u009b\5S*\2\u009b\u009c"+
		"\5\65\33\2\u009c\u009d\5/\30\2\u009d\u009e\5I%\2\u009e\u009f\5/\30\2\u009f"+
		"\30\3\2\2\2\u00a0\u00a1\5\'\24\2\u00a1\u00a2\5A!\2\u00a2\u00a3\5-\27\2"+
		"\u00a3\32\3\2\2\2\u00a4\u00a5\5C\"\2\u00a5\u00a6\5I%\2\u00a6\34\3\2\2"+
		"\2\u00a7\u00a8\5A!\2\u00a8\u00a9\5C\"\2\u00a9\u00aa\5M\'\2\u00aa\36\3"+
		"\2\2\2\u00ab\u00ac\5)\25\2\u00ac\u00ad\5/\30\2\u00ad\u00ae\5M\'\2\u00ae"+
		"\u00af\5S*\2\u00af\u00b0\5/\30\2\u00b0\u00b1\5/\30\2\u00b1\u00b2\5A!\2"+
		"\u00b2 \3\2\2\2\u00b3\u00b4\5\67\34\2\u00b4\u00b5\5A!\2\u00b5\"\3\2\2"+
		"\2\u00b6\u00b7\5O(\2\u00b7\u00b8\5E#\2\u00b8\u00b9\5-\27\2\u00b9\u00ba"+
		"\5\'\24\2\u00ba\u00bb\5M\'\2\u00bb\u00bc\5/\30\2\u00bc$\3\2\2\2\u00bd"+
		"\u00be\5K&\2\u00be\u00bf\5/\30\2\u00bf\u00c0\5M\'\2\u00c0&\3\2\2\2\u00c1"+
		"\u00c2\t\3\2\2\u00c2(\3\2\2\2\u00c3\u00c4\t\4\2\2\u00c4*\3\2\2\2\u00c5"+
		"\u00c6\t\5\2\2\u00c6,\3\2\2\2\u00c7\u00c8\t\6\2\2\u00c8.\3\2\2\2\u00c9"+
		"\u00ca\t\7\2\2\u00ca\60\3\2\2\2\u00cb\u00cc\t\b\2\2\u00cc\62\3\2\2\2\u00cd"+
		"\u00ce\t\t\2\2\u00ce\64\3\2\2\2\u00cf\u00d0\t\n\2\2\u00d0\66\3\2\2\2\u00d1"+
		"\u00d2\t\13\2\2\u00d28\3\2\2\2\u00d3\u00d4\t\f\2\2\u00d4:\3\2\2\2\u00d5"+
		"\u00d6\t\r\2\2\u00d6<\3\2\2\2\u00d7\u00d8\t\16\2\2\u00d8>\3\2\2\2\u00d9"+
		"\u00da\t\17\2\2\u00da@\3\2\2\2\u00db\u00dc\t\20\2\2\u00dcB\3\2\2\2\u00dd"+
		"\u00de\t\21\2\2\u00deD\3\2\2\2\u00df\u00e0\t\22\2\2\u00e0F\3\2\2\2\u00e1"+
		"\u00e2\t\23\2\2\u00e2H\3\2\2\2\u00e3\u00e4\t\24\2\2\u00e4J\3\2\2\2\u00e5"+
		"\u00e6\t\25\2\2\u00e6L\3\2\2\2\u00e7\u00e8\t\26\2\2\u00e8N\3\2\2\2\u00e9"+
		"\u00ea\t\27\2\2\u00eaP\3\2\2\2\u00eb\u00ec\t\30\2\2\u00ecR\3\2\2\2\u00ed"+
		"\u00ee\t\31\2\2\u00eeT\3\2\2\2\u00ef\u00f0\t\32\2\2\u00f0V\3\2\2\2\u00f1"+
		"\u00f2\t\33\2\2\u00f2X\3\2\2\2\u00f3\u00f4\t\34\2\2\u00f4Z\3\2\2\2\u00f5"+
		"\u00f6\7a\2\2\u00f6\\\3\2\2\2\4\2`\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}