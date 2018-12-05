// JUnit Test 1: Ryan Nevils

package test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import logic.Credits;

public class TestBaseLabel {

	@Test
	public void testScorePageButton() throws InterruptedException {
		Credits test = new Credits();
		String verify = test.getGrantLabel();
		boolean isEqual = (verify.equals("Grant Parton"));
		assertEquals(false, !isEqual);
	}
}