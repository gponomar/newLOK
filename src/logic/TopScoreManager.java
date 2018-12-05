package logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class TopScoreManager {
	private static TopScoreManager myInstance;
	private static final Logger LOGGER = Logger.getLogger(TopScoreManager.class.getName());
	List<List<String>> answer = new ArrayList<>();
	private TopScoreManager() {
		
	}
	public static TopScoreManager getInstance() {
		if(myInstance==null) {
			myInstance = new TopScoreManager();
		}
		return myInstance;
	}
	public void refreshScores(String fileName) {
		answer = new ArrayList<>();
		List<String> inner = new ArrayList<>();
		try
		{
			Scanner scanner = new Scanner(new File(fileName));
			while (scanner.hasNext())
			{
				String line = scanner.next();
				inner.add(line);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			LOGGER.severe("File not found");
		}
		ArrayList<String> temp;
		for(int i = 0; i< inner.size()-1; i+=2)
		{
			temp = new ArrayList<>();
			temp.add(inner.get(i));
			temp.add(inner.get(i+1));
			answer.add(temp);
		}
		
		Collections.sort(answer, (a, b) -> {
			if (Integer.parseInt(a.get(0)) > Integer.parseInt((b.get(0))))
			{
				return -1;
			}
			else if (Integer.parseInt(a.get(0)) < Integer.parseInt((b.get(0))))
			{
				return 1;
			}
			else return 0;
		});	
	}
	public List<List<String>> getTopScores() {
		return answer;
	}
}
