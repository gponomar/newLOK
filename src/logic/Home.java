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
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Home {
	public JFrame frm = new JFrame();		
	public JPanel pnl = new JPanel()
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

                e.printStackTrace();
            }
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }
    };
    
    public ImageIcon playIcon = new ImageIcon ("resource/playButton.png");
    public ImageIcon creditsIcon = new ImageIcon ("resource/CreditsButton.png");
    public ImageIcon settingsIcon = new ImageIcon ("resource/SettingsButton.png");
    public ImageIcon scoreIcon = new ImageIcon ("resource/HighScore.png");
    public JButton playBtn = new JButton(playIcon);
	public JButton creditsBtn = new JButton(creditsIcon);
	public JButton settingBtn = new JButton(settingsIcon);
	public JButton scoreBtn = new JButton(scoreIcon);
	
	public Boolean restart = false;
  
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
        
    	JLabel titleLabel = new JLabel();
        titleLabel.setPreferredSize(new Dimension(600,300));
        BufferedImage titleImg = null;
        try {
            titleImg = ImageIO.read(new File("resource/TheLordOfTheKeysTitle3.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        Image timg = titleImg.getScaledInstance(600, 125, Image.SCALE_SMOOTH);
        ImageIcon titleIcon = new ImageIcon(timg);
        titleLabel.setIcon(titleIcon);
        titlePanel.add(titleLabel);
        
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
        gamePage.setHomepage(this);// = this;
        playBtn.addActionListener(action -> playBtnAction(gamePage));
        
        //settings page
        Settings settingsPage = new Settings();
        settingsPage.homepage = this;
        settingBtn.addActionListener(action -> settingsBtnAction(settingsPage));
        
        //credits page
        Credits creditsPage = new Credits();
        creditsPage.homepage = this;
        creditsBtn.addActionListener(action -> creditsBtnAction(creditsPage));
        
        //score page
        HighScore scorePage = new HighScore();
        scorePage.homepage = this;
        scoreBtn.addActionListener(action -> scoreBtnAction(scorePage));
        
    }
    
	// action to be performed when back button is hit
	private void playBtnAction(Game gamePage) {
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
		//new Home();
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
            	new Home();
            }
        });
    }

}
