package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({TestScorePageBtn.class, TestAppendStrToScoreFile.class , 
	TestExHighScore.class , TestSetHighScoreLabels.class , TestHighScoreBackBtn.class,
	TestSettingBackBtn.class, TestSettingsBtn.class, 
	TestLoopGetTop0.class, TestLoopGetTop1.class, TestLoopGetTop2.class, TestLoopGetTop11.class})
public class GracieTests {

}
