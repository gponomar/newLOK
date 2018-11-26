import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Credits {
	public JPanel pnlcredits = new JPanel();
	public Home homepage;
	public ImageIcon back = new ImageIcon ("resource/BackButton.png");
	public JPanel pnlHolderCredits = new JPanel(new GridLayout(3,1));
	public JButton homeBtnCred = new JButton(back);
	JLabel labelCredits = new JLabel(new ImageIcon("resource/Credits.png"));
	public Credits() {
    	
        homeBtnCred.setLayout(null);
        homeBtnCred.setLocation(800, 800);
        pnlcredits.setPreferredSize(new Dimension(640, 480));
        pnlcredits.add(homeBtnCred, BorderLayout.SOUTH);
        
        pnlHolderCredits.add(labelCredits);
        pnlHolderCredits.add(pnlcredits);
        homeBtnCred.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	homepage.frm.remove(pnlHolderCredits);
            	homepage.frm.setContentPane(homepage.pnlHolder);
            	homepage.frm.validate();
            	homepage.frm.repaint();
            }
        });
    }
}
