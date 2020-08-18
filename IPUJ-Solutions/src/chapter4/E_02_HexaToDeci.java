package chapter4;

import shared.textio.TextIO;
import static java.lang.System.out;

public class E_02_HexaToDeci {

	/**
	 * 
	 * @author JDav
	 * 
	 * A class that convert a hexadecimal into its corresponding decimal integer value
	 * 
	 */
	public static void main(String[] args) {
		// First get a VALID response from the user
		String resp; int val, aux; boolean error = false;
		out.println("Welcome!");
		while(true) {
			out.print("Please input the hexadecimal integer to be converted. Enter 0 to exit: ");
			resp = TextIO.getln().trim();
			if (resp.equals("0")) break;
			//Converting
			val = 0;
			for(int i=0, j=resp.length(); i<j; i++) {
				aux = hexValue(Character.toLowerCase(resp.charAt(i)));
				if(error = aux == -1) {
					out.println("Invalid value, a legal value only must contain base-10 digits and/or letters A(a) through F(f)\n");
					break;
				}
				val = val*16 + aux;
			}
			if(!error) out.printf("The corresponding decimal integer value of your entered value is: %d%n%n", val);
		}
		out.print("We are done! Thanks for using this program.");
	}
	/**
	 * @author JDav
	 * @param c a hexadecimal value of char type
	 * @return the decimal integer value corresponding to hexadecimal integer entered as parameter. If c is not a legal 
	 * hexadecimal integer value, it will be returned "-1" literal
	 */
	public static int hexValue(char c) {
		//Is the parameter a number?
		if(Character.isDigit(c)) return Integer.parseInt(c+"");
		switch(c) {
			case 'a': return 10;
			case 'b': return 11;
			case 'c': return 12;
			case 'd': return 13;
			case 'e': return 14;
			case 'f': return 15;
			default: return -1;
		}
	}
}
