package test;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import logic.Home;

public class TestScorePageBtn {

	@Test
	public void testScorePageButton() throws InterruptedException {
		Home test = new Home();
		test.getScoreBtn().doClick();
		TimeUnit.MILLISECONDS.sleep(50);
		String newClass = String.valueOf(test.frm.getContentPane().getClass());
		assertEquals("class logic.HighScore", newClass.substring(0, newClass.indexOf('$')));
	}
}
