// Kiley Roberson - Integration test 2
// Tests that done button actions is performed and that 
// strAppendFile which is called on done button, works
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
		Boolean answ = false;
		try {
			Scanner scan = new Scanner(new File("resource/HighScoreList"));
			while (scan.hasNextLine())
			{
				String line = scan.nextLine();
				if (line.compareTo("3 Kiley-Easy") == 0)
				{
					answ = true;
					break;
				}
			}
			scan.close();
			
		assertTrue(answ);
		
		}catch (FileNotFoundException e) {
			LOGGER.severe("File not found");
		}
	}
}