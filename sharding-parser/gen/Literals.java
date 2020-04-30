// Generated from /Users/zhanghongzhang/Develop/workshop20200415-master/sharding-parser/src/main/antlr4/imports/Literals.g4 by ANTLR 4.8
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Literals extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		IDENTIFIER_=1, STRING_=2, NUMBER_=3, HEX_DIGIT_=4, BIT_NUM_=5, INT_=6, 
		HEX_=7, AND_=8, OR_=9, NOT_=10, TILDE_=11, VERTICAL_BAR_=12, AMPERSAND_=13, 
		SIGNED_LEFT_SHIFT_=14, SIGNED_RIGHT_SHIFT_=15, CARET_=16, MOD_=17, COLON_=18, 
		PLUS_=19, MINUS_=20, ASTERISK_=21, SLASH_=22, BACKSLASH_=23, DOT_=24, 
		DOT_ASTERISK_=25, SAFE_EQ_=26, DEQ_=27, EQ_=28, NEQ_=29, GT_=30, GTE_=31, 
		LT_=32, LTE_=33, POUND_=34, LP_=35, RP_=36, LBE_=37, RBE_=38, LBT_=39, 
		RBT_=40, COMMA_=41, DQ_=42, SQ_=43, BQ_=44, QUESTION_=45, AT_=46, SEMI_=47;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"IDENTIFIER_", "STRING_", "NUMBER_", "HEX_DIGIT_", "BIT_NUM_", "INT_", 
			"HEX_", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", 
			"N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "UL_", 
			"AND_", "OR_", "NOT_", "TILDE_", "VERTICAL_BAR_", "AMPERSAND_", "SIGNED_LEFT_SHIFT_", 
			"SIGNED_RIGHT_SHIFT_", "CARET_", "MOD_", "COLON_", "PLUS_", "MINUS_", 
			"ASTERISK_", "SLASH_", "BACKSLASH_", "DOT_", "DOT_ASTERISK_", "SAFE_EQ_", 
			"DEQ_", "EQ_", "NEQ_", "GT_", "GTE_", "LT_", "LTE_", "POUND_", "LP_", 
			"RP_", "LBE_", "RBE_", "LBT_", "RBT_", "COMMA_", "DQ_", "SQ_", "BQ_", 
			"QUESTION_", "AT_", "SEMI_"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "'&&'", "'||'", "'!'", 
			"'~'", "'|'", "'&'", "'<<'", "'>>'", "'^'", "'%'", "':'", "'+'", "'-'", 
			"'*'", "'/'", "'\\'", "'.'", "'.*'", "'<=>'", "'=='", "'='", null, "'>'", 
			"'>='", "'<'", "'<='", "'#'", "'('", "')'", "'{'", "'}'", "'['", "']'", 
			"','", "'\"'", "'''", "'`'", "'?'", "'@'", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "IDENTIFIER_", "STRING_", "NUMBER_", "HEX_DIGIT_", "BIT_NUM_", 
			"INT_", "HEX_", "AND_", "OR_", "NOT_", "TILDE_", "VERTICAL_BAR_", "AMPERSAND_", 
			"SIGNED_LEFT_SHIFT_", "SIGNED_RIGHT_SHIFT_", "CARET_", "MOD_", "COLON_", 
			"PLUS_", "MINUS_", "ASTERISK_", "SLASH_", "BACKSLASH_", "DOT_", "DOT_ASTERISK_", 
			"SAFE_EQ_", "DEQ_", "EQ_", "NEQ_", "GT_", "GTE_", "LT_", "LTE_", "POUND_", 
			"LP_", "RP_", "LBE_", "RBE_", "LBT_", "RBT_", "COMMA_", "DQ_", "SQ_", 
			"BQ_", "QUESTION_", "AT_", "SEMI_"
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


	public Literals(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Literals.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\61\u01ac\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t"+
		"=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4"+
		"I\tI\4J\tJ\4K\tK\3\2\7\2\u0099\n\2\f\2\16\2\u009c\13\2\3\2\6\2\u009f\n"+
		"\2\r\2\16\2\u00a0\3\2\7\2\u00a4\n\2\f\2\16\2\u00a7\13\2\3\2\3\2\6\2\u00ab"+
		"\n\2\r\2\16\2\u00ac\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2\u00b7\n\2\f\2"+
		"\16\2\u00ba\13\2\3\2\3\2\5\2\u00be\n\2\3\3\3\3\3\3\3\3\3\3\3\3\7\3\u00c6"+
		"\n\3\f\3\16\3\u00c9\13\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3\u00d3\n\3"+
		"\f\3\16\3\u00d6\13\3\3\3\3\3\5\3\u00da\n\3\3\4\5\4\u00dd\n\4\3\4\5\4\u00e0"+
		"\n\4\3\4\3\4\3\4\3\4\5\4\u00e6\n\4\3\4\3\4\5\4\u00ea\n\4\3\5\3\5\3\5\3"+
		"\5\6\5\u00f0\n\5\r\5\16\5\u00f1\3\5\3\5\3\5\6\5\u00f7\n\5\r\5\16\5\u00f8"+
		"\3\5\3\5\5\5\u00fd\n\5\3\6\3\6\3\6\3\6\6\6\u0103\n\6\r\6\16\6\u0104\3"+
		"\6\3\6\3\6\6\6\u010a\n\6\r\6\16\6\u010b\3\6\3\6\5\6\u0110\n\6\3\7\6\7"+
		"\u0113\n\7\r\7\16\7\u0114\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3"+
		"\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24"+
		"\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33"+
		"\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3"+
		"#\3$\3$\3$\3%\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3*\3+\3+\3+\3,\3,"+
		"\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3"+
		"\65\3\65\3\65\3\66\3\66\3\66\3\66\3\67\3\67\3\67\38\38\39\39\39\39\59"+
		"\u0185\n9\3:\3:\3;\3;\3;\3<\3<\3=\3=\3=\3>\3>\3?\3?\3@\3@\3A\3A\3B\3B"+
		"\3C\3C\3D\3D\3E\3E\3F\3F\3G\3G\3H\3H\3I\3I\3J\3J\3K\3K\4\u009a\u00a0\2"+
		"L\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\2\23\2\25\2\27\2\31\2\33\2\35\2\37"+
		"\2!\2#\2%\2\'\2)\2+\2-\2/\2\61\2\63\2\65\2\67\29\2;\2=\2?\2A\2C\2E\2G"+
		"\nI\13K\fM\rO\16Q\17S\20U\21W\22Y\23[\24]\25_\26a\27c\30e\31g\32i\33k"+
		"\34m\35o\36q\37s u!w\"y#{$}%\177&\u0081\'\u0083(\u0085)\u0087*\u0089+"+
		"\u008b,\u008d-\u008f.\u0091/\u0093\60\u0095\61\3\2#\7\2&&\62;C\\aac|\6"+
		"\2&&C\\aac|\3\2bb\4\2$$^^\4\2))^^\3\2\62;\5\2\62;CHch\4\2CCcc\4\2DDdd"+
		"\4\2EEee\4\2FFff\4\2GGgg\4\2HHhh\4\2IIii\4\2JJjj\4\2KKkk\4\2LLll\4\2M"+
		"Mmm\4\2NNnn\4\2OOoo\4\2PPpp\4\2QQqq\4\2RRrr\4\2SSss\4\2TTtt\4\2UUuu\4"+
		"\2VVvv\4\2WWww\4\2XXxx\4\2YYyy\4\2ZZzz\4\2[[{{\4\2\\\\||\2\u01ad\2\3\3"+
		"\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2"+
		"\17\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q"+
		"\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2"+
		"\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2"+
		"\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w"+
		"\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2"+
		"\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2\2\2\u008b"+
		"\3\2\2\2\2\u008d\3\2\2\2\2\u008f\3\2\2\2\2\u0091\3\2\2\2\2\u0093\3\2\2"+
		"\2\2\u0095\3\2\2\2\3\u00bd\3\2\2\2\5\u00d9\3\2\2\2\7\u00dc\3\2\2\2\t\u00fc"+
		"\3\2\2\2\13\u010f\3\2\2\2\r\u0112\3\2\2\2\17\u0116\3\2\2\2\21\u0118\3"+
		"\2\2\2\23\u011a\3\2\2\2\25\u011c\3\2\2\2\27\u011e\3\2\2\2\31\u0120\3\2"+
		"\2\2\33\u0122\3\2\2\2\35\u0124\3\2\2\2\37\u0126\3\2\2\2!\u0128\3\2\2\2"+
		"#\u012a\3\2\2\2%\u012c\3\2\2\2\'\u012e\3\2\2\2)\u0130\3\2\2\2+\u0132\3"+
		"\2\2\2-\u0134\3\2\2\2/\u0136\3\2\2\2\61\u0138\3\2\2\2\63\u013a\3\2\2\2"+
		"\65\u013c\3\2\2\2\67\u013e\3\2\2\29\u0140\3\2\2\2;\u0142\3\2\2\2=\u0144"+
		"\3\2\2\2?\u0146\3\2\2\2A\u0148\3\2\2\2C\u014a\3\2\2\2E\u014c\3\2\2\2G"+
		"\u014e\3\2\2\2I\u0151\3\2\2\2K\u0154\3\2\2\2M\u0156\3\2\2\2O\u0158\3\2"+
		"\2\2Q\u015a\3\2\2\2S\u015c\3\2\2\2U\u015f\3\2\2\2W\u0162\3\2\2\2Y\u0164"+
		"\3\2\2\2[\u0166\3\2\2\2]\u0168\3\2\2\2_\u016a\3\2\2\2a\u016c\3\2\2\2c"+
		"\u016e\3\2\2\2e\u0170\3\2\2\2g\u0172\3\2\2\2i\u0174\3\2\2\2k\u0177\3\2"+
		"\2\2m\u017b\3\2\2\2o\u017e\3\2\2\2q\u0184\3\2\2\2s\u0186\3\2\2\2u\u0188"+
		"\3\2\2\2w\u018b\3\2\2\2y\u018d\3\2\2\2{\u0190\3\2\2\2}\u0192\3\2\2\2\177"+
		"\u0194\3\2\2\2\u0081\u0196\3\2\2\2\u0083\u0198\3\2\2\2\u0085\u019a\3\2"+
		"\2\2\u0087\u019c\3\2\2\2\u0089\u019e\3\2\2\2\u008b\u01a0\3\2\2\2\u008d"+
		"\u01a2\3\2\2\2\u008f\u01a4\3\2\2\2\u0091\u01a6\3\2\2\2\u0093\u01a8\3\2"+
		"\2\2\u0095\u01aa\3\2\2\2\u0097\u0099\t\2\2\2\u0098\u0097\3\2\2\2\u0099"+
		"\u009c\3\2\2\2\u009a\u009b\3\2\2\2\u009a\u0098\3\2\2\2\u009b\u009e\3\2"+
		"\2\2\u009c\u009a\3\2\2\2\u009d\u009f\t\3\2\2\u009e\u009d\3\2\2\2\u009f"+
		"\u00a0\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a0\u009e\3\2\2\2\u00a1\u00a5\3\2"+
		"\2\2\u00a2\u00a4\t\2\2\2\u00a3\u00a2\3\2\2\2\u00a4\u00a7\3\2\2\2\u00a5"+
		"\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00be\3\2\2\2\u00a7\u00a5\3\2"+
		"\2\2\u00a8\u00aa\5\u008fH\2\u00a9\u00ab\n\4\2\2\u00aa\u00a9\3\2\2\2\u00ab"+
		"\u00ac\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ae\3\2"+
		"\2\2\u00ae\u00af\5\u008fH\2\u00af\u00be\3\2\2\2\u00b0\u00b8\5\u008bF\2"+
		"\u00b1\u00b2\7^\2\2\u00b2\u00b7\13\2\2\2\u00b3\u00b4\7$\2\2\u00b4\u00b7"+
		"\7$\2\2\u00b5\u00b7\n\5\2\2\u00b6\u00b1\3\2\2\2\u00b6\u00b3\3\2\2\2\u00b6"+
		"\u00b5\3\2\2\2\u00b7\u00ba\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b8\u00b9\3\2"+
		"\2\2\u00b9\u00bb\3\2\2\2\u00ba\u00b8\3\2\2\2\u00bb\u00bc\5\u008bF\2\u00bc"+
		"\u00be\3\2\2\2\u00bd\u009a\3\2\2\2\u00bd\u00a8\3\2\2\2\u00bd\u00b0\3\2"+
		"\2\2\u00be\4\3\2\2\2\u00bf\u00c7\5\u008bF\2\u00c0\u00c1\7^\2\2\u00c1\u00c6"+
		"\13\2\2\2\u00c2\u00c3\7$\2\2\u00c3\u00c6\7$\2\2\u00c4\u00c6\n\5\2\2\u00c5"+
		"\u00c0\3\2\2\2\u00c5\u00c2\3\2\2\2\u00c5\u00c4\3\2\2\2\u00c6\u00c9\3\2"+
		"\2\2\u00c7\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00ca\3\2\2\2\u00c9"+
		"\u00c7\3\2\2\2\u00ca\u00cb\5\u008bF\2\u00cb\u00da\3\2\2\2\u00cc\u00d4"+
		"\5\u008dG\2\u00cd\u00ce\7^\2\2\u00ce\u00d3\13\2\2\2\u00cf\u00d0\7)\2\2"+
		"\u00d0\u00d3\7)\2\2\u00d1\u00d3\n\6\2\2\u00d2\u00cd\3\2\2\2\u00d2\u00cf"+
		"\3\2\2\2\u00d2\u00d1\3\2\2\2\u00d3\u00d6\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d4"+
		"\u00d5\3\2\2\2\u00d5\u00d7\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d7\u00d8\5\u008d"+
		"G\2\u00d8\u00da\3\2\2\2\u00d9\u00bf\3\2\2\2\u00d9\u00cc\3\2\2\2\u00da"+
		"\6\3\2\2\2\u00db\u00dd\5\r\7\2\u00dc\u00db\3\2\2\2\u00dc\u00dd\3\2\2\2"+
		"\u00dd\u00df\3\2\2\2\u00de\u00e0\5g\64\2\u00df\u00de\3\2\2\2\u00df\u00e0"+
		"\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e9\5\r\7\2\u00e2\u00e5\5\31\r\2"+
		"\u00e3\u00e6\5]/\2\u00e4\u00e6\5_\60\2\u00e5\u00e3\3\2\2\2\u00e5\u00e4"+
		"\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e8\5\r\7\2\u00e8"+
		"\u00ea\3\2\2\2\u00e9\u00e2\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\b\3\2\2\2"+
		"\u00eb\u00ec\7\62\2\2\u00ec\u00ed\7z\2\2\u00ed\u00ef\3\2\2\2\u00ee\u00f0"+
		"\5\17\b\2\u00ef\u00ee\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00ef\3\2\2\2"+
		"\u00f1\u00f2\3\2\2\2\u00f2\u00fd\3\2\2\2\u00f3\u00f4\7Z\2\2\u00f4\u00f6"+
		"\5\u008dG\2\u00f5\u00f7\5\17\b\2\u00f6\u00f5\3\2\2\2\u00f7\u00f8\3\2\2"+
		"\2\u00f8\u00f6\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00fb"+
		"\5\u008dG\2\u00fb\u00fd\3\2\2\2\u00fc\u00eb\3\2\2\2\u00fc\u00f3\3\2\2"+
		"\2\u00fd\n\3\2\2\2\u00fe\u00ff\7\62\2\2\u00ff\u0100\7d\2\2\u0100\u0102"+
		"\3\2\2\2\u0101\u0103\4\62\63\2\u0102\u0101\3\2\2\2\u0103\u0104\3\2\2\2"+
		"\u0104\u0102\3\2\2\2\u0104\u0105\3\2\2\2\u0105\u0110\3\2\2\2\u0106\u0107"+
		"\5\23\n\2\u0107\u0109\5\u008dG\2\u0108\u010a\4\62\63\2\u0109\u0108\3\2"+
		"\2\2\u010a\u010b\3\2\2\2\u010b\u0109\3\2\2\2\u010b\u010c\3\2\2\2\u010c"+
		"\u010d\3\2\2\2\u010d\u010e\5\u008dG\2\u010e\u0110\3\2\2\2\u010f\u00fe"+
		"\3\2\2\2\u010f\u0106\3\2\2\2\u0110\f\3\2\2\2\u0111\u0113\t\7\2\2\u0112"+
		"\u0111\3\2\2\2\u0113\u0114\3\2\2\2\u0114\u0112\3\2\2\2\u0114\u0115\3\2"+
		"\2\2\u0115\16\3\2\2\2\u0116\u0117\t\b\2\2\u0117\20\3\2\2\2\u0118\u0119"+
		"\t\t\2\2\u0119\22\3\2\2\2\u011a\u011b\t\n\2\2\u011b\24\3\2\2\2\u011c\u011d"+
		"\t\13\2\2\u011d\26\3\2\2\2\u011e\u011f\t\f\2\2\u011f\30\3\2\2\2\u0120"+
		"\u0121\t\r\2\2\u0121\32\3\2\2\2\u0122\u0123\t\16\2\2\u0123\34\3\2\2\2"+
		"\u0124\u0125\t\17\2\2\u0125\36\3\2\2\2\u0126\u0127\t\20\2\2\u0127 \3\2"+
		"\2\2\u0128\u0129\t\21\2\2\u0129\"\3\2\2\2\u012a\u012b\t\22\2\2\u012b$"+
		"\3\2\2\2\u012c\u012d\t\23\2\2\u012d&\3\2\2\2\u012e\u012f\t\24\2\2\u012f"+
		"(\3\2\2\2\u0130\u0131\t\25\2\2\u0131*\3\2\2\2\u0132\u0133\t\26\2\2\u0133"+
		",\3\2\2\2\u0134\u0135\t\27\2\2\u0135.\3\2\2\2\u0136\u0137\t\30\2\2\u0137"+
		"\60\3\2\2\2\u0138\u0139\t\31\2\2\u0139\62\3\2\2\2\u013a\u013b\t\32\2\2"+
		"\u013b\64\3\2\2\2\u013c\u013d\t\33\2\2\u013d\66\3\2\2\2\u013e\u013f\t"+
		"\34\2\2\u013f8\3\2\2\2\u0140\u0141\t\35\2\2\u0141:\3\2\2\2\u0142\u0143"+
		"\t\36\2\2\u0143<\3\2\2\2\u0144\u0145\t\37\2\2\u0145>\3\2\2\2\u0146\u0147"+
		"\t \2\2\u0147@\3\2\2\2\u0148\u0149\t!\2\2\u0149B\3\2\2\2\u014a\u014b\t"+
		"\"\2\2\u014bD\3\2\2\2\u014c\u014d\7a\2\2\u014dF\3\2\2\2\u014e\u014f\7"+
		"(\2\2\u014f\u0150\7(\2\2\u0150H\3\2\2\2\u0151\u0152\7~\2\2\u0152\u0153"+
		"\7~\2\2\u0153J\3\2\2\2\u0154\u0155\7#\2\2\u0155L\3\2\2\2\u0156\u0157\7"+
		"\u0080\2\2\u0157N\3\2\2\2\u0158\u0159\7~\2\2\u0159P\3\2\2\2\u015a\u015b"+
		"\7(\2\2\u015bR\3\2\2\2\u015c\u015d\7>\2\2\u015d\u015e\7>\2\2\u015eT\3"+
		"\2\2\2\u015f\u0160\7@\2\2\u0160\u0161\7@\2\2\u0161V\3\2\2\2\u0162\u0163"+
		"\7`\2\2\u0163X\3\2\2\2\u0164\u0165\7\'\2\2\u0165Z\3\2\2\2\u0166\u0167"+
		"\7<\2\2\u0167\\\3\2\2\2\u0168\u0169\7-\2\2\u0169^\3\2\2\2\u016a\u016b"+
		"\7/\2\2\u016b`\3\2\2\2\u016c\u016d\7,\2\2\u016db\3\2\2\2\u016e\u016f\7"+
		"\61\2\2\u016fd\3\2\2\2\u0170\u0171\7^\2\2\u0171f\3\2\2\2\u0172\u0173\7"+
		"\60\2\2\u0173h\3\2\2\2\u0174\u0175\7\60\2\2\u0175\u0176\7,\2\2\u0176j"+
		"\3\2\2\2\u0177\u0178\7>\2\2\u0178\u0179\7?\2\2\u0179\u017a\7@\2\2\u017a"+
		"l\3\2\2\2\u017b\u017c\7?\2\2\u017c\u017d\7?\2\2\u017dn\3\2\2\2\u017e\u017f"+
		"\7?\2\2\u017fp\3\2\2\2\u0180\u0181\7>\2\2\u0181\u0185\7@\2\2\u0182\u0183"+
		"\7#\2\2\u0183\u0185\7?\2\2\u0184\u0180\3\2\2\2\u0184\u0182\3\2\2\2\u0185"+
		"r\3\2\2\2\u0186\u0187\7@\2\2\u0187t\3\2\2\2\u0188\u0189\7@\2\2\u0189\u018a"+
		"\7?\2\2\u018av\3\2\2\2\u018b\u018c\7>\2\2\u018cx\3\2\2\2\u018d\u018e\7"+
		">\2\2\u018e\u018f\7?\2\2\u018fz\3\2\2\2\u0190\u0191\7%\2\2\u0191|\3\2"+
		"\2\2\u0192\u0193\7*\2\2\u0193~\3\2\2\2\u0194\u0195\7+\2\2\u0195\u0080"+
		"\3\2\2\2\u0196\u0197\7}\2\2\u0197\u0082\3\2\2\2\u0198\u0199\7\177\2\2"+
		"\u0199\u0084\3\2\2\2\u019a\u019b\7]\2\2\u019b\u0086\3\2\2\2\u019c\u019d"+
		"\7_\2\2\u019d\u0088\3\2\2\2\u019e\u019f\7.\2\2\u019f\u008a\3\2\2\2\u01a0"+
		"\u01a1\7$\2\2\u01a1\u008c\3\2\2\2\u01a2\u01a3\7)\2\2\u01a3\u008e\3\2\2"+
		"\2\u01a4\u01a5\7b\2\2\u01a5\u0090\3\2\2\2\u01a6\u01a7\7A\2\2\u01a7\u0092"+
		"\3\2\2\2\u01a8\u01a9\7B\2\2\u01a9\u0094\3\2\2\2\u01aa\u01ab\7=\2\2\u01ab"+
		"\u0096\3\2\2\2\33\2\u009a\u00a0\u00a5\u00ac\u00b6\u00b8\u00bd\u00c5\u00c7"+
		"\u00d2\u00d4\u00d9\u00dc\u00df\u00e5\u00e9\u00f1\u00f8\u00fc\u0104\u010b"+
		"\u010f\u0114\u0184\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}