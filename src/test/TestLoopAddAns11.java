package test;

import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import logic.HighScore;

public class TestLoopAddAns11 {
//["0", -, 13, Gracie, 0, -, 20, Evan, 12, Ishan, 0, -, 0, -, 25, Kiley, 15, Ryan, 22, Grant, 0, -]
//[[0, -], [13, Gracie], [0, -], [20, Evan], [12, Ishan], [0, -], [0, -], [25, Kiley], [15, Ryan], [22, Grant], [0, -]]


	@Test
	public void testTopScores() throws FileNotFoundException {
		HighScore test = new HighScore();
		ArrayList<String> inner = new ArrayList<>();
		String[] temp = {"0", "-", "13", "Gracie", "0", "-", "20", "Evan", "12", "Ishan", "0", "-",
				"0", "-", "25", "Kiley", "15", "Ryan", "22", "Grant", "0", "-"};
		inner.addAll(Arrays.asList(temp));
		ArrayList<ArrayList<String>> expected = new ArrayList<>();
		expected.add(addScore("0", "-"));
		expected.add(addScore("13", "Gracie"));
		expected.add(addScore("0", "-"));
		expected.add(addScore("20", "Evan"));
		expected.add(addScore("12", "Ishan"));
		expected.add(addScore("0", "-"));
		expected.add(addScore("0", "-"));
		expected.add(addScore("25", "Kiley"));
		expected.add(addScore("15", "Ryan"));
		expected.add(addScore("22", "Grant"));
		expected.add(addScore("0", "-"));
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
