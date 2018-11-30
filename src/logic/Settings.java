package logic;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Settings {
	private DrawnButtonFactory btnFactory = new DrawnButtonFactory();
	private static final Logger LOGGER = Logger.getLogger(Settings.class.getName());
	private JPanel pnlTitle = new JPanel();
	private JPanel backpnl = new JPanel();
	private Home homepage;
	public void setHomepage(Home val) {
		homepage = val;
	}
	private ImageIcon settingsIcon = new ImageIcon("resource/Settings.png");
	private JButton homeBtn;
	public JButton getHomeBtn() {
		return homeBtn;
	}
	private JLabel labelSettings = new JLabel(settingsIcon);
	private String[] diffs = { "Easy", "Medium", "Hard" };
	private JComboBox selectDiffs = new JComboBox(diffs);
	public JComboBox getSelectDiffs() {
		return selectDiffs;
	}
	public static final JPanel pnlHolderSettings = new JPanel(new GridBagLayout())
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
		
    	// add difficulty combo box
    	bigGBC.gridx = 0;
		bigGBC.gridy = 1;
	   	bigGBC.insets = new Insets(90, 2, 2, 30);
		pnlHolderSettings.add(selectDiffs, bigGBC);
    	
    	// add back button
		DrawnButton dbBack = btnFactory.getButton("BACK");
		homeBtn = dbBack.draw();
    	backpnl.add(homeBtn, BorderLayout.CENTER);
    	bigGBC.gridx = 0;
    	bigGBC.gridy = 2;
    	bigGBC.insets = new Insets(275, 2, 2, 30);
    	backpnl.setOpaque(false);
        pnlHolderSettings.add(backpnl, bigGBC);
	     
	    homeBtn.addActionListener(action -> homeBtnAction());
	 }
	
	// action to be performed when back button is hit
	private void homeBtnAction() {
		homepage.setDiff(String.valueOf(selectDiffs.getSelectedItem()));
    	homepage.frm.remove(pnlHolderSettings);
    	homepage.frm.setContentPane(homepage.pnl);
    	homepage.frm.validate();
    	homepage.frm.repaint();
	}
}
