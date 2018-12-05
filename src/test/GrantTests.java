package test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestScoreAtStart.class, TestSentenceLength.class,
				TestIntegrationCredits.class, TestIntegrationGameSize.class})
	public class GrantTests {
	
 }