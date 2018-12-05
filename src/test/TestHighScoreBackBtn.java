package test;
//Gracie - Integration tests that score button takes you to the right page
// and that back button takes you back home
import static org.junit.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import logic.Home;

public class TestHighScoreBackBtn {
	@Test
	public void testBackBtn() throws InterruptedException {
		Home testhome = new Home();
		testhome.getScoreBtn().doClick();
		TimeUnit.MILLISECONDS.sleep(50);
		String firstClass = String.valueOf(testhome.frm.getContentPane().getClass());
		assertEquals("class logic.HighScore", firstClass.substring(0, firstClass.indexOf('$')));
		testhome.scorePage.getBackBtn().doClick();
		TimeUnit.MILLISECONDS.sleep(50);
		String newClass = String.valueOf(testhome.frm.getContentPane().getClass());
		assertEquals("class logic.Home", newClass.substring(0, newClass.indexOf('$')));
	}
}
