import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	public JPanel pnlTitle = new JPanel(new GridBagLayout());
	public JPanel pnlsettings = new JPanel(new GridBagLayout());
	public JPanel backpnl = new JPanel(new GridBagLayout());
	public Home homepage; 
	public ImageIcon back = new ImageIcon ("resource/BackButton.png");
	public JButton homeBtnSet = new JButton(back);
	public JSlider difficultySlider = new JSlider(1, 3, 3);
	public JPanel pnlHolderSettings = new JPanel()
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
	public Settings() {
		GridBagConstraints gbcBack = new GridBagConstraints();
		gbcBack.anchor = GridBagConstraints.WEST;
		GridBagConstraints gbcTitle = new GridBagConstraints();
		gbcTitle.gridx = 1;
		gbcTitle.gridy = 0;
		 homeBtnSet.setBorderPainted(false); 
		 JLabel labelSettings = new JLabel();
		 ImageIcon settingsIcon = new ImageIcon("resource/Settings.png");
		 Image settingsImage = settingsIcon.getImage();
	    	settingsImage = settingsImage.getScaledInstance(500, 200, Image.SCALE_SMOOTH);
	    	settingsIcon = new ImageIcon(settingsImage);
	     labelSettings.setIcon(settingsIcon);
	     pnlTitle.add(labelSettings, gbcTitle);
	     gbcTitle.gridx = 1;
		 gbcTitle.gridy = 1;
		 difficultySlider.setPreferredSize(new Dimension(400, 360));
		 pnlsettings.add(difficultySlider, gbcTitle);   
		 gbcTitle.gridx = 1;
		 gbcTitle.gridy = 2;
	     pnlsettings.add(homeBtnSet, gbcTitle);
	     pnlsettings.setOpaque(false);
	     difficultySlider.setSnapToTicks(true);
	     difficultySlider.setPaintTrack(true);
		 difficultySlider.setPaintTicks(true);
		 difficultySlider.setPaintLabels(true);
		 
		 Hashtable<Integer, JLabel> position = new Hashtable<Integer, JLabel>();
		 position.put(1,  new JLabel("easy"));
		 position.put(2,  new JLabel("medium"));
		 position.put(3,  new JLabel("hard"));
		 difficultySlider.setLabelTable(position);
		 difficultySlider.setOrientation(SwingConstants.VERTICAL);
	     //int difficulty = difficultySlider.getValue();
		 backpnl.setPreferredSize(new Dimension(2000,300));
		 gbcTitle.gridx = 1;
		 gbcTitle.gridy = 9;
	     backpnl.add(homeBtnSet, gbcBack);
	     backpnl.setOpaque(false);
	     pnlsettings.add(backpnl, gbcTitle);
	     pnlTitle.setOpaque(false);
		 pnlHolderSettings.add(pnlTitle);
		 pnlHolderSettings.add(pnlsettings);
	     
	     homeBtnSet.addActionListener(new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	homepage.frm.remove(pnlHolderSettings);
	            	homepage.frm.setContentPane(homepage.pnlHolder);
	            	homepage.frm.validate();
	            	homepage.frm.repaint();
	            }
	        });
	 }
}
