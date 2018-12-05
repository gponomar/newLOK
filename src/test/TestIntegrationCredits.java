// Grant Parton Integration test 1
// Tests that going to and from the home button takes you back to the home page.
package test;
import static org.junit.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import logic.Credits;
import logic.Home;

public class TestIntegrationCredits {
	@Test
	public void testIntCredits() throws InterruptedException {
		Home testhome = new Home();
		testhome.getCreditsBtn().doClick();
		Credits testCredits = new Credits();
		testCredits.getBackBtn().doClick();
		TimeUnit.MILLISECONDS.sleep(50);
		String newClass = String.valueOf(testhome.frm.getContentPane().getClass());
		assertEquals("class logic.Home", newClass.substring(0, newClass.indexOf('$')));
	}
}