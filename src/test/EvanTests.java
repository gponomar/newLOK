
package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestJunitCounter.class, TestSettingsBtn.class,
	TestHardDifficultySet.class, TestSettingBackBtn.class })
public class EvanTests {

}