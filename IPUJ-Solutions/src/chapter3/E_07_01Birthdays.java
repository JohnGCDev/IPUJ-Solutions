package chapter3;

public class E_07_01Birthdays {

	public E_07_01Birthdays() {
		super();
	}
	//We will count how many people we should check to found that 
	//three people share the same birthday (day and month)
	public static void main(String[] args) {
		byte[] birthdays = new byte[365];  // For recording the possible birthdays
		short count=0;       // The number of people who have been checked.
		short birthday_random; //The checked person's birthday 
		//Choosing birthdays at random
		while (true) {
			birthday_random = (short)(Math.random()*365);
			count++;
			System.out.printf("Person %d has birthday number %d%n", count, birthday_random);
			
			if (++birthdays[birthday_random] > 2) {  
			   // This day was found twice before. We are done.
				break;
			}
		}
		System.out.println("\nA birthday was found three times after "+ count + " tries.");
	}
}
