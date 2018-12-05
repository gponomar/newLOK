package test;

/* 
 * Ishan - Integration Test
 * Tests if the audio clip runs when home opens, 
 * and if pause button pauses music
 */
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import logic.Home;
import logic.Settings;

public class TestIntegrationAudio {
	
	@Test
	public void testAudioIsPlayer() throws InterruptedException {
		Home home = new Home();
		Settings s = new Settings();
		assertTrue(home.getSoundClip().isRunning());
		s.setHomepage(home);
		s.getPauseButton().doClick();
		assertTrue(!home.getSoundClip().isRunning());
	}
}
