//import java.awt.BorderLayout;
import java.awt.Dimension;
//import java.awt.FlowLayout;
//import java.awt.GridLayout;
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
//import javax.imageio.ImageIO;
public class Settings {
	public JPanel pnlsettings = new JPanel();
	public Home homepage; 
	public ImageIcon back = new ImageIcon ("resource/BackButton.png");
	public JButton homeBtnSet = new JButton(back);
	//public JPanel pnlHolderSettings = new JPanel();
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

		 homeBtnSet.setLocation(40, 80);
		 //homeBtnSet.setSize(new Dimension(64, 48));
		 homeBtnSet.setBorderPainted(false); 
		 difficultySlider.setLocation(100, 10);
		 JLabel labelSettings = new JLabel(new ImageIcon("resource/Settings.png"));
	     pnlsettings.add(labelSettings);
		 pnlsettings.add(difficultySlider);   
	     pnlsettings.add(homeBtnSet);
	     pnlsettings.setOpaque(false);
	     difficultySlider.setSnapToTicks(true);
	     difficultySlider.setPaintTrack(true);
		 difficultySlider.setPaintTicks(true);
		 difficultySlider.setPaintLabels(true);
		 
		 Hashtable position = new Hashtable();
		 position.put(1,  new JLabel("easy"));
		 position.put(2,  new JLabel("medium"));
		 position.put(3,  new JLabel("hard"));
		 difficultySlider.setLabelTable(position);
		 difficultySlider.setOrientation(SwingConstants.VERTICAL);
	     //int difficulty = difficultySlider.getValue();
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
