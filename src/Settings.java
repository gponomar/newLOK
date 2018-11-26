//import java.awt.BorderLayout;
import java.awt.Dimension;
//import java.awt.FlowLayout;
//import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
//import javax.imageio.ImageIO;
public class Settings {
	//public JPanel pnlsettings = new JPanel();
	public Home homepage; 
	public ImageIcon back = new ImageIcon ("resource/BackButton.png");
	public JButton homeBtnSet = new JButton(back);
	public JPanel pnlHolderSettings = new JPanel();
	public JSlider difficultySlider = new JSlider(1, 3, 3);
	
	public Settings() {
        //pnlHolderSettings.add(new JLabel(new ImageIcon("resource/BackButton.png")));
		//pnlsettings.setLayout(null);
		//pnlHolderSettings.setLayout(new BorderLayout());
		 //homeBtnSet.setLayout(null);
		 homeBtnSet.setLocation(40, 80);
		 homeBtnSet.setSize(new Dimension(64, 48));
		 difficultySlider.setLocation(100, 10);
		 //difficultySlider.setExtent(10);
		 JLabel labelSettings = new JLabel(new ImageIcon("resource/Settings.png"));
		 //pnlsettings.setPreferredSize(new Dimension(6, 4));
	     //pnlsettings.add(homeBtnSet, BorderLayout.EAST);
	     pnlHolderSettings.add(labelSettings);
		 pnlHolderSettings.add(difficultySlider);   
	     pnlHolderSettings.add(homeBtnSet);
	     //pnlHolderSettings.add(pnlsettings, BorderLayout.SOUTH);
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
	     int difficulty = difficultySlider.getValue();
	     
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
