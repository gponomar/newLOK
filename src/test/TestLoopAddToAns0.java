package test;

import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import logic.HighScore;

public class TestLoopAddToAns0 {
	@Test
	public void testTopScores() throws FileNotFoundException {
		HighScore test = new HighScore();
		ArrayList<String> inner = new ArrayList<>();
		ArrayList<ArrayList<String>> expected = new ArrayList<>();
		List<List<String>> answer = test.addToAnswer(inner);
		assertTrue(answer.equals(expected));
		}
}
