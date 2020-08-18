package chapter2;

import shared.textio.TextIO;

public class E_05_Eggs {
	public static void main(String[] args) {
		int eggs, gross, dozen, units;
		System.out.print("Hello! How many eggs do you have?: ");
		eggs = TextIO.getInt();
		gross = eggs/144;
		dozen = (eggs%144)/12;
		units = (eggs%144)%12;
		System.out.printf("%nSo you have %d gross, %d dozen, and %d units of eggs",gross, dozen, units);
		System.out.printf("%nSince %d is equal to 9*%d + 12*%d + %d",eggs, gross, dozen, units);
	}
}
