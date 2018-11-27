import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.border.EtchedBorder;


public class Game {
	public JPanel pnlGame = new JPanel()
    {
        public void paintComponent(java.awt.Graphics g)
        {
            super.paintComponent(g);
            BufferedImage image = null;
            try
            {
                image = ImageIO.read(new File("resource/bridgeScene.png"));
            }
            catch (IOException e)
            {

                e.printStackTrace();
            }
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }
    };
	public Home homepage;
	public JPanel pnlHolderGame = new JPanel(new GridLayout(3,1));
	public ImageIcon back = new ImageIcon ("resource/BackButton.png");
	public JButton homeBtnGame = new JButton(back);
	public HashMap<Integer, ArrayList<String>> lengthMap;
	public int sentLength=20, diff = 5;
	public String result;
	public int progress = 0;
	public JPanel content = new JPanel();
	public JLabel labelGame = new JLabel();
	
	public Game() {
	

        //homeBtnGame.setLayout(null);
        //homeBtnGame.setLocation(800, 800);
        pnlGame.setPreferredSize(new Dimension(640, 480));
        pnlGame.add(homeBtnGame, BorderLayout.SOUTH);
        pnlHolderGame.add(pnlGame);
        pnlHolderGame.add(labelGame);
        
        
        
        labelGame.requestFocus();
        labelGame.addKeyListener(new SimpleKeyListener());
        
        BreakIterator iterator = BreakIterator.getSentenceInstance(Locale.US);
        String source;
        try {
        	source = new String(Files.readAllBytes(Paths.get("resource/for.txt")), StandardCharsets.UTF_8);
        	source=source.replace("\n", "").replace("\r", "").replaceAll("#", "");

			iterator.setText(source);
		} catch (IOException e1) {
			e1.printStackTrace();
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
        
        
        ArrayList<String> finalResultsList = new ArrayList<String>(getCorrectLengthSentences());       
    	startRound(finalResultsList);

        homeBtnGame.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
         
            	homepage.frm.remove(pnlHolderGame);
            	homepage.frm.setContentPane(homepage.pnl);
            	homepage.frm.validate();
            	homepage.frm.repaint();
            }
        });
        
    }
	
	// sentence typing stuff
	
    //picking out sentences from the book
    private ArrayList<String> getCorrectLengthSentences() {
    	ArrayList<String> resultsList = new ArrayList<String>();
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
        if(finalResultsList.size()!=0) {
        	if(finalResultsList.size()==1) {
        		result=finalResultsList.get(0);
        	} else {
        		Random rand = new Random();
        		result=finalResultsList.get(rand.nextInt(finalResultsList.size()) + 0);
        	}
        }
        setContent(result, 0);
    }
    
    //read in what is typed by user
    public class SimpleKeyListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
        	System.out.println(String.valueOf(e.getKeyChar()));
            if(e.getKeyChar()==result.charAt(progress)) {
            	progress++;
            	setContent(result, progress);
            }
            if(progress==result.length()) {
            	sentLength++;
                startRound(getCorrectLengthSentences());
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
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
    	if(Math.abs(a-b)<=diff) {
    		return true;
    	}
    	return false;
    }
    
    private JPanel makeKey(char c, boolean entered) {
    	JPanel holder = new JPanel();
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
}