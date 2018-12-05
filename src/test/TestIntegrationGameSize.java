// Grant Parton Integration test 2
// Tests that the the back panel doesn't exists after one second, 
// because game page preparation for countdown observer
// sets it to null after initialization.
package test;
import static org.junit.Assert.assertEquals;
import java.util.concurrent.TimeUnit;

import javax.swing.JPanel;

import org.junit.Test;
import logic.Home;

public class TestIntegrationGameSize {
	@Test
	public void testIntGame() throws InterruptedException {
		Home testHome = new Home();
		TimeUnit.MILLISECONDS.sleep(1000);
		JPanel backPanelExists = testHome.getPnl();
		boolean doesExist = (backPanelExists == null);
		assertEquals(false, doesExist);
	}
}