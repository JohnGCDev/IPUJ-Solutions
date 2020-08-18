package chapter4;

import static java.lang.System.out;

public class E_03_PairDices {

	public static void main(String[] args) {
		try{
			out.println("The following lines simulate rolling a pair of dices to get snake eyes:");
			out.printf("%nAfter %d attempts we did got snake eyes%n", rollingUpToNumber((byte)2));
			out.print("We are done! Thanks for using this program.");
		}catch(IllegalArgumentException e) {
			out.print("\nAn error has ocurred. "+ e.getMessage());
		}
	}
	/**
	 * 
	 * @author JDav
	 * @param n An integer that represents the sum of two dices after rolling them 
	 * @return The number of times that the dices was rolling so that their sum comes up to be the parameter value 
	 * @throws IllegalArgumentException it is thrown if the parameter value is not into the range [2,12] of possible results
	 */
	public static int rollingUpToNumber(byte n) {
		if(n<2 || n >12) throw new IllegalArgumentException("The value must be within the range [2,12]");
		long d1, d2; short times=0;
		do{
			d1 = (byte)(Math.random()*6) + 1;
			d2 = (byte)(Math.random()*6) + 1;
			times++;
			out.printf("Attempt #%03d -> %d & %d%n", times, d1, d2);
		}while(d1+d2 != n);
		return times;
	}
}
