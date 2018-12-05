// JUnit Test 2: Ryan Nevils

package test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import logic.CountDown;
import logic.Observer;

public class TestJunitCounter {

	@Test
	public void testScorePageButton() throws InterruptedException {
		CountDown test = new CountDown(new Observer<Long>() {

			@Override
			public void update(Long val) {
				// TODO Auto-generated method stub
				
			}
			
		}, "empty");
		
		long getLength = test.timeToRun("Easy");
		assertEquals(30000, getLength);
	}
}