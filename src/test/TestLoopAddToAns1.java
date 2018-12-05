package test;

import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import logic.HighScore;

public class TestLoopAddToAns1 {
	@Test
	public void testTopScores() throws FileNotFoundException {
		HighScore test = new HighScore();
		ArrayList<String> inner = new ArrayList<>();
		ArrayList<ArrayList<String>> expected = new ArrayList<>();
		inner.add("10");
		inner.add("MyScore");
		expected.add(addScore("10", "MyScore"));
		
		List<List<String>> answer = test.addToAnswer(inner);
		assertTrue(answer.equals(expected));
		}
	private ArrayList<String> addScore(String score, String name){
		ArrayList<String>added = new ArrayList<>();
		added.add(score);
		added.add(name);
		return added;
	}
}
