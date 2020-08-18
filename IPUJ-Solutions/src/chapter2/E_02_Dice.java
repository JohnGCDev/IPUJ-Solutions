package chapter2;

public class E_02_Dice {
	public static void main(String[] args) {
		int d1, d2;
		d1 = (int)(Math.random()*6)+1;
		d2 = (int)(Math.random()*6)+1;
		System.out.printf("The first die comes up: %d%n", d1);
		System.out.printf("The second die comes up: %d%n", d2);
		System.out.printf("The total roll is: %d", d1+d2);
	}
}
