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