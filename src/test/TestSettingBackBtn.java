package test;
//Evan - Integration 
// Test that home button and then back button take you to the right pages
import static org.junit.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import logic.Home;

public class TestSettingBackBtn {
	@Test
	public void testBackBtn() throws InterruptedException {
		Home testhome = new Home();
		testhome.getSettingsBtn().doClick();
		TimeUnit.MILLISECONDS.sleep(50);
		testhome.settingsPage.getBackBtn().doClick();
		TimeUnit.MILLISECONDS.sleep(50);
		String newClass = String.valueOf(testhome.frm.getContentPane().getClass());
		assertEquals("class logic.Home", newClass.substring(0, newClass.indexOf('$')));
	}
}
