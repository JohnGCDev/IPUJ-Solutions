package chapter2;

import shared.textio.TextIO;

public class E_04_Money {
	public static void main(String[] args) {
		//     1/4 $ - 1/10 $ - 1/20$ - 1/100 $
		int quarters, dimes, nickels, pennies;
		float total;
		System.out.print("HELLO\nHow many quarters do you have?: ");
		quarters = TextIO.getlnInt();
		System.out.print("\nHow many dimes do you have?: ");
		dimes = TextIO.getlnInt();
		System.out.print("\nHow many nickels do you have?: ");
		nickels = TextIO.getlnInt();
		System.out.print("\nHow many pennies do you have?: ");
		pennies = TextIO.getlnInt();
		total = quarters/4.0f + dimes/10.0f + nickels/20.0f + pennies/100.0f;
		System.out.printf("%n%nYou have %.3f dollars in total", total);
	}
}
