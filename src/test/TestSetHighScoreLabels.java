package test;
/* 
 * Ishan - Integration test
 * Tests if score label is properly set on high scores page
 */
import static org.junit.Assert.assertTrue;
import java.io.FileNotFoundException;
import org.junit.Test;
import logic.HighScore;
import logic.TopScoreManager;

public class TestSetHighScoreLabels {
    @Test
    public void integrationTestForScores() {
        HighScore test = new HighScore();
        TopScoreManager.getInstance().refreshScores("resource/testTopScores11");
        test.setHighScoreLabels();
        assertTrue(test.getScore1Label().getText().equals("1.   25   Kiley"));
    }
}