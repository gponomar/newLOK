package test;

import static org.junit.Assert.assertTrue;


import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import logic.Game;

public class TestGameLoop {
	//unit
	@Test
	public void testGameCreateSentencesLoopTyp() throws InterruptedException {
		Game game = new Game();
		Map<Integer, ArrayList<String>> sents = game.createSentences();
		assertTrue(sents instanceof HashMap<?, ?> && sents.size() >0);
	}
	//test loop 2 times
	@Test
	public void testGameCreateSentencesLoopTwo() throws InterruptedException {
		Game game = new Game();
		Map<Integer, ArrayList<String>> sents = game.createSentences("resource/forTest2.txt");
		System.out.println(sents.size());
		assertTrue(sents instanceof HashMap<?, ?> && sents.size() ==2);
	}
	//test loop 1 time
	@Test
	public void testGameCreateSentencesLoopOne() throws InterruptedException {
		Game game = new Game();
		Map<Integer, ArrayList<String>> sents = game.createSentences("resource/forTest1.txt");
		assertTrue(sents instanceof HashMap<?, ?> && sents.size() == 1);
	}
	//test loop 0 times
	@Test
	public void testGameCreateSentencesLoopZero() throws InterruptedException {
		Game game = new Game();
		Map<Integer, ArrayList<String>> sents = game.createSentences("resource/forTest0.txt");
		assertTrue(sents instanceof HashMap<?, ?> && sents.size() == 0);
	}
}
