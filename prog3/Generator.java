import java.util.ArrayList;
import java.util.Scanner;


/*
 * class: Generator
 * Method: 
 * 			insert(String s): add new json value to the tree, it will call helper class to insert.
 * 			insertHelper(Node oroot, String s): get start node and string to insert new subNode to start node.
 * 												it is recursively insertions.
 * 			main(String args): main is to create new ouput program
 * 			printSwitchCase(Node oroot, int i, String s, ArrayList<Node>list, String p): this function it to
 * 							recursively to print main part of switch cases;
 * 			bestMatch(String s, Arraylist<Node> list): it to find if list has value same with s
 * 			getTag(String s, ArrayList<Node> list): it to find the token's tag with same value with s.
 *
 * inner class: Node
 * 				it is basic node to hold char current, and its sub nodes.
 * 
 */
public class Generator {
	class Node{
		char current;
		ArrayList<Node> children = new ArrayList<Node>();
		
	}
	
	Node root = new Node();				// root
	/*
	 * method insert
	 * parameters: String s
	 * return: none
	 * description: call the insertHelper method to do recursive insertion.
	 * 
	 */
	public void insert(String s){
		insertHelper(root, s);
	}
	
	/*
	 * method insertHelper
	 * parameters: Node oroot String s
	 * return: none
	 * description: recursively insert  the chars from string s into tree.
	 * 
	 */
	public void insertHelper(Node oroot, String s){
		Node newNode = new Node();
		if(s.length()>0){			// if string s is empty return, if not the node's current will first char of string
			newNode.current = s.charAt(0);
		}
		else{
			return;
		}
		boolean flag = true;	// flag determines if the char already exsit in the tree 
		for(int i = 0; i<oroot.children.size(); i++){ // loop whole children
			if(oroot.children.get(i).current == s.charAt(0)){
				flag = false;
				insertHelper(oroot.children.get(i), s.substring(1));
			}
		}
		if(flag){		// if current char is not exsit in the tree
			oroot.children.add(newNode);
			insertHelper(oroot.children.get(oroot.children.size()-1), s.substring(1));	
		}
	}
	/*
	 * class: main
	 * parameters: args
	 * return: none
	 * description: the main will read json list and first argument as new output program's class name.
	 * 				if will make single static method for output program.
	 * 
	 */
	public static void main(String[] args){
		Scanner jsonScan = new Scanner(System.in);
		String source ="";
		while(jsonScan.hasNext()){
			source += jsonScan.next();
		}
		ArrayList<Token> list = (ArrayList<Token>) JSON.fromJsonToTokens(source);
		Generator newGen = new Generator();
		for(int i =0; i<list.size(); i++){
			newGen.insert(list.get(i).value);
		}
		// start create output program
		System.out.println("public class "+ args[0] + " {");		
		System.out.println("	public static Token getToken(char[] s, int index){");	
		String emptyString ="";
		printSwitchCase(newGen.root,0,emptyString,list,"");	// switch main part
		System.out.println("		default:return null;");
		System.out.println("		}");
		System.out.println("	}");		
		System.out.println("}");
		
	}
	/*
	 * method: printSwitchCase
	 * parameters: Node oroot, int i, String s, ArrayList<Node> list, String p
	 * 				oroot is start node, integer i is level number of switch case. String p is possible match.
	 * return: none;
	 * description: the method will recursively print out switch case for certain json list.
	 * 
	 */
	private static void printSwitchCase(Node oroot, int i,String s, ArrayList<Token> list, String p) {
		String taps ="";
		for(int k = 0; k<i+2; k++){	// get how many taps at front of each line.
			taps +="\t";
		}
		if(oroot.children.size() == 0){		// if node does not have sub node, this means it is most inner case,return
			System.out.println(taps+"switch(s[index + "+ i +"]){");
			System.out.println(taps+"default:return new Token("+"Token.Tag."+getTag(s,list)+", \""+s+"\",0);");
			System.out.println(taps+"}");
			return;
		}
		String temp =""; // remember each level's char
		String prob =p;	// get possible match. for example, when reading <<, but the prob will still be <.
		if(oroot.children.size()!= 0){
			System.out.println(taps+"switch(s[index + "+ i +"]){");
			for(int j = 0;j<oroot.children.size(); j++){
				temp = s;
				prob = bestMatch(s,list); // find the best match possible
				s += oroot.children.get(j).current;	
				if(prob.length() == 0){
					prob = p;
				}
				System.out.println(taps+"case '"+oroot.children.get(j).current+"':");
				int m = j;
				int n = i;
				i++; // get deep into level
				printSwitchCase(oroot.children.get(j), i,s, list,prob);
				
				s = temp;	// make sure it string s be previous level s
				j = m;
				i = n;
			}
			if(i!=0){// if it is not first level
				if(prob.equals("")){	// if possible match is empty string, means null, no possible match.
					System.out.println(taps+"default:return null;");
				}else{
					System.out.println(taps+"default:return new Token("+"Token.Tag."+getTag(prob,list)+", \""+prob+"\",0);");
				}
				System.out.println(taps+"}");
			}
		}	
	}
	/*
	 * method: bestMatch
	 * parameters: string s ArrayList<Node> list
	 * return: none
	 * description: if the string s in the list' tokens' value. if not return empty string
	 * 
	 */
	private static String bestMatch(String s,ArrayList<Token>list) {
		for(int i = 0; i<list.size();i++){
			if(list.get(i).value.equals(s)){
				return s;
			}
		}
		return "";
	}
	/*
	 * method: getTag
	 * parameter: String s ArrayList<Node> list
	 * return: none;
	 * description: get tag from the list if token has same value with string s, if not found,return null.
	 * 
	 */
	private static String getTag(String s, ArrayList<Token>list) {
		for(int i = 0; i<list.size(); i++){
			if(list.get(i).value.equals(s)){
				return list.get(i).tag.toString();
			}
		}
		return "null";
	}	
	
}
