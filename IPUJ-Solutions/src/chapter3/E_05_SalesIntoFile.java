package chapter3;

import shared.textio.TextIO;

public class E_05_SalesIntoFile {

	public static void main(String[] args) {
		String line;
		byte noSales = 0, sales=0; double totalSales = 0.0f;
		TextIO.readFile("C:\\Users\\A\\Documents\\notas\\sales.dat");
		while(!TextIO.eof()) {
			line = TextIO.getlnString();
			line = line.substring(line.indexOf(':')+1, line.length());
			try {
				totalSales += Double.parseDouble(line);
				sales++;
			}catch(NumberFormatException e) {
				noSales++;
			}
		}
		System.out.printf("From %d cities processed, it was computed a total of %,.3f on sales%n", sales, totalSales);
		System.out.printf("Also, for %d cities there was not available data%n", noSales);
		System.out.print("\nWe have finished. See you soon.");
		TextIO.readStandardInput();
	}
}
