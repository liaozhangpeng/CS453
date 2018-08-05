public class Token {

    public String type;
    public String value;
    public int line;
    public Tag tag;

    public Token() {
        this.type = "token";
        this.value = null;
        this.line = -1;
        this.tag = null;
    }

    public enum Tag {
        PLUS, MINUS, LPAREN, RPAREN, LBRACE, RBRACE, EQUALS, NOT_EQUALS
    }
}