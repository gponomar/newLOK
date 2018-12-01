package logic;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Random;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;


public class Game {
	private DrawnButtonFactory btnFactory = new DrawnButtonFactory();
	private static final Logger LOGGER = Logger.getLogger(Game.class.getName());
	private Home homepage;
	public int score = 0;
	public void setHomepage(Home val) {
		homepage = val;
	}
	private JPanel pnlGame = new JPanel();
	public static final JPanel pnlHolderGame = new JPanel(new GridLayout(3,1))
    {
		@Override
        public void paintComponent(java.awt.Graphics g)
        {
            super.paintComponent(g);
            BufferedImage image = null;
            try
            {
                image = ImageIO.read(new File("resource/fullScene1.png"));
            }
            catch (IOException e)
            {
            	LOGGER.severe("File not found");
            }
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }
    };

	private JButton homeBtn;
	private HashMap<Integer, ArrayList<String>> lengthMap;
	private int sentLength=20;
	private int diff = 5;
	private String result;
	private int progress = 0;
	private JPanel content = new JPanel();
	private String difficulty;
	public void setDiff(String val) {
		difficulty = val;
	}
	public String getDiff() {
		return difficulty;
	}
	public static final JLabel labelGame = new JLabel();
	private Random rand = new Random();
	
	public Game() {
		
		//Formatting
		content.setOpaque(false);
		DrawnButton dbBack = btnFactory.getButton("BACK");
		homeBtn = dbBack.draw();
        pnlGame.add(homeBtn, BorderLayout.WEST);
        pnlGame.setOpaque(false);
        pnlHolderGame.add(pnlGame);
        pnlHolderGame.add(labelGame);
        
        labelGame.requestFocus();
        labelGame.addKeyListener(new SimpleKeyListener());
        
        //Create sentences
        BreakIterator iterator = BreakIterator.getSentenceInstance(Locale.US);
        String source;
        try {
        	source = new String(Files.readAllBytes(Paths.get("resource/for.txt")), StandardCharsets.UTF_8);
        	source=source.replace("\n", "").replace("\r", "").replaceAll("#", "");

			iterator.setText(source);
		} catch (IOException e1) {
			LOGGER.severe("File not found");
			return;
		}
        int start = iterator.first();
        lengthMap = new HashMap<>();
        String sent;
        for (int end = iterator.next();
            end != BreakIterator.DONE;
            start = end, end = iterator.next()) {
        	sent = source.substring(start,end).trim();
        	if(lengthMap.containsKey(sent.length())) {
        		ArrayList<String> temp = new ArrayList<>(lengthMap.get(sent.length()));
        		temp.add(sent);
        		lengthMap.put(sent.length(), temp);
        	} else {
        		ArrayList<String> temp = new ArrayList<>();
        		temp.add(sent);
        		lengthMap.put(sent.length(), temp);
        	}
        }
        
        // Start the game
        ArrayList<String> finalResultsList = new ArrayList<>(getCorrectLengthSentences());       
    	startRound(finalResultsList);

    	// Exit to main menu
        homeBtn.addActionListener(action -> homeBtnAction());
        
    }
	
	// action to be performed when back button is hit
	private void homeBtnAction() {
    	homepage.frm.remove(pnlHolderGame);
    	homepage.frm.setContentPane(homepage.pnl);
    	homepage.frm.validate();
    	homepage.frm.repaint();
	}
	
	// Sentence logic 
	
    //picking out sentences from the book
    private ArrayList<String> getCorrectLengthSentences() {
    	ArrayList<String> resultsList = new ArrayList<>();
        for(int i=sentLength-diff; i<sentLength+diff; i++) {
        	if(lengthMap.containsKey(i)) {
        		for(String s : lengthMap.get(i)) {
        			resultsList.add(s);
        		}
        	}
        }
        return resultsList;
    }
    private void startRound(ArrayList<String> finalResultsList) {
        progress=0;
        if(!finalResultsList.isEmpty()) {
        	if(finalResultsList.size()==1) {
        		result=finalResultsList.get(0);
        	} else {
        		result=finalResultsList.get(rand.nextInt(finalResultsList.size()) + 0);
        	}
        }
        setContent(result, 0);
    }
    
    //read in what is typed by user
    public class SimpleKeyListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
            if(e.getKeyChar()==result.charAt(progress)) {
            	progress++;
            	setContent(result, progress);
            }
            if(progress==result.length()) {
            	sentLength++;
            	score++;
                startRound(getCorrectLengthSentences());
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {
        	// no changes needed 
        }

        @Override
        public void keyReleased(KeyEvent e) {
        	// no changes needed 
        }
    }
    
    //sets all the keys 
    public void setContent(String finalResult, int prog) {
    	content.removeAll();
    	JLabel l = new JLabel(String.valueOf(sentLength)+" characters ");
    	content.add(l);
    	for(int i=0; i<prog; i++) {
    		content.add(makeKey(finalResult.charAt(i), true));
    	}
    	for(int i=prog; i<finalResult.length(); i++) {
    		content.add(makeKey(finalResult.charAt(i), false));
    	}
        pnlHolderGame.add(content);
        pnlHolderGame.validate();
        pnlHolderGame.repaint();
    }
    
    public boolean approxEquals(double a, double b, double diff) {
    	return (Math.abs(a-b)<=diff);
    }
    
    private JPanel makeKey(char c, boolean entered) {
    	JPanel holder = new JPanel();
    	holder.setOpaque(false);
    	JPanel key = new JPanel();
        key.setPreferredSize(new Dimension(50, 50));
        if(!entered) {
        	key.setBackground(Color.WHITE);
        } else {
        	key.setBackground(Color.GRAY);
        }
        key.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        JLabel label = new JLabel(String.valueOf(c));
        label.setFont(new Font("", Font.PLAIN, 24));
        key.add(label);
        holder.add(key);
        return holder;
    }
    public int getScore() {
    	return this.score;
    }
}
