package mainPackage;

import static org.junit.Assert.*;

import org.junit.Test;

public class TuitionTest {

	@Test
	public void calcTotalTuitionTest() {
		assertTrue(Tuition.calcTotalTuition(12500, 0.045) == 53477.3890625);
		
	}
	
	@Test
	public void calcPaymentsTest() {
		assertTrue(Tuition.calcPayments(10, 6, 53477.3890625) == 593.7086576247718);
	}

}
