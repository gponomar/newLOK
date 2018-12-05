package test;
// Kiley - Junit Test
// test that drawnButton returns correct 
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import logic.DrawnButtonFactory;
import logic.Home;
import logic.PlayButton;


public class TestDrawnButtonFactory {
	@Test
	public void testFactory() {
		DrawnButtonFactory test = new DrawnButtonFactory();
		assertTrue(test.getButton("Play") instanceof PlayButton);
	}
}
