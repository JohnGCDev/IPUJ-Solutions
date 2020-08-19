package chapter5;
import shared.textio.TextIO;
/**
 * @author David J. Eck (modified by JDav)
 * This is a "remastered" PairOfDice class inspired by the one belonging to the Section 5.2
 */
public class E_01_PairOfDiceReforged {
	private int die1;   // Number showing on the first die.
    private int die2;   // Number showing on the second die.
    
    /**
     * @author David J. Eck
     * Constructor. Rolls the dice, so that they initially show some random values.
     */
    public E_01_PairOfDiceReforged() {
    	roll();
    }

    /**
     * @author David J. Eck (modified by JDav)
     * Constructor. Creates a pair of dice that are initially showing the values val1 and val2.
     */
    public E_01_PairOfDiceReforged(int die1, int die2) {
	    this.die1 = die1;
	    this.die2 = die2;
    }

    /**
     * @author JDav
     * @return die1 value
     */
    public int getDie1() {
    	return die1;
    }
    
    /**
     * @author JDav
     * @return die2 value
     */
    public int getDie2() {
    	return die2;
    }
    
    /**
     * @author David J. Eck
     * Roll the dice by setting each of the dice to be a random number between 1 and 6.
     */
	public void roll() {
	    die1 = (int)(Math.random()*6) + 1;
	    die2 = (int)(Math.random()*6) + 1;
	}

	/**
     * @author JDav
     * Show a String representation of the current state of the dice values.
     */
	@Override
    public String toString() {
    	return "The current values of the pair of dice are "+ getDie1() +" & " + getDie2() + ".";
    }
	
	/**
	 * @author JDav
	 * Method for counting how many times a pair of dice must be rolled until to the sum of 
	 * its values is equal a value passed as parameter.
	 * @param value the value to get via rolling the dice.
	 * @param verbose boolean value for evaluating whether it's necessary to write an output message in each dice roll.
	 * @return How many times the dice were rolled until get the value.
	 * @precondition The constructor has already been called.
	 * @throws IllegalArgumentException When the value passed as parameter is not in the range 2 to 12.
	 */
	public int timesToUpToValue(int value, boolean verbose) {
		if(value < 2 || value > 12) throw new IllegalArgumentException("The value must be in the range 2 to 12");
		int times = 0;
		if(verbose) {//Avoid "verbose" condition from repeating each time into while loop (it's unnecessary work)
			do {
				roll();
				System.out.print("\n" + (++times) + ". " + toString() + " And its sum is " + (getDie1() + getDie2()));
			}while(die1 + die2 != value);
		}else {
			do {
				roll();
				++times;
			}while(die1 + die2 != value);
		}
		return times;
	}
	
	/**
	 * @author JDav
	 * A short program that proves timesToUpToValue() method, the parameter is input by the user. 
	 */
	public static void main(String[] args) {
		E_01_PairOfDiceReforged dice = new E_01_PairOfDiceReforged();
		System.out.print("Please input an integer to search that represents the pair of dice's sum [2-12]: ");
		int resp = TextIO.getlnInt();
		try {
			System.out.print("\n\nTo obtain the sum of the dice values equal to "+ resp +" was neccessary " +
			dice.timesToUpToValue(resp, true) + " rolls.");
		}catch(IllegalArgumentException e) {
			System.out.print("\nAn error has occurred. "+ e.getMessage());
		}
	}

}
