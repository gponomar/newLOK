import java.awt.BorderLayout;

//import java.awt.GridBagLayout;
//import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Credits {
	public JPanel pnlcredits = new JPanel(new GridLayout());
	public JPanel blankPnl = new JPanel();
	public JPanel blankPnl1 = new JPanel();
	public JPanel blankPnl2 = new JPanel();
	public JPanel blankPnl3 = new JPanel();
	public JPanel blankPnl4 = new JPanel();
	public JPanel blankPnl5 = new JPanel();
	public JPanel blankPnl6 = new JPanel();
	public Home homepage;
	public ImageIcon back = new ImageIcon ("resource/BackButton.png");
	public JPanel pnlHolderCredits = new JPanel(new GridLayout(5,1, 30, 30));
	public JButton homeBtnCred = new JButton(back);
	JLabel labelCredits = new JLabel(new ImageIcon("resource/Credits.png"));
	public Credits() {
    	
        homeBtnCred.setLayout(null);
        homeBtnCred.setLocation(800, 800);
        //pnlcredits.setPreferredSize(new Dimension(640, 480));
        pnlcredits.add(blankPnl1);
        pnlcredits.add(blankPnl2);
        pnlcredits.add(blankPnl3);
        pnlcredits.add(blankPnl4);
        pnlcredits.add(homeBtnCred, BorderLayout.SOUTH);
        
        pnlHolderCredits.add(labelCredits);
        pnlHolderCredits.add(blankPnl);
        pnlHolderCredits.add(blankPnl5);
        pnlHolderCredits.add(blankPnl6);
        //pnlHolderCredits.add(homeBtnCred);
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
