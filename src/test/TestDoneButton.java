// Kiley Roberson - JUnit test 2
// Test that clicking the done button writes score to file
package test;

import static org.junit.Assert.assertTrue;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import org.junit.Test;
import logic.YourScore;
import logic.HighScore;

public class TestDoneButton {
	private static final Logger LOGGER = Logger.getLogger(TestAppendStrToScoreFile.class.getName());
	@Test
	public void testDone() throws InterruptedException {

		YourScore test = new YourScore();
		test.setScorepage(new HighScore());
		test.setScore(3);
		test.getGetName().setText("Kiley");
		test.setDiff("Easy");
		test.getDone().doClick();
		TimeUnit.MILLISECONDS.sleep(50);
		Boolean answer = false;
		try {
			Scanner scanner = new Scanner(new File("resource/HighScoreList"));
			while (scanner.hasNextLine())
			{
				String line = scanner.nextLine();
				if (line.compareTo("3 Kiley-Easy") == 0)
				{
					answer = true;
					break;
				}
			}
			scanner.close();
			
		assertTrue(answer);
		
		}catch (FileNotFoundException e) {
			LOGGER.severe("File not found");
		}
	}
}