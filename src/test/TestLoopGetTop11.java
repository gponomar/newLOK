package test;
//Gracie loop-11
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import logic.HighScore;

public class TestLoopGetTop11 {

	@Test
	public void testTopScores() throws FileNotFoundException {
		ArrayList<ArrayList<String>> expected = new ArrayList<>();
		HighScore test = new HighScore();
		List<List<String>> answer = test.getTopScores("resource/testTopScores11");
		
		expected.add(addScore("25", "Kiley"));
		expected.add(addScore("22", "Grant"));
		expected.add(addScore("20", "Evan"));
		expected.add(addScore("15", "Ryan"));
		expected.add(addScore("13", "Gracie"));
		expected.add(addScore("12", "Ishan"));
		expected.add(addScore("0", "-"));
		expected.add(addScore("0", "-"));
		expected.add(addScore("0", "-"));
		expected.add(addScore("0", "-"));
		expected.add(addScore("0", "-"));
		assertTrue(answer.equals(expected));	

	}
	private ArrayList<String> addScore(String score, String name){
		ArrayList<String>added = new ArrayList<>();
		added.add(score);
		added.add(name);
		return added;
	}
}
