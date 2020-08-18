package chapter4;

import static java.lang.System.out;

public class E_04_TenThousandDices {
	private static final int TIMES = 10000;
	
	public static void main(String[] args) {
		out.println("\tTotal On Dice\tAverage Number of Rolls");
		out.println("\t-------------\t-----------------------");
		try {
			for(byte i=2; i<=12; i++) {
				out.printf("\t     %02d      \t       %03.4f%n", i, experiment(i));
			}
		}catch(IllegalArgumentException e) {
			out.print("\nAn error has ocurred. " + e.getMessage());
		}
	}
	
	/**
	 * This function get the average after rolling a pair of dices, to get a specific value which must match sum of the
	 * obtained values from the dices, 10000 times  
	 * @author JDav
	 * @param n The specific value
	 * @return the average after 10000 times
	 * @throws IllegalArgumentException it is thrown if the parameter value is not into the range [2,12] of possible results
	 */
	public static float experiment(byte n) {
		if(n<2 || n >12) throw new IllegalArgumentException("The value must be within the range [2,12]");
		int avg = 0;
		//Computing the average of 10000 times
		for(int i=0; i<TIMES; i++) {
			avg += rollingUpToNumber(n);
		}
		return (float)avg/TIMES;
	}
	
	/**
	 * 
	 * @author JDav
	 * @param n An integer that represents the sum of two dices after rolling them 
	 * @return The number of times that the dices was rolling so that their sum comes up to be the parameter value 
	 */
	public static int rollingUpToNumber(byte n) {
		long d1, d2; short times=0;
		do{
			d1 = (byte)(Math.random()*6) + 1;
			d2 = (byte)(Math.random()*6) + 1;
			times++;
			//out.printf("Attempt #%03d -> %d & %d%n", times, d1, d2);
		}while(d1+d2 != n);
		return times;
	}
}
