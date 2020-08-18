package chapter3;

import shared.textio.TextIO;

public class E_04_Words {

	public static void main(String[] args) {
		String text, parcial="";
		char c;
		int textLength;
		System.out.print("Hi! Please enter a text line\n? ");
		text = TextIO.getlnString().trim();
		textLength = text.length();
		for(int i = 0; i<textLength; i++) {
			c = text.charAt(i);
			//Whether the character is a letter, add it to 'parcial' variable 
			if(Character.isLetter(c)) {
				parcial += c + "";
			}
			//Whether the character is a '\'' between two letters, add it to 'parcial' variable 
			else if(c == '\'' && parcial.length() > 0 && i+1<textLength && Character.isLetter(text.charAt(i+1))) {
				parcial += c + "";
			}
			//Whether the character is not  a letter or a '\'' between two letters, 
			//skip that out and print out the hosted word into 'parcial' variable, if exists
			else if(parcial.length() > 0) { 
				System.out.println(parcial);
				parcial = "";
			}
			//Always, at the end of the text line, print out the remaining word into 'parcial' variable, if exists
			if (i+1 == textLength && parcial.length() > 0) {
				System.out.println(parcial);
				parcial = "";
			}
		}
		System.out.print("\nWe have finished! See you soon.");
	}
}
