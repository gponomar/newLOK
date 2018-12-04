package test;

import static org.junit.Assert.assertTrue;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Logger;

import org.junit.Test;
import logic.YourScore;

public class TestAppendStrToScoreFile {
	private static final Logger LOGGER = Logger.getLogger(TestAppendStrToScoreFile.class.getName());
	@Test
	public void testAppend() {
		boolean answer = false;
		YourScore test = new YourScore();
		try {
			test.appendStrToScoreFile(10000, "Gracie");
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
			
		assertTrue(answer);
		
		}catch (FileNotFoundException e) {
			LOGGER.severe("File not found");
		}catch (IOException e) {
			LOGGER.severe("exception occoured" + e);
		}
	}
}
