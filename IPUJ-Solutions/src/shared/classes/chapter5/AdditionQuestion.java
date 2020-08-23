package shared.classes.chapter5;
/**
 * @author David J.Eck
 * Class that represents a single addition question.
 */
public class AdditionQuestion implements IntQuestion{
	private int a, b; // The numbers in the problem.
	
	public AdditionQuestion() { // constructor
		a = (int)(Math.random() * 50 + 1);
		b = (int)(Math.random() * 50);
	}
	
	public String getQuestion() {
		return "What is " + a + " + " + b + " ?";
	}
	
	public int getCorrectAnswer() {
		return a + b;
	}
}
