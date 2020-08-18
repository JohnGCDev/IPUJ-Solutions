package chapter2;

import shared.textio.TextIO;

public class E_07_ScoreFile {

	public static void main(String[] args) {
		String name; int s1, s2, s3;
		System.out.println("...Reading file...");
		TextIO.readFile("C:\\Users\\A\\Documents\\notas\\testdata.txt");
		name = TextIO.getlnString();
		s1 = TextIO.getlnInt();
		s2 = TextIO.getlnInt();
		s3 = TextIO.getlnInt();
		TextIO.readStandardInput();
		System.out.printf("%n\tThe student's name is %s and his/her average grade is: %.3f", name, ((s1+s2+s3)/3.0f));
	}
}
