package chapter2;

import shared.textio.TextIO;

public class E_06_Names {

	public static void main(String[] args) {
		String full, first, last;
		System.out.print("Hello! Please enter your first name and you last name, separated by one space: ");
		full = TextIO.getlnString().trim();
		try {
		first = full.substring(0, full.indexOf(' '));
		last = full.substring(full.indexOf(' ')+1, full.length());
		System.out.printf("%nYour first name is: %s, wich has %d characters", first, first.length());
		System.out.printf("%nYour last  name is: %s, wich has %d characters", last, last.length());
		System.out.printf("%nAnd your initials are %s", (first.charAt(0)+""+last.charAt(0)).toUpperCase());
		}catch(Exception e) {
			System.out.println("ERROR: "+e.getMessage()+" -- Did you include a white space?");
		}
	}
}
