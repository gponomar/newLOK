package test;
//Gracie- Loop test 2
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import logic.HighScore;

public class TestLoopGetTop2 {

	@Test
	public void testTopScores() throws FileNotFoundException {
		HighScore test = new HighScore();
		List<List<String>> answer = test.getTopScores("resource/testTopScores2");
		ArrayList<ArrayList<String>> expected = new ArrayList<>();

		expected.add(addScore("20", "YourScore"));
		expected.add(addScore("10", "MyScore"));
		assertTrue(answer.equals(expected));
		

	}
	private ArrayList<String> addScore(String score, String name){
		ArrayList<String>added = new ArrayList<>();
		added.add(score);
		added.add(name);
		return added;
	}
}