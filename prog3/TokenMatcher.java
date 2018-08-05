public class TokenMatcher {
	public static Token getToken(char[] s, int index){
		switch(s[index + 0]){
		case 'd':
			switch(s[index + 1]){
			case 'o':
				switch(s[index + 2]){
				default:return new Token(Token.Tag.DO, "do",0);
				}
			default:return null;
			}
		case ':':
			switch(s[index + 1]){
			case '=':
				switch(s[index + 2]){
				default:return new Token(Token.Tag.ASSIGN, ":=",0);
				}
			default:return null;
			}
		case '=':
			switch(s[index + 1]){
			case '=':
				switch(s[index + 2]){
				case '=':
					switch(s[index + 3]){
					default:return new Token(Token.Tag.DEEPEQ, "===",0);
					}
				default:return new Token(Token.Tag.EQ, "=",0);
				}
			default:return new Token(Token.Tag.EQ, "=",0);
			}
		case '-':
			switch(s[index + 1]){
			default:return new Token(Token.Tag.MINUS, "-",0);
			}
		case 'a':
			switch(s[index + 1]){
			case 'n':
				switch(s[index + 2]){
				case 'd':
					switch(s[index + 3]){
					default:return new Token(Token.Tag.AND, "and",0);
					}
				default:return null;
				}
			default:return null;
			}
		case '*':
			switch(s[index + 1]){
			default:return new Token(Token.Tag.TIMES, "*",0);
			}
		case 'e':
			switch(s[index + 1]){
			case 'n':
				switch(s[index + 2]){
				case 'd':
					switch(s[index + 3]){
					default:return new Token(Token.Tag.END, "end",0);
					}
				default:return null;
				}
			case 'l':
				switch(s[index + 2]){
				case 's':
					switch(s[index + 3]){
					case 'e':
						switch(s[index + 4]){
						default:return new Token(Token.Tag.ELSE, "else",0);
						}
					case 'i':
						switch(s[index + 4]){
						case 'f':
							switch(s[index + 5]){
							default:return new Token(Token.Tag.ELSIF, "elsif",0);
							}
						default:return null;
						}
					default:return null;
					}
				default:return null;
				}
			default:return null;
			}
		case 'i':
			switch(s[index + 1]){
			case 'f':
				switch(s[index + 2]){
				default:return new Token(Token.Tag.IF, "if",0);
				}
			default:return null;
			}
		case '~':
			switch(s[index + 1]){
			case '=':
				switch(s[index + 2]){
				default:return new Token(Token.Tag.NE, "~=",0);
				}
			default:return new Token(Token.Tag.TILDE, "~",0);
			}
		case 'v':
			switch(s[index + 1]){
			case 'a':
				switch(s[index + 2]){
				case 'r':
					switch(s[index + 3]){
					default:return new Token(Token.Tag.VAR, "var",0);
					}
				default:return null;
				}
			default:return null;
			}
		case ';':
			switch(s[index + 1]){
			default:return new Token(Token.Tag.SEMI, ";",0);
			}
		case ']':
			switch(s[index + 1]){
			default:return new Token(Token.Tag.RSQUARE, "]",0);
			}
		case '<':
			switch(s[index + 1]){
			case '=':
				switch(s[index + 2]){
				default:return new Token(Token.Tag.LE, "<=",0);
				}
			case '<':
				switch(s[index + 2]){
				case '<':
					switch(s[index + 3]){
					default:return new Token(Token.Tag.DEEPLT, "<<<",0);
					}
				default:return new Token(Token.Tag.LT, "<",0);
				}
			default:return new Token(Token.Tag.LT, "<",0);
			}
		case '(':
			switch(s[index + 1]){
			default:return new Token(Token.Tag.LPAREN, "(",0);
			}
		case '[':
			switch(s[index + 1]){
			default:return new Token(Token.Tag.LSQUARE, "[",0);
			}
		case '>':
			switch(s[index + 1]){
			case '>':
				switch(s[index + 2]){
				case '>':
					switch(s[index + 3]){
					default:return new Token(Token.Tag.DEEPGT, ">>>",0);
					}
				default:return new Token(Token.Tag.GT, ">",0);
				}
			case '=':
				switch(s[index + 2]){
				default:return new Token(Token.Tag.GE, ">=",0);
				}
			default:return new Token(Token.Tag.GT, ">",0);
			}
		case '/':
			switch(s[index + 1]){
			default:return new Token(Token.Tag.DIV, "/",0);
			}
		case 'f':
			switch(s[index + 1]){
			case 'a':
				switch(s[index + 2]){
				case 'l':
					switch(s[index + 3]){
					case 's':
						switch(s[index + 4]){
						case 'e':
							switch(s[index + 5]){
							default:return new Token(Token.Tag.FALSE, "false",0);
							}
						default:return null;
						}
					default:return null;
					}
				default:return null;
				}
			case 'n':
				switch(s[index + 2]){
				default:return new Token(Token.Tag.FN, "fn",0);
				}
			default:return null;
			}
		case '}':
			switch(s[index + 1]){
			default:return new Token(Token.Tag.RBRACE, "}",0);
			}
		case 'm':
			switch(s[index + 1]){
			case 'o':
				switch(s[index + 2]){
				case 'd':
					switch(s[index + 3]){
					default:return new Token(Token.Tag.MOD, "mod",0);
					}
				default:return null;
				}
			default:return null;
			}
		case '+':
			switch(s[index + 1]){
			default:return new Token(Token.Tag.PLUS, "+",0);
			}
		case 't':
			switch(s[index + 1]){
			case 'h':
				switch(s[index + 2]){
				case 'e':
					switch(s[index + 3]){
					case 'n':
						switch(s[index + 4]){
						default:return new Token(Token.Tag.THEN, "then",0);
						}
					default:return null;
					}
				default:return null;
				}
			case 'r':
				switch(s[index + 2]){
				case 'u':
					switch(s[index + 3]){
					case 'e':
						switch(s[index + 4]){
						default:return new Token(Token.Tag.TRUE, "true",0);
						}
					default:return null;
					}
				default:return null;
				}
			default:return null;
			}
		case '{':
			switch(s[index + 1]){
			default:return new Token(Token.Tag.LBRACE, "{",0);
			}
		case 'o':
			switch(s[index + 1]){
			case 'r':
				switch(s[index + 2]){
				default:return new Token(Token.Tag.OR, "or",0);
				}
			default:return null;
			}
		case ')':
			switch(s[index + 1]){
			default:return new Token(Token.Tag.RPAREN, ")",0);
			}
		case 'w':
			switch(s[index + 1]){
			case 'h':
				switch(s[index + 2]){
				case 'i':
					switch(s[index + 3]){
					case 'l':
						switch(s[index + 4]){
						case 'e':
							switch(s[index + 5]){
							default:return new Token(Token.Tag.WHILE, "while",0);
							}
						default:return null;
						}
					default:return null;
					}
				default:return null;
				}
			default:return null;
			}
		case 'r':
			switch(s[index + 1]){
			case 'e':
				switch(s[index + 2]){
				case 't':
					switch(s[index + 3]){
					case 'u':
						switch(s[index + 4]){
						case 'r':
							switch(s[index + 5]){
							case 'n':
								switch(s[index + 6]){
								default:return new Token(Token.Tag.RETURN, "return",0);
								}
							default:return null;
							}
						default:return null;
						}
					default:return null;
					}
				default:return null;
				}
			default:return null;
			}
		default:return null;
		}
	}
}
