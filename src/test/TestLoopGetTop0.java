package test;
//Gracie- Loop test 0
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import logic.HighScore;

public class TestLoopGetTop0 {

	@Test
	public void testTopScores() throws FileNotFoundException {
		HighScore test = new HighScore();
		List<List<String>> answer = test.getTopScores("resource/testTopScores0");
		ArrayList<ArrayList<String>> expected = new ArrayList<>();
		assertTrue(answer.equals(expected));
		

	}
}
