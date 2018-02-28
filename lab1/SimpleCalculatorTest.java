package lab1;

import static org.junit.Assert.*;
import org.junit.Test;

public class SimpleCalculatorTest {
	
	static final double epsilon = 0.000001;
	SimpleCalculator calc = new SimpleCalculator();

	@Test
	public void testAddition() {
		
//		SimpleCalculator calc = new SimpleCalculator();
		
		assertEquals(2.0, calc.add(1, 1), epsilon);
		assertEquals(1.0, calc.add(0.5, 0.5), epsilon);
		assertEquals(0.0, calc.add(0.5, -0.5), epsilon);
		assertEquals(0.0, calc.add(-0.5, 0.5), epsilon);
		assertEquals(-1.0, calc.add(-0.5, -0.5), epsilon);
		assertEquals(2.6, calc.add(2.6, 0.0), epsilon);
	}
	
	@Test
	public void testSubtraction() {
//		SimpleCalculator calc = new SimpleCalculator();
		
		assertEquals(0, calc.subtract(1, 1), epsilon);
		assertEquals(500.5, calc.subtract(502.5, 2), epsilon);
	}
	
	@Test
	public void testMultiplication() {
//		SimpleCalculator calci = new SimpleCalculator();
		
		assertEquals(30.25, calc.multiply(5.5, 5.5), epsilon);
		assertEquals(25, calc.multiply(2.5, 10), epsilon);
		
		
	}

	@Test
	public void testDivision() {
		assertEquals(1, calc.divide(5.5, 5.5), epsilon);
	}
	
	@Test
	public void testFloatingPointError() {
		
//		double epsilon = 0.0;
//		SimpleCalculator calc = new SimpleCalculator();

		double x = 0.0;
		x = calc.add(x, 0.1);
		x = calc.add(x, 0.1);
		x = calc.add(x, 0.1);
		x = calc.add(x, 0.1);
		x = calc.add(x, 0.1);
		x = calc.add(x, 0.1);
		x = calc.add(x, 0.1);
		x = calc.add(x, 0.1);
		x = calc.add(x, 0.1);
		x = calc.add(x, 0.1);
		assertEquals(1.0, x, epsilon); // do not use locally scoped epsilon

	}

}