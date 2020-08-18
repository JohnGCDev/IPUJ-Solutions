package chapter3;

public class E_06_Divisors2 {

	public static void main(String[] args) {
		short countDivisors, maxCountDivisors;
		short[] log = new short[10001]; //number 10000 is not discarded 
		maxCountDivisors = countDivisors = 0;
		
		for(int num=2; num<=10000; num++) {
			for(int j=1; j<=num/2; j++) {
				if(num%j == 0) countDivisors += 1;
			}
			//Saving counter of divisors
			log[num] = countDivisors;
			//Searching a larger counter of divisors
			if(countDivisors > maxCountDivisors) {
				maxCountDivisors = countDivisors;
			}
			countDivisors = 0;
		}
		System.out.printf("In the range from 1 to 10000 the integers which%nhave the"
				+ " largest number of divisors, that is %d, are:%n", maxCountDivisors+1); 
		//Added the number itself which is also a divisor
		//Finally, we search and print out all the numbers with the maximum number of divisors
		for(int i=2; i<log.length; i++) {//Starting at the same point that variable num did it
			if (log[i] == maxCountDivisors) {
				System.out.println("\t"+i);
			}
		}
	}
}
