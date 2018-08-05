/*
 * Class to represent a scanner within our compiler.
 */
/*
 * author: zhangpeng liao
 * Prog02
 * Due: 01/02/2017 
 * 
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * class: Scanner
 * description: the Scanner is to read inputStream char by char. find each available string as tokens.
 * 				number token: digit{dight}   identifier token: letter{letter | digit}
 * 
 */

public class Scanner {
	ArrayList<Token> list = new ArrayList<Token>();	// token list
    Token current;		// current token
    int count = 1;		// count line
   
    // Constructor
    // The constructor should call advance to set the first token
    public Scanner(InputStream is) {
    	InputStreamReader a = new InputStreamReader(is);
    	try {
    		char[] source = new char[40000];
    		a.read(source);
			for(int i = 0; i<40000 ; i++){
				// read new line
				if(source[i]==10){
					count ++;
				}
	
				// read number
				if(isDigit(source[i])){
					String num ="" + source[i];
					int j = i+1;
					while(isDigit(source[j])){
						num = num + source[j];
						j++;
					}
					i = j-1;
					Token newToken = new Token();		// create new number token
					newToken.value = num;
					newToken.tag = Token.Tag.INTLIT;
					newToken.line = count;
					list.add(newToken);					// add it to list
				}
				// read identifier
				if(isLetter(source[i])){
					String stri =""+source[i];
					int j = i+1;
					while(isDigit(source[j]) || isLetter(source[j])){
						stri = stri + source[j];
						j++;
					}
					i=j-1;
					Token newToken = new Token();		// create new identifier token
					newToken.value = stri;
					newToken.tag = Token.Tag.ID;
					newToken.line = count;
					list.add(newToken);					// add it to list
				}
				
			}
			Token eofToken = new Token();				// add eof token at end of list
			eofToken.tag = Token.Tag.EOF;
			list.add(eofToken);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	Advance();		// initial first token.
    }
    /*
     * method: isDigit
     * parameter: char c
     * return: boolean
     * description: this method will check parameter char c if it is a digit
     * 
     */
    private boolean isDigit(char c){
    	if(c<=57 && c>=48){
    		return true;
    	}
    	return false;
    }
    /*
     * method: isLetter
     * parameter: char c
     * return: boolean
     * description: this method will check parameter char c if it is a letter
     * 
     */
    private boolean isLetter(char c){
    	if((c<=90 && c>=65)||(c>=97 && c<=122)){
    		return true;
    	}
    	return false;
    }
    
    // Get the next token in stream and set it to current
    public void Advance(){
    	current = list.get(0);
    	list.remove(0);
    }


    /* Not currently implemented for project 2
    void Match(Enum Type) {

    }
    */
}
