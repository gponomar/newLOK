package logic;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Settings {
	public JPanel pnlTitle = new JPanel();
	public JPanel backpnl = new JPanel();
	public Home homepage; 
	public ImageIcon back = new ImageIcon ("resource/BackButton.png");
	public ImageIcon settingsIcon = new ImageIcon("resource/Settings.png");
	public JButton homeBtn = new JButton(back);
	JLabel labelSettings = new JLabel(settingsIcon);
	public JSlider difficultySlider = new JSlider(1, 3, 3);
	public JPanel pnlHolderSettings = new JPanel(new GridBagLayout())
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
	public Settings() {
		
    	GridBagConstraints gbcSettings = new GridBagConstraints();
    	gbcSettings.fill = GridBagConstraints.HORIZONTAL;
    	GridBagConstraints bigGBC = new GridBagConstraints();
    	bigGBC.fill = GridBagConstraints.HORIZONTAL;
    	bigGBC.anchor = GridBagConstraints.NORTH;
		
    	// add settings title
    	Image settingsImage = settingsIcon.getImage();
    	settingsImage = settingsImage.getScaledInstance(500, 200, Image.SCALE_SMOOTH);
    	settingsIcon = new ImageIcon(settingsImage);
    	labelSettings.setIcon(settingsIcon);
    	pnlTitle.add(labelSettings);
		
    	bigGBC.gridx = 0;
    	bigGBC.gridy = 0;
    	pnlTitle.setOpaque(false);
    	pnlHolderSettings.add(pnlTitle, bigGBC);
		
    	// add difficulty slider
		bigGBC.gridx = 0;
		bigGBC.gridy = 1;
    	bigGBC.insets = new Insets(70, 2, 2, 30);
		difficultySlider.setPreferredSize(new Dimension(400, 360));
	    difficultySlider.setSnapToTicks(true);
	    difficultySlider.setPaintTrack(true);
		difficultySlider.setPaintTicks(true);
		difficultySlider.setPaintLabels(true);
		Hashtable<Integer, JLabel> position = new Hashtable<Integer, JLabel>();
		JLabel easyLabel = new JLabel("Easy");
		easyLabel.setFont(new Font(easyLabel.getName(), Font.PLAIN, 25));
		position.put(1,  easyLabel);
		JLabel mediumLabel = new JLabel("Medium");
		mediumLabel.setFont(new Font(mediumLabel.getName(), Font.PLAIN, 25));
		position.put(2,  mediumLabel);
		JLabel hardLabel = new JLabel("Hard");
		hardLabel.setFont(new Font(hardLabel.getName(), Font.PLAIN, 25));
		position.put(3,  hardLabel);
		difficultySlider.setLabelTable(position);
		difficultySlider.setOrientation(SwingConstants.HORIZONTAL);
    	pnlHolderSettings.add(difficultySlider, bigGBC);
    	
    	// add back button
		homeBtn.setPreferredSize(new Dimension(100, 80));
    	Image backImage = back.getImage();
    	backImage.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
    	back = new ImageIcon(backImage);
    	backpnl.add(homeBtn, BorderLayout.CENTER);
    	bigGBC.gridx = 0;
    	bigGBC.gridy = 2;
    	bigGBC.insets = new Insets(280, 2, 2, 30);
    	backpnl.setOpaque(false);
        pnlHolderSettings.add(backpnl, bigGBC);
	     
	    homeBtn.addActionListener(action -> homeBtnAction());
	 }
	
	// action to be performed when back button is hit
	private void homeBtnAction() {
    	homepage.frm.remove(pnlHolderSettings);
    	homepage.frm.setContentPane(homepage.pnl);
    	homepage.frm.validate();
    	homepage.frm.repaint();
	}
}
