// Kiley Roberson - Integration Test 2

// Test that hitting the start button starts the timer and hitting the back 
// button stops the timer
package test;

import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import logic.Home; 

public class TestTimer {

	@Test
	public void tesTimer() throws InterruptedException {
		Home test = new Home();
		test.getPlayBtn().doClick();
		TimeUnit.MILLISECONDS.sleep(50);
		Boolean quit = test.getClock().quit;
		assertEquals(quit, false);
		test.getGamePage().getBackBtn().doClick();
		Boolean stopped = test.getClock().quit;
		System.out.println(stopped);
		assertEquals(stopped, true);
	}
}