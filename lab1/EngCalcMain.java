package lab1;

import java.util.Scanner;

public class EngCalcMain extends EnglishCalculator {

	private static Scanner input;
	public static void main(String[] args) {
		input = new Scanner(System.in);
		
		double a = input.nextDouble();
		double b = input.nextDouble();
		System.out.println(EnglishCalculator.calculate(a+" add "+b));
		System.out.println(EnglishCalculator.calculate(a+" divided by "+b));
		System.out.println(EnglishCalculator.calculate(a+" minus "+b));
		System.out.println(EnglishCalculator.calculate(a+" times "+b));
		input.close();
	}

}
