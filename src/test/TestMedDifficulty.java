package test;
// Integration test  - test that medium diff set in settings
// also sets in game page when back button is hit
import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import logic.Home;

public class TestMedDifficulty {

	@Test
	public void testPlayBtn() throws InterruptedException {
		Home test =  new Home();
		test.getSettingsBtn().doClick();
		TimeUnit.MILLISECONDS.sleep(50);
		test.settingsPage.getSelectDiffs().setSelectedItem("Medium");
		test.settingsPage.getHomeBtn().doClick();
		TimeUnit.MILLISECONDS.sleep(50);
		test.getPlayBtn().doClick();
		String output = test.getGamePage().getDiff(); 
		assertEquals("Medium", output);
	}
}
