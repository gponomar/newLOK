import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Settings {
	public JPanel pnlsettings = new JPanel();
	public Home homepage; 
	public JButton homeBtnSet = new JButton("home");
	public JPanel pnlHolderSettings = new JPanel(new GridLayout(3,1));
	 public Settings() {
		 homeBtnSet.setLayout(null);
		 homeBtnSet.setLocation(800, 800);
		 JLabel labelSettings = new JLabel("settings page");
		 pnlsettings.setPreferredSize(new Dimension(640, 480));
	     pnlsettings.add(homeBtnSet, BorderLayout.SOUTH);
	     pnlHolderSettings.add(pnlsettings);
	     pnlHolderSettings.add(labelSettings);
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
