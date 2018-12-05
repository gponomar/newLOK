// Grant Parton - Junit Test 1
// Important to make sure score resets at every iteration of a new game!
package test;
import static org.junit.Assert.*;
import org.junit.Test;
import logic.Game;
 public class TestScoreAtStart {
 	@Test
	public void testX() throws InterruptedException {
 		Game newGame = new Game();
		assertEquals(0, newGame.getScore());
	}
}