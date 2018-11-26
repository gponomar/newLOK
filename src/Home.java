

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Image;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.BreakIterator;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.lang.Thread;

public class Home {
	public JFrame frm = new JFrame();
	public JPanel pnl = new JPanel();
	public JPanel pnlHolder = new JPanel(new GridLayout(3,1));
	public ImageIcon playIcon = new ImageIcon ("resource/playButton.png");
	public ImageIcon creditsIcon = new ImageIcon ("resource/CreditsButton.png");
	public ImageIcon settingsIcon = new ImageIcon ("resource/SettingsButton.png");
    public JButton Gamebtn = new JButton(playIcon);
    
	public JButton creditsBtn = new JButton(creditsIcon);
	public JButton settingBtn = new JButton(settingsIcon);
    public int sentLength=20, diff = 5;
	public JPanel content = new JPanel();
	public String result;
	public int progress = 0;
	public HashMap<Integer, ArrayList<String>> lengthMap;

  
    public Home() {
    	Image playImage = playIcon.getImage();
    	playImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
    	playIcon = new ImageIcon(playImage);
    	Gamebtn.setLayout(null);
    	Gamebtn.setLocation(200, 100);
    	Image creditsImage = creditsIcon.getImage();
    	creditsImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
    	creditsIcon = new ImageIcon(creditsImage);
        creditsBtn.setLayout(null);
        creditsBtn.setLocation(200, 300);
        Image settingsImage = settingsIcon.getImage();
        settingsImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        settingsIcon = new ImageIcon(settingsImage);
        settingBtn.setLayout(null);
        settingBtn.setLocation(200, 500);
        JLabel label = new JLabel("Lord of the Keys");
        pnl.setPreferredSize(new Dimension(640, 480));
        pnl.add(Gamebtn, BorderLayout.SOUTH);
        pnl.add(creditsBtn, BorderLayout.SOUTH);
        pnl.add(settingBtn, BorderLayout.SOUTH);
        pnlHolder.add(pnl, BorderLayout.SOUTH);
        pnlHolder.add(label);
        label.requestFocus();
        label.addKeyListener(new SimpleKeyListener());

        frm.add(pnlHolder);
        frm.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // EDIT
        frm.pack();
        frm.setVisible(true);
        BreakIterator iterator = BreakIterator.getSentenceInstance(Locale.US);
        String source;
        try {
        	source = new String(Files.readAllBytes(Paths.get("resource/for.txt")), StandardCharsets.UTF_8);
        	source=source.replace("\n", "").replace("\r", "").replaceAll("#", "");

			iterator.setText(source);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
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
        
        //executes start faceoff
        Gamebtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	label.requestFocus();
            	startRound(finalResultsList);
            }
        });
        Settings settingsPage = new Settings();
        settingsPage.homepage = this;
        settingBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	frm.remove(pnlHolder);
            	frm.setContentPane(settingsPage.pnlHolderSettings);
            	frm.validate();
            	frm.repaint();
            }
        });
        
        Credits creditsPage = new Credits();
        creditsPage.homepage = this;
        creditsBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	
            	frm.remove(pnlHolder);
            	frm.setContentPane(creditsPage.pnlHolderCredits);
            	frm.validate();
            	frm.repaint();
            }
        });
        
    }
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
        pnlHolder.add(content);
        pnlHolder.validate();
        pnlHolder.repaint();
    }
    
    public boolean approxEquals(double a, double b, double diff) {
    	if(Math.abs(a-b)<=diff) {
    		return true;
    	}
    	return false;
    }
    
    //
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
    
	public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
            	Home fS = new Home();

            }
        });
    }

}
