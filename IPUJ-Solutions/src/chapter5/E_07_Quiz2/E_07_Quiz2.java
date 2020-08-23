package chapter5.E_07_Quiz2;

import static java.lang.System.out;

import shared.classes.chapter5.AdditionQuestion;
import shared.classes.chapter5.IntQuestion;
import shared.textio.TextIO;

/**
 * @author JDav
 * Program that administers a quiz with several different kinds of questions.
 */
public class E_07_Quiz2 {
	private static final int NUMBER_QUESTIONS = 10;
	private static final int SCORE_PER_QUESTION = 10;
	private static IntQuestion[] questions = new IntQuestion[NUMBER_QUESTIONS];
	private static int[] userAnswers = new int[NUMBER_QUESTIONS];
	
	public static void main(String[] args) {
		createQuiz();
		administerQuiz();
		gradeQuiz();
	}
	

	/**
	 * @author JDav
	 * Method for creating each one the quiz's questions and reference them. Choice about kind of question is random.
	 */
	public static void createQuiz() {
		int size = questions.length;
		//Variables that indicates whether a specific non-math question has already been created.
		boolean q1 = false, q2 = false;
		for(int i=0; i<size; i++) {
			switch((int)(Math.random()*3)) {
			case 0: //Create an addition question
				questions[i] = new AdditionQuestion();
				break;
			case 1: //Create a subtraction question
				questions[i] = new SubtractionQuestion();
				break;
			default: //Create non-math question
				if(!q1) {//Create this questions just once
					questions[i] = new IntQuestion() {
						public String getQuestion() {
							return "What year was America discovered?";
						}
						public int getCorrectAnswer() {
							return 1492;
						}
					};
					q1 = true;
				}else if(!q2) {
					questions[i] = new IntQuestion() {
						public String getQuestion() {
							return "What year did man arrive to the moon?";
						}
						public int getCorrectAnswer() {
							return 1969;
						}
					};
					q2 = true;
				}else {
					i--; //Reset this iteration until questions[i] get a question.
				}
			}
		}
	}
	
	/**
	 * @author JDav
	 * Method that administers the created quiz to the user and hold his/her answers into userAnswers array.
	 */
	public static void administerQuiz() {
		out.println("Welcome! Let's take a quiz!");
		int size = questions.length;
		for(int i=0; i<size; i++) {
			out.printf("%n%02d. %-37s -> ", i+1, questions[i].getQuestion());
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
			out.printf("%n%02d: %-37s = %4d  &  Your answer: %4d   ->   %s", i+1, 
					questions[i].getQuestion(), answer, userAnswers[i],
					(answer == userAnswers[i])?"Right!":"Wrong!");
		}
		out.printf("%n%nYOUR TOTAL SCORE: %03d", score);
	}
}