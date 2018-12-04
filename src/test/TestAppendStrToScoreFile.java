package test;

import static org.junit.Assert.assertTrue;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;
import logic.YourScore;

public class TestAppendStrToScoreFile {
	@Test
	public void testAppend() {
		boolean answer = false;
		YourScore test = new YourScore();
		try {
		test.appendStrToScoreFile(10000, "Gracie", "Hard");
		try
		{
			Scanner scanner = new Scanner(new File("resource/HighScoreList"));
			while (scanner.hasNextLine())
			{
				String line = scanner.nextLine();
				if (line.compareTo("10000 Gracie") == 0)
				{
					answer = true;
					break;
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.err.println("File not found");
		}
		assertTrue(answer);
		
	} catch (IOException e) {
		System.err.println("exception occoured" + e);
		}
}
}
