package logic;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Home {
	private static final Logger LOGGER = Logger.getLogger(Home.class.getName());
	public static final JFrame frm = new JFrame();		
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
    private ImageIcon playIcon = new ImageIcon ("resource/playButton.png");
    private ImageIcon creditsIcon = new ImageIcon ("resource/CreditsButton.png");
    private ImageIcon settingsIcon = new ImageIcon ("resource/SettingsButton.png");
    private ImageIcon scoreIcon = new ImageIcon ("resource/HighScore.png");
    private JButton playBtn = new JButton(playIcon);
    private JButton creditsBtn = new JButton(creditsIcon);
    private JButton settingBtn = new JButton(settingsIcon);
    private JButton scoreBtn = new JButton(scoreIcon);
    private String diff = "Easy";
	public void setDiff(String val) {
		diff = val;
	}

  
    public Home() {
    	frm.pack();
    	JPanel titlePanel = new JPanel();
    	titlePanel.setOpaque(false);
    	JPanel btnPanel = new JPanel(new GridBagLayout());
    	JPanel bigPanel = new JPanel(new GridBagLayout());
    	pnl.setPreferredSize(new Dimension(720, 512));
    	    
        playBtn.setPreferredSize(new Dimension(100, 100));
    	Image playImage = playIcon.getImage();
    	playImage.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
    	playIcon = new ImageIcon(playImage);
        creditsBtn.setPreferredSize(new Dimension(100, 100));
    	Image creditsImage = playIcon.getImage();
    	creditsImage.getScaledInstance(400, 400, Image.SCALE_SMOOTH);
    	playIcon = new ImageIcon(playImage);
        settingBtn.setPreferredSize(new Dimension(100, 100));
    	Image settingsImage = playIcon.getImage();
    	settingsImage.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
    	playIcon = new ImageIcon(playImage);
        scoreBtn.setPreferredSize(new Dimension(100, 100));
    	Image scoreImage = playIcon.getImage();
    	scoreImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
    	playIcon = new ImageIcon(playImage);
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

        frm.add(pnl);
        frm.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frm.setVisible(true);

        //executes game
        Game gamePage = new Game();
        gamePage.setHomepage(this);
        playBtn.addActionListener(action -> playBtnAction(gamePage));
        
        //settings page
        Settings settingsPage = new Settings();
        settingsPage.setHomepage(this);
        settingBtn.addActionListener(action -> settingsBtnAction(settingsPage));
        
        //credits page
        Credits creditsPage = new Credits();
        creditsPage.setHomepage(this);
        creditsBtn.addActionListener(action -> creditsBtnAction(creditsPage));
        
        //score page
        HighScore scorePage = new HighScore();
        scorePage.setHomepage(this);
        scoreBtn.addActionListener(action -> scoreBtnAction(scorePage));
        
    }
    
	// action to be performed when back button is hit
	private void playBtnAction(Game gamePage) {
		gamePage.setDiff(diff);
    	frm.remove(pnl);
    	frm.setContentPane(gamePage.pnlHolderGame);
    	gamePage.labelGame.requestFocus();
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
    
    
	public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {new Home();});
    }

}
