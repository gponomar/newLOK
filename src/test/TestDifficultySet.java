// Kiley Roberson - Junit Test 2
// Test that when the difficulty is selected in settings
// the level difficulty is changed in the game
package test;

import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import logic.Home;

public class TestDifficultySet {

	@Test
	public void testPlayBtn() throws InterruptedException {
		Home test = new Home();
		test.getSettingsBtn().doClick();
		TimeUnit.MILLISECONDS.sleep(50);
		test.settingsPage.getSelectDiffs().setSelectedItem("Hard");
		test.settingsPage.getHomeBtn().doClick();
		TimeUnit.MILLISECONDS.sleep(50);
		test.getPlayBtn().doClick();
		String output = test.getGamePage().getDiff();
		assertEquals("Hard", output);
	}
}