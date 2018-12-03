package test;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Test;

import logic.HighScore;
import logic.Home;
import logic.YourScore;

public class TestAppendStrToScoreFile {
	@Test
	public void testAppend() {
		boolean answer = false;
		//Home test = new Home();
		YourScore test = new YourScore();
		test.appendStrToScoreFile(10000, "Gracie");
		try
		{
			Scanner scanner = new Scanner(new File("resource/HighScoreList"));
			while (scanner.hasNextLine())
			{
				String line = scanner.nextLine();
				System.out.println(line);
				if (line.compareTo("10000 Gracie") == 0)
				{
					answer = true;
					break;
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		assertTrue(answer);
		
	}
}
