package chapter3;

public class E_01_Dice {
	public static void main(String[] args) {
		byte d1, d2, count;
		count = 1;
		while(true) {
			d1 = (byte)(Math.random()*6+1);
			d2 = (byte)(Math.random()*6+1);
			System.out.printf("Attempt No. %03d -> %d & %d%n", count++, d1, d2);
			if(d1 == 1 && d2 == 1) {
				System.out.println("We have done it!");
				break;
			}
		}
	}
}
