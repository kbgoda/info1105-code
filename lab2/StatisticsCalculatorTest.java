package lab2;

import static org.junit.Assert.*;

import org.junit.Test;

public class StatisticsCalculatorTest {
	
	static final double epsilon = 0.01;
	StatisticsCalculator Karan = new StatisticsCalculator();

	@Test
	public void empty() {
		assertEquals("IC", Karan.getGrade());
		assertEquals(0.0, Karan.getAverage(), epsilon);
	}
	
	@Test
	public void correctAvg() {
		Karan.addScore(76);
		Karan.addScore(70);
		Karan.addScore(64);
		assertEquals("CR", Karan.getGrade());
		assertEquals(70, Karan.getAverage(), epsilon);
	}
	
	@Test
	public void distinction() {
		Karan.addScore(84);
		Karan.addScore(85);
		Karan.addScore(85);
		assertEquals(84.67, Karan.getAverage(), epsilon);
		assertEquals("D", Karan.getGrade());
	}
	
	@Test
	public void highDistinction() {
		Karan.addScore(86);
		Karan.addScore(85);
		Karan.addScore(85);
		assertEquals(85.33, Karan.getAverage(), epsilon);
		assertEquals("HD", Karan.getGrade());
	}

}
