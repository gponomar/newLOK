package test;

import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import logic.HighScore;

public class TestLoopAddToAns2 {
//[10, MyScore, 20, YourScore]
	//[[10, MyScore], [20, YourScore]]
	@Test
	public void testTopScores() throws FileNotFoundException {
		HighScore test = new HighScore();
		ArrayList<String> inner = new ArrayList<>();
		ArrayList<ArrayList<String>> expected = new ArrayList<>();
		inner.add("10");
		inner.add("MyScore");
		inner.add("20");
		inner.add("YourScore");
		expected.add(addScore("10", "MyScore"));
		expected.add(addScore("20", "YourScore"));
		
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
