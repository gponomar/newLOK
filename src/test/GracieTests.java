package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({TestScorePageBtn.class, TestAppendStrToScoreFile.class , 
	testGetTopScores.class , testHighScoreException.class , 
	testSetHighScoreLabels.class , testHighScoreBackBtn.class})
public class GracieTests {

}
