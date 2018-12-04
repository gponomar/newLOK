package test;

import java.io.FileNotFoundException;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import logic.HighScore;

public class testHighScoreException {

	@Test
	public void TestForException() throws FileNotFoundException {
		HighScore test = new HighScore();
	    try{
	        test.getTopScores("file-that-doesnt-exist");
	    }catch(Exception e) {
	      assertTrue(e.getMessage().equals("SEVERE: File not found"));
	    }
	    
	}
}
