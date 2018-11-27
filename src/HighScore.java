import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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

public class HighScore {
	public JPanel pnlHighScore = new JPanel(new GridBagLayout());
	public JPanel backpnl = new JPanel(new GridBagLayout());
	public Home homepage;
	public ImageIcon back = new ImageIcon ("resource/BackButton.png");
	public JButton homeBtnHighScore = new JButton(back);
	ImageIcon HighScoreIcon = new ImageIcon("resource/HighScore.png");
	JLabel labelHighScore = new JLabel(HighScoreIcon);
	JLabel score1 = new JLabel("1.	" + "Score1");
	JLabel score2 = new JLabel("2.	" + "Score2");
	JLabel score3 = new JLabel("3.	" + "Score3");
	JLabel score4 = new JLabel("4.	" + "Score4");
	JLabel score5 = new JLabel("5.	" + "Score5");
	public JPanel pnlHolderHighScore = new JPanel()
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
	public HighScore() {
		GridBagConstraints gbcBack = new GridBagConstraints();
		gbcBack.anchor = GridBagConstraints.WEST;
		GridBagConstraints gbcTitle = new GridBagConstraints();
		gbcTitle.gridx = 1;
		gbcTitle.gridy = 0;
		Image HighScoreImage = HighScoreIcon.getImage();
    	HighScoreImage = HighScoreImage.getScaledInstance(500, 200, Image.SCALE_SMOOTH);
    	HighScoreIcon = new ImageIcon(HighScoreImage);
    	labelHighScore.setIcon(HighScoreIcon);
        pnlHighScore.add(labelHighScore, gbcTitle);
        gbcTitle.anchor = GridBagConstraints.CENTER;
        gbcTitle.gridx = 1;
		gbcTitle.gridy = 2;
		score1.setFont(new Font(score1.getName(), Font.PLAIN, 58));
        pnlHighScore.add(score1, gbcTitle);
        gbcTitle.gridx = 1;
		gbcTitle.gridy = 3;
		score2.setFont(new Font(score1.getName(), Font.PLAIN, 58));
        pnlHighScore.add(score2, gbcTitle);
        gbcTitle.gridx = 1;
		gbcTitle.gridy = 4;
		score3.setFont(new Font(score1.getName(), Font.PLAIN, 58));
        pnlHighScore.add(score3, gbcTitle);
        gbcTitle.gridx = 1;
		gbcTitle.gridy = 5;
		score4.setFont(new Font(score1.getName(), Font.PLAIN, 58));
		pnlHighScore.add(score4, gbcTitle);
        gbcTitle.gridx = 1;
		gbcTitle.gridy = 6;
		score5.setFont(new Font(score1.getName(), Font.PLAIN, 58));
        pnlHighScore.add(score5, gbcTitle);
		gbcTitle.gridx = 1;
		gbcTitle.gridy = 9;
		backpnl.setPreferredSize(new Dimension(2000,300));
		backpnl.setOpaque(false);
		homeBtnHighScore.setBorderPainted(false); 
        backpnl.add(homeBtnHighScore, gbcBack);
        pnlHighScore.add(backpnl, gbcTitle);
        pnlHighScore.setOpaque(false);
        //pnlHolderCredits.add(backpnl);
        pnlHolderHighScore.add(pnlHighScore);
        
        homeBtnHighScore.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	homepage.frm.remove(pnlHolderHighScore);
            	homepage.frm.setContentPane(homepage.pnl);
            	homepage.frm.validate();
            	homepage.frm.repaint();
            }
        });
    }

}
