package chapter4;

import shared.textio.TextIO;
import static java.lang.System.out;

public class E_01_Capitalizing {

	public static void main(String[] args) {
		String resp;
		out.println("Welcome!");
		while(true) {
			out.print("Please type your string to capitalize it. Enter 0 to exit: ");
			resp = TextIO.getln();
			if(resp.equals("0")) break;
			out.print("The capitalized version of your string is:\n\n");
			printCapitalized(resp.trim());
		}
		out.print("We are done! Thanks for using this program.");

	}
	/**
	 * @author JDav
	 * @param str The String value to capitalize
	 * @return The capitalize version of the String parameter
	 */
	public static void printCapitalized(String str) {
		boolean firstLetter = true;
		char c;
		for(int i=0, j=str.length(); i<j; i++) {
			c = str.charAt(i);
			if(firstLetter && Character.isLetter(c))
				str = str.substring(0, i) + Character.toUpperCase(c) + ((i+1 == j)? "" :str.substring(i+1));
			firstLetter = !Character.isLetter(c);
		}
		out.print(str+"\n\n");
	}
}
