//Ryan Nevils Test Suite
package test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestBaseLabel.class, TestJunitCounter.class, TestYourScoreTransition.class, 
	TestHighScoreGameComplete.class})
	public class RyansTests {
	
 }