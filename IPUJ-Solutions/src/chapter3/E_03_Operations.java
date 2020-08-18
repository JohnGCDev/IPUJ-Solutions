package chapter3;

import shared.textio.TextIO;

public class E_03_Operations {
	public static void main(String[] args) {
		double n1, n2, r;
		char operator;
		TextIO.readStandardInput();
		System.out.println("Please enter your operation in the following format:\n\tnumber operator number"
					+ "\nNote: Allowed Operators: +, -, * and / Allowed Numbers: Real Numbers.\nInput 0 to exit.");
		do_while_loop:
		while(true) {
			System.out.print("? ");
			//Reading from a single input line
			n1 = TextIO.getDouble();
			if(n1 == 0.0f) break;
			operator = TextIO.getChar();
			n2 = TextIO.getDouble();
			//"Cleaning" input buffer
			TextIO.getln(); //Avoid the character '?', which is in Input Buffer, from appearing. 
			switch(operator) {
				case '+':
					r = n1+n2;
					break;
				case '-':
					r = n1-n2;
					break;
				case '*':
					r = n1*n2;
					break;
				case '/':
					r = n1/n2;
					break;
				default:
					System.out.println("Not recognized operator! Try again.");
					continue do_while_loop;
			}
			System.out.printf("%n\t\tThe response for your expression [%.4f %s %.4f] is = %.4f %n%n",n1, operator, n2, r);
			System.out.println("Enter another expression.");
			
		}
		System.out.println("We have finished! See you soon.");
	}
}
