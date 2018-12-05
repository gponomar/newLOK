package test;
// Kiley - Junit Test
// test that drawnButton returns correct 

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import logic.DrawnButtonFactory;
import logic.PlayButton;


public class TestDrawnButtonFactory {
	@Test
	public void testFactory() {
		DrawnButtonFactory test = new DrawnButtonFactory();
		assertTrue(test.getButton("Play") instanceof PlayButton);
	}
}
