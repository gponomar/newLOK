// Kiley Roberson - Integration Test 1
// Test that the settings selector is working and that choosing a 
// diff on the selector and exiting to the home page sets the game difficulty

package test;

import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import logic.Home;

public class TestHardDifficultySet {

	@Test
	public void testHardDiffBtn() throws InterruptedException {
		Home test =  new Home();
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