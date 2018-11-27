import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
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
	public JPanel backpnl = new JPanel(new GridBagLayout());
	public Home homepage;
	public ImageIcon back = new ImageIcon ("resource/BackButton.png");
	//public JPanel pnlHolderCredits = new JPanel();
	public JButton homeBtnCred = new JButton(back);
	ImageIcon creditsIcon = new ImageIcon("resource/Credits.png");
	JLabel labelCredits = new JLabel();
	JLabel labelName1 = new JLabel("Evan Jameson");
	JLabel labelName2 = new JLabel("Ryan Nevils");
	JLabel labelName3 = new JLabel("Ishan Pandey");
	JLabel labelName4 = new JLabel("Grant Parton");
	JLabel labelName5 = new JLabel("Grace Ponomaroff");
	JLabel labelName6 = new JLabel("Kiley Roberson");
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
		GridBagConstraints gbcBack = new GridBagConstraints();
		gbcBack.anchor = GridBagConstraints.WEST;
		GridBagConstraints gbcTitle = new GridBagConstraints();
		gbcTitle.gridx = 1;
		gbcTitle.gridy = 0;
		Image creditsImage = creditsIcon.getImage();
    	creditsImage = creditsImage.getScaledInstance(500, 200, Image.SCALE_SMOOTH);
    	creditsIcon = new ImageIcon(creditsImage);
    	labelCredits.setIcon(creditsIcon);
        pnlcredits.add(labelCredits, gbcTitle);
        gbcTitle.anchor = GridBagConstraints.CENTER;
        gbcTitle.gridx = 1;
		gbcTitle.gridy = 2;
		labelName1.setFont(new Font(labelName1.getName(), Font.PLAIN, 50));
        pnlcredits.add(labelName1, gbcTitle);
        gbcTitle.gridx = 1;
		gbcTitle.gridy = 3;
		labelName2.setFont(new Font(labelName1.getName(), Font.PLAIN, 50));
        pnlcredits.add(labelName2, gbcTitle);
        gbcTitle.gridx = 1;
		gbcTitle.gridy = 4;
		labelName3.setFont(new Font(labelName1.getName(), Font.PLAIN, 50));
        pnlcredits.add(labelName3, gbcTitle);
        gbcTitle.gridx = 1;
		gbcTitle.gridy = 5;
		labelName4.setFont(new Font(labelName1.getName(), Font.PLAIN, 50));
		pnlcredits.add(labelName4, gbcTitle);
        gbcTitle.gridx = 1;
		gbcTitle.gridy = 6;
		labelName5.setFont(new Font(labelName1.getName(), Font.PLAIN, 50));
        pnlcredits.add(labelName5, gbcTitle);
        gbcTitle.gridx = 1;
		gbcTitle.gridy = 7;
		labelName6.setFont(new Font(labelName1.getName(), Font.PLAIN, 50));
        pnlcredits.add(labelName6, gbcTitle);
        gbcTitle.gridx = 1;
		gbcTitle.gridy = 8;
		backpnl.setPreferredSize(new Dimension(2000,300));
		gbcTitle.gridx = 1;
		gbcTitle.gridy = 9;
		homeBtnCred.setBorderPainted(false); 
		backpnl.setOpaque(false);
        backpnl.add(homeBtnCred, gbcBack);
        pnlcredits.add(backpnl, gbcTitle);
        
        pnlcredits.setOpaque(false);
        //pnlHolderCredits.add(backpnl);
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
