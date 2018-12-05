package test;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import logic.Game;

public class TestGameLoop {
	//unit
	@Test
	public void testGameCreateSentencesLoop() throws InterruptedException {
		Game game = new Game();
		Map<Integer, ArrayList<String>> sents = game.createSentences();
		assertTrue(sents instanceof HashMap<?, ?> && sents.size() >0);
	}
	@Test
	public void testGetCorrectLengthSentencesLoop() throws InterruptedException {
		Game game = new Game();
		game.setLengthMap(game.createSentences());
		ArrayList<String> sents = game.getCorrectLengthSentences();
		assertTrue(!sents.isEmpty());
	}
}
