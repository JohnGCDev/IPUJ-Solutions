package chapter5;
/**
 * @author JDav
 * Program for doing the experiment of rolling a pair of dices until a total given value comes up 10000 times.
 * Then report the average number and standard deviation of the 10000 attempts. Do the same for all the 
 * possible totals (2,3,4,..,12).
 * This program uses the classes: E_01_PairOfDiceReforged and E_02_StatCalcReforged.
 */
public class E_03_DiceExperiment {

	public static void main(String[] args) {
		E_01_PairOfDiceReforged dice = new E_01_PairOfDiceReforged();
		E_02_StatCalcReforged calc = new E_02_StatCalcReforged();
		
		System.out.print("Welcome to the dice experiment. Results:\n\n");
		System.out.println("  TOTAL  |  MEAN  |  STANDARD DEVIATION  |  MAXIMUM NUMBER OF ROLLS  |  MINIMUM NUMBER OF ROLLS");
		System.out.println("-----------------------------------------------------------------------------------------------");
		for(int total=2; total<=12; total++) {
			try {
				for(int i=0; i<10000; i++) {
					calc.enter(dice.timesToUpToValue(total, false));
				}
				System.out.printf("   %02d    | %6.3f |        %6.3f        |            %3d            |"
						+ "            %d%n",
						total, calc.getMean(), calc.getStandardDeviation(), (int)calc.getMax(), (int)calc.getMin());
				calc = new E_02_StatCalcReforged(); //Reset object
			}catch(IllegalArgumentException e) {
				System.out.println("An error has occurred. "+e.getMessage());
			}
		}
	}

}
