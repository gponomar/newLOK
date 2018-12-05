package test;

import static org.junit.Assert.assertTrue;
import java.util.List;

import org.junit.Test;

import logic.TopScoreManager;

public class TestTopScoreManager {
	@Test
	public void testSingleton() throws InterruptedException {
		TopScoreManager instance = TopScoreManager.getInstance();
		assertTrue(instance!=null && instance instanceof TopScoreManager);
	}
	@Test
	public void testSingletonReturnsList() throws InterruptedException {
		TopScoreManager instance = TopScoreManager.getInstance();
		instance.refreshScores("resource/testTopScores");
		assertTrue(instance.getTopScores() instanceof List<?>);
	}
}
