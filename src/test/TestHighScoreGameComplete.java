// Ryan Nevil Integration test 2
// Tests that the the back panel doesn't exists after one second, 
// because game page preparation for countdown observer
// sets it to null after initialization.
package test;
import static org.junit.Assert.assertEquals;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import logic.Home;

public class TestHighScoreGameComplete {
	@Test
	public void testIntGame() throws InterruptedException {
		Home testHome = new Home();
		testHome.setDiff("Hard");
		testHome.getPlayBtn().doClick();
		TimeUnit.MILLISECONDS.sleep(12000);
		testHome.yourscorePage.getDone().doClick();
		TimeUnit.MILLISECONDS.sleep(120);
		String newClass = String.valueOf(testHome.frm.getContentPane().getClass());
		assertEquals("class logic.HighScore", newClass.substring(0, newClass.indexOf('$')));
	}
}