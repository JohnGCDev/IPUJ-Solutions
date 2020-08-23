package chapter5;
import static java.lang.System.out;

import shared.classes.chapter5.AdditionQuestion;
import shared.textio.TextIO;
/**
 * @author JDav
 * Program similar to E_08_Quiz from chapter 4, except it uses objects of type AdditionQuestion for
 * representing each of the quiz's questions.
 */
public class E_06_QuizReforged {

	private static final int NUMBER_QUESTIONS = 10;
	private static final int SCORE_PER_QUESTION = 10;
	private static AdditionQuestion[] questions = new AdditionQuestion[NUMBER_QUESTIONS];
	private static int[] userAnswers = new int[NUMBER_QUESTIONS];
	
	public static void main(String[] args) {
		createQuiz();
		administerQuiz();
		gradeQuiz();
	}
	
	/**
	 * @author JDav
	 * Method for creating each one the quiz's questions and reference them.
	 */
	public static void createQuiz() {
		int size = questions.length;
		for(int i=0; i<size; i++) {
			questions[i] = new AdditionQuestion();
		}
	}
	
	/**
	 * @author JDav
	 * Method that administers the created quiz to the user and hold his/her answers into userAnswers array.
	 */
	public static void administerQuiz() {
		out.println("Welcome! Let's take an addition quiz!");
		int size = questions.length;
		for(int i=0; i<size; i++) {
			out.printf("%n%02d. %-17s -> ", i+1, questions[i].getQuestion());
			userAnswers[i] = TextIO.getlnInt();
		}
	}
	
	/**
	 * @author JDav
	 * Method for evaluating each user's answer, output them along with the correct answer, 
	 * counting every correct user's answer and output the final score to the user
	 */
	public static void gradeQuiz() {
		int score = NUMBER_QUESTIONS * SCORE_PER_QUESTION;
		out.println("\nSOLUTIONS:");
		int size = questions.length, answer;
		for(int i=0; i < size; i++) {
			answer = questions[i].getCorrectAnswer();
			if(answer != userAnswers[i]) score -=10;
			out.printf("%n%02d: %-17s = %03d  &  Your answer: %03d   ->   %s", i+1, 
					questions[i].getQuestion(), answer, userAnswers[i],
					(answer == userAnswers[i])?"Right!":"Wrong!");
		}
		out.printf("%n%nYOUR TOTAL SCORE: %03d", score);
	}
}