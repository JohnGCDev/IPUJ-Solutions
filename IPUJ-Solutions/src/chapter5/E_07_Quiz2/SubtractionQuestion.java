package chapter5.E_07_Quiz2;
import shared.classes.chapter5.IntQuestion;
/**
 * @author JDav
 * Class that represents a single subtraction question.
 */
public class SubtractionQuestion implements IntQuestion {
	private int a, b;
	
	@Override
	public String getQuestion() {
		do {
			a = (int)(Math.random()*50+1);
			b = (int)(Math.random()*50+1);
		}while(a-b < 0);
		return "What is " + a + " - " + b + " ?";
	}

	@Override
	public int getCorrectAnswer() {
		return a - b;
	}
}
