package lab1;

import static org.junit.Assert.*;

import org.junit.Test;

public class EnglishCalculatorTest {
	
	static final double epsilon = 0.000001;

	@Test
	public void integers() {
		assertEquals(20, EnglishCalculator.calculate("15 add 5"), epsilon);
		assertEquals(15, EnglishCalculator.calculate("15 minus 0"), epsilon);
		assertEquals(75, EnglishCalculator.calculate("15 times 5"), epsilon);
		assertEquals(3, EnglishCalculator.calculate("15 divided by 5"), epsilon);
		
	}
	
	@Test
	public void doubles() {
		assertEquals(0.06, EnglishCalculator.calculate("0.05 add 0.01"), epsilon);
		assertEquals(0.04, EnglishCalculator.calculate("0.05 minus 0.01"), epsilon);
		assertEquals(0.0005, EnglishCalculator.calculate("0.05 times 0.01"), epsilon);
		assertEquals(5, EnglishCalculator.calculate("0.05 divided by 0.01"), epsilon);
		
	}

}
