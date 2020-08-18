package chapter3;

public class E_07_02Birthdays {

	//From 365 people chosen at random, how many people will have different birthday?
	public static void main(String[] args) {
		short[] birthdays = new short[365]; //All possible days in the year (no leap years)
		short count=0;
		short birthday_random; //The checked person's birthday 
		//Checking one person at time, from 1st to 365th
		for(short i=0; i<365; i++) {
			birthday_random = (short)(Math.random()*365);
			birthdays[birthday_random]++;
			System.out.printf("Person %d has birthday number %d%n", i+1, birthday_random);
		}
		//Counting how many people have different birthdays
		for(short i=0; i<365; i++) {
			if(birthdays[i] == 1) count++;
		}
		System.out.printf("%nFrom 365 people chosen at random, %d people have different birthdays.%nWe are done", count);
	}
}
