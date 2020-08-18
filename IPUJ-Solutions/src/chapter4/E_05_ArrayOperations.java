package chapter4;

import shared.textio.TextIO;
import static java.lang.System.out;

import shared.interfaces.ArrayProcessor;

public class E_05_ArrayOperations {

	/**
	 * 
	 * @author JDav
	 * A simple program to check lambda expression's functionality
	 * Four variables of ArrayProcessor type that are defined through lambda expressions, they are:
	 * <ul>
	 * <li> maxValue: Finds the maximum value within an array of double[] type </li>
	 * <li> minValue: Finds the minimum value within an array of double[] type </li>
	 * <li> sumValue: Finds the sum of the values within an array of double[] type </li>
	 * <li> avgValue: Finds the average of the values within an array of double[] type </li>
	 * </ul>
	 * And a function that returns a value of ArrayProcessor type, this return value represent the 
	 * number of times that it occurs in an array of double[] type
	 */
	public static final ArrayProcessor maxValue = (array) -> {
		double max = 0.0f;
		for(int i=0, j=array.length; i<j; i++) {
			if(max < array[i]) max = array[i];
		}
		return max;
	};
	
	public static final ArrayProcessor minValue = (array) -> {
		double min = (array.length > 0)? array[0] : 0.0f;
		for(int i=0, j=array.length; i<j; i++) {
			if(min > array[i]) min = array[i];
		}
		return min;
	};
	
	public static final ArrayProcessor sumValue = (array) -> {
		double sum = 0.0f;
		for(int i=0, j=array.length; i<j; i++) {
			sum += array[i];
		}
		return sum;
	};
	
	public static final ArrayProcessor avgValue = (array) -> {
		if(array.length > 0) {
			return sumValue.apply(array)/array.length;
		}else {
			return 0.0f;
		}
	};
	
	/**
	 * @author JDav
	 * @param value the value of double type to find
	 * @return a object of ArrayProcessor type that is represented by a function literal (using lambda expressions)
	 * that can find how many times a value (the parameter) occurs within an array of double[] type
	 * 
	 */
	public static ArrayProcessor counter(double value) {
		return (array) -> {
			double count = 0.0f;
			for(int i=0, j=array.length; i<j; i++) {
				if(array[i] == value) count++;
			}
			return count;
		};
	}
	
	public static void main(String[] args) {
		double[] array = {25.3, -9.7, 0.5, 8.692, 24.006, -7.56, 13.8955, 0.5};
		out.println("Given the following array of type []double:");
		out.print("[");
		for(int i=0, j=array.length; i<j; i++) {
			out.print(array[i]);
			if(i != j-1) out.print("  ,  ");
		}
		out.print("]");
		out.printf("%n%nThe maximum value of the array is: %f%n", maxValue.apply(array));
		out.printf("The minimum value of the array is: %f%n", minValue.apply(array));
		out.printf("The total sum of the all values within the array is: %f%n", sumValue.apply(array));
		out.printf("The average value of all values within the array is: %f%n", avgValue.apply(array));
		out.print("Enter a value of double type to find the number of times that it occurs within the array: ");
		double resp = TextIO.getDouble();
		out.printf("%nYour input value occurs %.0f times within the array%n", counter(resp).apply(array));
		out.print("We are done! Thanks for using this program.");
	}
	
}
