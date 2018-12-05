// Grant Parton - Junit Test 2
// Tests that every game starts at twenty sentences
package test;
import static org.junit.Assert.*;
import org.junit.Test;
import logic.Game;
 public class TestSentenceLength {
 	@Test
	public void testY() throws InterruptedException {
 		Game newGame = new Game();
		assertEquals(20, newGame.getSentLength());
	}
}