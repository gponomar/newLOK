package test;
//Gracie - Unit test
import static org.junit.Assert.assertTrue;
import java.io.FileNotFoundException;
import org.junit.Test;
import logic.HighScore;
import logic.TopScoreManager;

public class TestSetHighScoreLabels {
	@Test
	public void testSetScores() throws FileNotFoundException {
		HighScore test = new HighScore();
		TopScoreManager.getInstance().refreshScores("resource/testTopScores");
		test.setHighScoreLabels();
		String score1 = test.getScore1();
		String expected = "1.   25   Kiley";
		assertTrue(score1.equals(expected));
	}
}
