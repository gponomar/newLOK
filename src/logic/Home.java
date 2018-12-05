package logic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Home {
	private DrawnButtonFactory btnFactory = new DrawnButtonFactory();
	private static final Logger LOGGER = Logger.getLogger(Home.class.getName());
	public static final JFrame frm = new JFrame();		
	private Game curGamePage;
	public Game getGamePage() {
		return curGamePage;
	}
	public static final JPanel pnl = new JPanel()
    {
		@Override
        public void paintComponent(java.awt.Graphics g)
        {
            super.paintComponent(g);
            BufferedImage image = null;
            try
            {
                image = ImageIO.read(new File("resource/MountainBackgroundBig.png"));
            }
            catch (IOException e)
            {

            	LOGGER.severe("File not found");
            }
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }
    };
	private ImageIcon titleIcon = new ImageIcon("resource/TheLordOfTheKeysTitle3.png");
	private JLabel labelTitle = new JLabel(titleIcon);
	private JButton playBtn;

    public JButton getPlayBtn() {
    	return playBtn;
    }
	private JButton creditsBtn;
    public JButton getCreditsBtn() {
    	return creditsBtn;
    }
	private JButton settingBtn;
    public JButton getSettingsBtn() {
    	return settingBtn;
    }
    private JButton scoreBtn;
    public JButton getScoreBtn() {
    	return scoreBtn; 
    }
    private String diff = "Easy";
	public void setDiff(String val) {
		diff = val;
	}
	public static final Settings settingsPage = new Settings();
    public static final Credits creditsPage = new Credits();
    public static final HighScore scorePage = new HighScore();
	public static final YourScore yourscorePage = new YourScore();
	private Clip soundClip;
	private AudioInputStream audioIn;
	private CountDown clock;
	public CountDown getClock() {
		return clock;
	}
	
	public Clip getSoundClip() {
		return soundClip;
	}
	
	public AudioInputStream getAudioIn() {
		return audioIn;
	}
    
    public Home() {
    	frm.pack();
    	JPanel titlePanel = new JPanel();
    	titlePanel.setOpaque(false);
    	JPanel btnPanel = new JPanel(new GridBagLayout());
    	JPanel bigPanel = new JPanel(new GridBagLayout());
    	pnl.setPreferredSize(new Dimension(720, 512));
    	
    	DrawnButton dbPlay = btnFactory.getButton("PLAY");
    	DrawnButton dbCredits = btnFactory.getButton("CREDITS");
    	DrawnButton dbSettings = btnFactory.getButton("SETTINGS");
    	DrawnButton dbScore = btnFactory.getButton("SCORES");
    	
		try {
			File file = new File("resource/song1.wav");
			audioIn = AudioSystem.getAudioInputStream(file);
			soundClip = AudioSystem.getClip();
	    	soundClip.open(audioIn);
	    	soundClip.start();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}

    	playBtn = dbPlay.draw();
    	settingBtn = dbSettings.draw();
    	creditsBtn = dbCredits.draw();
    	scoreBtn = dbScore.draw();
    	
    	btnPanel.setOpaque(false);
        
       	Image titleImage = titleIcon.getImage();
    	titleImage = titleImage.getScaledInstance(600, 200, Image.SCALE_SMOOTH);
    	titleIcon = new ImageIcon(titleImage);
    	labelTitle.setIcon(titleIcon);
    	titlePanel.add(labelTitle);
        
    	GridBagConstraints gbc = new GridBagConstraints();
    	gbc.fill = GridBagConstraints.HORIZONTAL;
    	GridBagConstraints bigGBC = new GridBagConstraints();
    	bigGBC.fill = GridBagConstraints.HORIZONTAL;
    	bigGBC.anchor = GridBagConstraints.NORTH;
        
        bigGBC.gridx = 0;
        bigGBC.gridy = 0;
        bigPanel.add(titlePanel, bigGBC);
      
    	gbc.anchor = GridBagConstraints.NORTH;
    	gbc.insets = new Insets(30, 2, 2, 30);
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        btnPanel.add(playBtn, gbc);
       
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        btnPanel.add(creditsBtn, gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        btnPanel.add(settingBtn, gbc);
       
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        btnPanel.add(scoreBtn, gbc); 
        
        bigGBC.gridx = 0;
        bigGBC.gridy = 1;
        bigPanel.add(btnPanel, bigGBC);
        bigPanel.setOpaque(false);

        pnl.add(bigPanel, BorderLayout.NORTH);

    	frm.setContentPane(pnl);
        frm.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        frm.setVisible(true);

        //executes game
        playBtn.addActionListener(action -> playBtnAction());

        //settings page
        settingsPage.setHomepage(this);
        settingBtn.addActionListener(action -> settingsBtnAction(settingsPage));
        
        //credits page
        creditsPage.setHomepage(this);
        creditsBtn.addActionListener(action -> creditsBtnAction(creditsPage));
        
        //score page
        scorePage.setHomepage(this);
        scoreBtn.addActionListener(action -> scoreBtnAction(scorePage));
    }
    
    public void endGame() {
    	yourscorePage.setScore(curGamePage.getScore());
    	yourscorePage.setDiff(curGamePage.getDiff());
        yourscorePage.setHomepage(this);
        yourscorePage.setScorepage(scorePage);
        yourscorePage.setGamepage(curGamePage);
        openScorePageAction(yourscorePage);
    }
    
    public JPanel getPnl() {
    	return pnl;
    }
    
	// action to be performed when play button is hit
	private void playBtnAction() {
		Game gamePage = new Game();
		curGamePage = gamePage;
		gamePage.setHomepage(this);
		gamePage.setDiff(diff);
    	frm.remove(pnl);
    	frm.setContentPane(gamePage.pnlHolderGame);
    	gamePage.labelGame.requestFocus();
    	clock = new CountDown(new Observer<Long>() {

			@Override
			public void update(Long val) {
		        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("mm : ss");
				Game.clockLabel.setText(sdf.format(new Date(val)));
				Game.clockLabel.setForeground(Color.white);
				Game.clockLabel.setFont(new Font(Game.clockLabel.getName(), Font.PLAIN, 50));

				frm.validate();
				frm.repaint();
				if(val<0) {
					endGame();
				}
			}
    		
    	}, gamePage.getDiff());
    	frm.validate();
    	frm.repaint();
	}
	
	// action to be performed when back button is hit
	private void creditsBtnAction(Credits creditsPage) {
    	frm.remove(pnl);
    	frm.setContentPane(creditsPage.pnlHolderCredits);
    	frm.validate();
    	frm.repaint();
	}
	
	// action to be performed when back button is hit 
	private void scoreBtnAction(HighScore scorePage) {
    	frm.remove(pnl);
    	//whenever scorepage is called this needs to be done first
    	TopScoreManager.getInstance().refreshScores("resource/HighScoreList");
    	scorePage.setHighScoreLabels();
    	frm.setContentPane(scorePage.pnlHolderHighScore);
    	frm.validate();
    	frm.repaint();
	}
	
	// action to be performed when back button is hit
	private void settingsBtnAction(Settings settingsPage) {
    	frm.remove(pnl);
    	frm.setContentPane(settingsPage.pnlHolderSettings);
    	frm.validate();
    	frm.repaint();
	}
	//for testing of yourScore
	private void openScorePageAction(YourScore yourscorePage) {
    	frm.remove(pnl);
    	frm.setContentPane(yourscorePage.pnlHolderYourScore);
    	frm.validate();
    	frm.repaint();
	}
    
	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(Home::new);
    }

}
