package chapter5;
import shared.textio.TextIO;
/** 
 * @author David J. Eck (modified by JDav)
 * An object of class StatCalcReforged (inspired by StatCalc class) can be used
 * to compute several simple statistics for a set of numbers.
 * Numbers are entered into the dataset using
 * the enter(double) method.  Methods are provided to return the following
 * statistics for the set of numbers that have been entered: The number
 * of items, the sum of the items, the maximum and minimum value, the average, and the standard deviation
 */

public class E_02_StatCalcReforged {

    private int count = 0;   // Number of numbers that have been entered.
    private double sum = 0;  // The sum of all the items that have been entered.
    private double squareSum = 0;  // The sum of the squares of all the items.
    private double max = 0;		//The maximum entered value
    private double min = 0;		//The minimum entered value
    
    /**
     * @author David J. Eck (modified by JDav)
     * Add a number to the dataset.  The statistics will be computed for all
     * the numbers that have been added to the dataset using this method.
     */
    public void enter(double num) {
        count++;
        sum += num;
        squareSum += num*num;
        if(num > max) max = num;
        if(num < min) min = num;
    }

    /**
     * Return the number of items that have been entered into the dataset.
     */
    public int getCount() {
        return count;
    }

    /**
     * Return the sum of all the numbers that have been entered.
     */
    public double getSum() {
        return sum;
    }

    /**
     * Return the average of all the items that have been entered.
     * The return value is Double.NaN if no numbers have been entered.
     */
    public double getMean() {
        return sum / count;  
    }
    
    /**
     * @author JDav
     * @return Maximum entered value
     */
    public double getMax() {
    	return max;
    }
    
    /**
     * @author JDav
     * @return Minimum entered value
     */
    public double getMin() {
    	return min;
    }

    /**
     * Return the standard deviation of all the items that have been entered.
     * The return value is Double.NaN if no numbers have been entered.
     */
    public double getStandardDeviation() {  
        double mean = getMean();
        return Math.sqrt( squareSum/count - mean*mean );
    }
    
    public static void main(String[] args) {
    	E_02_StatCalcReforged calc = new E_02_StatCalcReforged();
    	double resp;
    	System.out.println("Welcome to the Stat Calculator Reforged Program\n");
    	while(true) {
    		System.out.print("Insert a value (Input 0 to finish): ");
    		resp = TextIO.getlnDouble();
    		if(resp == 0.0f) break;
    		calc.enter(resp);
    	}
    	System.out.printf("%nYour numbers' statistics are:%n1. Count: %d%n"
    			+ "2. Sum: %.4f%n3. Mean: %.4f%n4. Maximum: %.4f%n5. Minimum: %.4f%n"
    			+ "6. Standard Deviation: %.4f"
    			, calc.getCount(), calc.getSum(), calc.getMean(), calc.getMax(),
    			calc.getMin(), calc.getStandardDeviation());
    }
}  // end class StatCalc
