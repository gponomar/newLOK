package test;
//Evan - Unit test
// Test that settings button creates correct class
import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import logic.Home;

public class TestSettingsBtn {

	@Test
	public void testSettingBtn() throws InterruptedException {
		Home test = new Home();
		test.getSettingsBtn().doClick();
		TimeUnit.MILLISECONDS.sleep(50);
		String newClass = String.valueOf(test.frm.getContentPane().getClass());
		assertEquals("class logic.Settings", newClass.substring(0, newClass.indexOf('$')));
	}
}
