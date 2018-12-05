// Ryan Nevil Integration test 1
// Tests that once the game ends, we end up in YourScore Page.
package test;
import static org.junit.Assert.assertEquals;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import logic.Home;

public class TestYourScoreTransition {
	@Test
	public void testIntGame() throws InterruptedException {
		Home testHome = new Home();
		testHome.setDiff("Hard");
		testHome.getPlayBtn().doClick();
		TimeUnit.MILLISECONDS.sleep(12000);
		String newClass = String.valueOf(testHome.frm.getContentPane().getClass());
		assertEquals("class logic.YourScore", newClass.substring(0, newClass.indexOf('$')));
	}
}