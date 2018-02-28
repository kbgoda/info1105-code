package lab1;


public class SimpleCalculator implements Arithmetic {
	public SimpleCalculator() {
		
	}
	
	public double add(double num1, double num2) {
		return num1 + num2;
	}
	
	public double subtract(double num1, double num2) {
		return num1 - num2;
	}
	
	public double multiply(double num1, double num2) {
		return num1 * num2;
	}
	
	public double divide(double num1, double num2) {
		return num1 / num2;
	}

}
