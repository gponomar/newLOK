// Evan - Junit Test
// Test that the Junit counter is set correctly
package test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import logic.CountDown;

public class TestJunitCounter {

	@Test
	public void testScorePageButton() throws InterruptedException {
		CountDown test = new CountDown(null, "empty");
		
		long getLength = test.timeToRun("Easy");
		assertEquals(30000, getLength);
	}
}