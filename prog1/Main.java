import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/*
 * author: Zhangpeng Liao
 * class: CSC453 spring2017
 * Program: 1
 * Due: 25/01/2017
 *
 */

/*
 * method: main
 * parameters: String[] args // used scanner instead of argument
 * description: the prog1 main method will read json String, and convert to a
 * 				list of Tokens. sort this Token list and stdout json entity
 */
public class Main {
	public static void main(String[] args){
		Scanner strScanner = new Scanner(System.in);	// create scanner
		String source = strScanner.nextLine();			// read string
		strScanner.close();								// close scanner

		ArrayList<Token> list = (ArrayList<Token>) JSON.fromJsonToTokens(source);		// create a list of json Tokens
		ArrayList<Token> copyList = (ArrayList<Token>) JSON.fromJsonToTokens(source);	// get copy of json list
		for(int i = 0; i<list.size(); i++){
			for(int j = i+1; j < list.size(); j++){
				if(list.get(i).tag == list.get(j).tag){			// if two token has same tag delete it
					deleteToken(list.get(i).tag, copyList);		// call deleteTokoen()
				}
			}
		}

		Collections.sort(copyList, new valueComparator());		// sort the list 
		System.out.println(JSON.toJson(copyList));				// print out json list
	}

	/*
	 * method: deleteToken
	 * parameter: the tag we try to search, the json list
	 * description: deleteToken method will delete token tokens with same tag we try to search.
	 */
	private static void deleteToken(Token.Tag tag, ArrayList<Token> list) {
		int i =  0;
		while(i<list.size()){
			if(list.get(i).tag == tag){			// if token has tag we try to delete
				list.remove(i);					// remove it
				continue;						// continue, the list will be short, the continue will would not skip next one
			}
			i++;
		}
	}
}

/*
 * class: valueComparator
 * implement: Comparator<T>
 * description: this is comparator when doing collection sort. comparing two tokens' value.
 */
class valueComparator implements Comparator<Token>{
	@Override
	public int compare(Token o1, Token o2) {
		return o1.value.compareTo(o2.value);
	}

}

