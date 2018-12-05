package test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import logic.TopScoreManager;

public class TestTopScoreManager {
	//unit
	@Test
	public void testSingleton() throws InterruptedException {
		TopScoreManager instance = TopScoreManager.getInstance();
		assertTrue(instance!=null && instance instanceof TopScoreManager);
	}
	//unit
	@Test
	public void testSingletonReturnsList() throws InterruptedException {
		TopScoreManager instance = TopScoreManager.getInstance();
		instance.refreshScores("resource/testTopScores");
		assertTrue(instance.getTopScores() !=null && instance.getTopScores() instanceof List<?>);
	}
}
