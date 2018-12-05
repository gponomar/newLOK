package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({TestScorePageBtn.class, TestAppendStrToScoreFile.class , 
	TestGetTopScores.class , TestExHighScore.class , 
	TestSetHighScoreLabels.class , TestHighScoreBackBtn.class})
public class GracieTests {

}
