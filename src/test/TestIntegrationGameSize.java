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