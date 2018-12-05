package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({TestScorePageBtn.class, TestAppendStrToScoreFile.class ,  
	 TestHighScoreBackBtn.class, TestMedDifficulty.class})
public class GracieTests {

}
