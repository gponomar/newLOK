import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.BreakIterator;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
	public JPanel pnl = new JPanel()
    {
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
    	JPanel titlePanel = new JPanel();
    	titlePanel.setOpaque(false);
    	JPanel btnPanel = new JPanel(new GridBagLayout());
    	JPanel bigPanel = new JPanel(new GridBagLayout());
    	pnl.setPreferredSize(new Dimension(640, 480));
    	    
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
    	scoreImage.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
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
        frm.pack();
        frm.setVisible(true);

        //executes game
        Game gamePage = new Game();
        gamePage.homepage = this;
        playBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	frm.remove(pnl);
            	frm.setContentPane(gamePage.pnlHolderGame);
            	gamePage.labelGame.requestFocus();
            	frm.validate();
            	frm.repaint();

            }
        });
        
        Settings settingsPage = new Settings();
        settingsPage.homepage = this;
        settingBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	frm.remove(pnl);
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
            	
            	frm.remove(pnl);
            	frm.setContentPane(creditsPage.pnlHolderCredits);
            	frm.validate();
            	frm.repaint();
            }
        });
        
        HighScore scorePage = new HighScore();
        scorePage.homepage = this;
        scoreBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	frm.remove(pnl);
            	frm.setContentPane(scorePage.pnlHolderHighScore);
            	frm.validate();
            	frm.repaint();
            }
        });
        
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
