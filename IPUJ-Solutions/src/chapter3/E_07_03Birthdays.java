package chapter3;

public class E_07_03Birthdays {

	//Counting how many people must be verified to have a person whose birthday has already been checked with a 
	//probability of 100%
	public static void main(String[] args) {
		boolean[] birthdays = new boolean[365]; //All possible days in the year (no leap years)
		short remaining_days = 365; //The birthdays that still to be verified
		short birthday_random; //The checked person's birthday 
		int count=0;
		//Counting people and checking their birthdays
		while(remaining_days > 0) {
			birthday_random = (short)(Math.random()*365);
			if(!birthdays[birthday_random]) {
				remaining_days--;
				birthdays[birthday_random] = true; //Don't check this birthday "anymore"
			}
			System.out.printf("Person %04d has birthday number %03d - "
					+ "[%03d remaining birthdays]%n", ++count, birthday_random, remaining_days);
		}
		System.out.printf("%nAfter %d checked people, the %dth person will have a birthday%n"
				+ "that has already been checked with a probability of 100%%", count, count+1);
	}
}
