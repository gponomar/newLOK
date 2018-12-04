package test;

import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.Test;

import logic.HighScore;

public class testGetTopScores {

	@Test
	public void testTopScores() throws FileNotFoundException {
		HighScore test = new HighScore();
		ArrayList<ArrayList<String>> answer = new ArrayList<ArrayList<String>>();
		answer = test.getTopScores("resource/testTopScores");
		ArrayList<ArrayList<String>> expected = new ArrayList<>();
		ArrayList<String> added = new ArrayList<>();
		added.add("25");
		added.add("Kiley");
		expected.add(added);
		added = new ArrayList<>();
		added.add("22");
		added.add("Grant");
		expected.add(added);
		added = new ArrayList<>();
		added.add("20");
		added.add("Evan");
		expected.add(added);
		added = new ArrayList<>();
		added.add("15");
		added.add("Ryan");
		expected.add(added);
		added = new ArrayList<>();
		added.add("13");
		added.add("Gracie");
		expected.add(added);
		added = new ArrayList<>();
		added.add("12");
		added.add("Ishan");
		expected.add(added);
		added = new ArrayList<>();
		added.add("0");
		added.add("-");
		expected.add(added);
		expected.add(added);
		expected.add(added);
		expected.add(added);
		expected.add(added);
		System.out.println(expected);
		System.out.println(answer);
		assertTrue(answer.equals(expected));
		

	}
}
