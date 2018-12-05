package test;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import logic.HighScore;
import logic.Home;

public class TestHighScoreBackBtn {
	@Test
	public void testBackBtn() throws InterruptedException {
		Home testhome = new Home();
		testhome.getScoreBtn().doClick();
		HighScore test = new HighScore();
		test.getBackBtn().doClick();
		TimeUnit.MILLISECONDS.sleep(50);
		String newClass = String.valueOf(testhome.frm.getContentPane().getClass());
		assertEquals("class logic.Home", newClass.substring(0, newClass.indexOf('$')));
	}
}
