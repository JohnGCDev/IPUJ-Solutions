package chapter3;

public class E_02_Divisors {
	public static void main(String[] args) {
		short countDivisors, maxCountDivisors, maxNumber;
		maxNumber = maxCountDivisors = countDivisors = 0;
		
		for(short num=2; num<=10000; num++) {
			for(short j=1; j<=num/2; j++) {
				if(num%j == 0) countDivisors += 1;
			}
			//Searching a larger counter of divisors
			if(countDivisors > maxCountDivisors) {
				maxCountDivisors = countDivisors;
				maxNumber = num;
			}
			countDivisors = 0;
		}
		System.out.printf("In the range from 1 to 10000 the integer which has the"
				+ " largest number of divisors is:%n\t\t%d - with -> %d divisors.", maxNumber, maxCountDivisors+1); 
		//Added the number itself which is also a divisor
	}
}
