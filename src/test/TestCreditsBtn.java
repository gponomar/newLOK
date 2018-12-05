package test;
//Unit
import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import logic.Home;

public class TestCreditsBtn {

	@Test
	public void testCredBtn() throws InterruptedException {
		Home test = new Home();
		test.getCreditsBtn().doClick();
		TimeUnit.MILLISECONDS.sleep(50);
		String newClass = String.valueOf(test.frm.getContentPane().getClass());
		assertEquals("class logic.Credits", newClass.substring(0, newClass.indexOf('$')));
	}
}
