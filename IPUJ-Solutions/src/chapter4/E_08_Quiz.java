package chapter4;

import shared.textio.TextIO;
import static java.lang.System.out;
/**
 * 
 * @author JDav
 * This program administers a basic addition quiz to the user. For that, it uses 3 subroutines, one to create the quiz,
 * another for administer it and the last one for grade the it.
 * In addition, the program uses 3 global variables of type int[] for hold the questions' numbers and user's answers 
 *
 */
public class E_08_Quiz {

	private static final int NUMBER_QUESTIONS = 10;
	private static final int SCORE_PER_QUESTION = 10;
	
	private static int[] firstOperator = new int[NUMBER_QUESTIONS];
	private static int[] secondOperator = new int[NUMBER_QUESTIONS];
	private static int[] answer = new int[NUMBER_QUESTIONS];
 	
	public static void main(String[] args) {
		createQuiz();
		administerQuiz();
		gradeQuiz();
	}
	
	/**
	 * This subroutine fill firstOperator and secondOperator global arrays with random numbers in the range [10, 99]
	 * @author JDav
	 */
	public static void createQuiz() {
		for(int i=0; i<NUMBER_QUESTIONS; i++) {
			firstOperator[i] = (int)(Math.random()*90)+10;
			secondOperator[i] = (int)(Math.random()*90)+10;
		}
	}
	
	/**
	 * This subroutine administer the created quiz to the user and hold his/her answers into answers global array
	 * @author JDav
	 */
	public static void administerQuiz() {
		out.println("Welcome! Let's take an addition quiz!");
		for(int i=0; i<NUMBER_QUESTIONS; i++) {
			out.printf("%nQuestion #%02d: %02d + %02d = ", i+1, firstOperator[i], secondOperator[i]);
			answer[i] = TextIO.getlnInt();
		}
	}
	
	/**
	 * This subroutine evaluate each user's answer, output them along with the correct answer, 
	 * count every correct user's answer and output the final score to the user
	 * @author JDav
	 */
	public static void gradeQuiz() {
		int score = NUMBER_QUESTIONS * SCORE_PER_QUESTION;
		out.println("SOLUTIONS:");
		for(int i=0; i < NUMBER_QUESTIONS; i++) {
			if(firstOperator[i]+secondOperator[i] != answer[i]) score -=10;
			out.printf("%nQuestion #%02d: %02d + %02d = %03d  &  Your answer: %03d   ->   %s", i+1, 
					firstOperator[i], secondOperator[i], firstOperator[i] + secondOperator[i], answer[i],
					(firstOperator[i]+secondOperator[i] == answer[i])?"Right!":"Wrong!");
		}
		out.printf("%n%nYOUR TOTAL SCORE: %03d", score);
	}
}