import java.awt.BorderLayout;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
//import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Credits {
	public JPanel pnlcredits = new JPanel(new GridBagLayout());
	
	public Home homepage;
	public ImageIcon back = new ImageIcon ("resource/BackButton.png");
	//public JPanel pnlHolderCredits = new JPanel();
	public JButton homeBtnCred = new JButton(back);
	JLabel labelCredits = new JLabel(new ImageIcon("resource/Credits.png"));
	public JPanel pnlHolderCredits = new JPanel()
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
	public Credits() {
		
		
		GridBagConstraints gbcTitle = new GridBagConstraints();
		gbcTitle.gridwidth = GridBagConstraints.REMAINDER;
		gbcTitle.anchor = GridBagConstraints.NORTH;

        pnlcredits.add(labelCredits, gbcTitle);
        gbcTitle.anchor = GridBagConstraints.SOUTHEAST;
        
        //pnlHolderCredits.add(pnlcredits);
        pnlcredits.add(homeBtnCred, gbcTitle);
        pnlcredits.setOpaque(false);
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
