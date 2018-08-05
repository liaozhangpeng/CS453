public class Token {

    public String type;
    public String value;
    public int line;
    public Tag tag;

    public Token(Tag tag, String value, int line) {
        this.type = "token";
        this.value = value;
        this.line = 0;
        this.tag = tag;
    }

    public Token() {
        this.type = "token";
        this.value = null;
        this.line = 0;
        this.tag = null;
    }

    // Token syntax defined in comments below for corresponding tags
    // * Whitespace is { " " | "\t" | "\n" }, and is skipped
    // * Comments begin with # and go to newline
    // * Assume ASCII encoding
    public enum Tag {
	EOF,		// no more input
	INTLIT,		// digit { digit }
	ID,		// letter { letter | digit }
	// --- symbols
	TILDE,		// "~"
	SEMI,		// ";"
	EQ,		// "="
	NE,		// "~="
	LT,		// "<"
	LE,		// "<="
	GT,		// ">"
	GE,		// ">="
	ASSIGN,		// ":="
        PLUS,		// "+"
	MINUS,		// "-"
	TIMES,		// "*"
	DIV,		// "/"
	DEEPEQ,		// "==="
	DEEPLT,		// "<<<"
	DEEPGT,		// ">>>"
	// --- reserved words
	AND,		// "and"
	DO,		// "do"
	END,		// "end"
	ELSE,		// "else"
	ELSIF,		// "elsif"
	FALSE,		// "false"
	FN,		// "fn"
	IF,		// "if"
	MOD,		// "mod"
	OR,		// "or"
	RETURN,		// "return"
	THEN,		// "then"
	TRUE,		// "true"
	VAR,		// "var"
	WHILE,		// "while"
	// --- brackets
	LPAREN,		// "("
	RPAREN,		// ")"
	LBRACE,		// "{"
	RBRACE,		// "}"
	LSQUARE,	// "["
	RSQUARE		// "]"
    }
}
