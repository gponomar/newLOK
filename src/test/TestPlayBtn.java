// Kiley Roberson - Junit Test 1
// Tests that the correct content class is set when
// the play button is clicked
package test;

import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import logic.Home; 

public class TestPlayBtn {

	@Test
	public void testPlayBtn() throws InterruptedException {
		Home test = new Home();
		test.getPlayBtn().doClick();
		TimeUnit.MILLISECONDS.sleep(50);
		String newClass = String.valueOf(test.frm.getContentPane().getClass());
		assertEquals("class logic.Game", newClass.substring(0, newClass.indexOf("$")));
	}
}
