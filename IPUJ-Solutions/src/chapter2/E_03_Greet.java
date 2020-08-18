package chapter2;
import shared.textio.TextIO;

public class E_03_Greet {
	public static void main(String[] args) {
		String name;
		System.out.println("Please enter your name: ");
		name = TextIO.getlnWord();
		System.out.println("Hello "+name.trim().toUpperCase()+", nice to meet you!");
	}
}
