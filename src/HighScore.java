import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HighScore {
	public JPanel pnlTitle = new JPanel();
	public JPanel pnlHighScores = new JPanel(new GridBagLayout());
	public JPanel backpnl = new JPanel();
	public Home homepage;
	public ImageIcon back = new ImageIcon ("resource/BackButton.png");
	public JButton homeBtn = new JButton(back);
	ImageIcon highScoreIcon = new ImageIcon("resource/HighScore.png");
	JLabel labelHighScore = new JLabel(highScoreIcon);
	JLabel score1 = new JLabel("1.	" + "Score1");
	JLabel score2 = new JLabel("2.	" + "Score2");
	JLabel score3 = new JLabel("3.	" + "Score3");
	JLabel score4 = new JLabel("4.	" + "Score4");
	JLabel score5 = new JLabel("5.	" + "Score5");
	JLabel blank = new JLabel("");
	public JPanel pnlHolderHighScore = new JPanel(new GridBagLayout())
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
    	GridBagConstraints gbcNames = new GridBagConstraints();
    	gbcNames.fill = GridBagConstraints.HORIZONTAL;
    	GridBagConstraints bigGBC = new GridBagConstraints();
    	bigGBC.fill = GridBagConstraints.HORIZONTAL;
    	bigGBC.anchor = GridBagConstraints.NORTH;
		
    	Image highScoreImage = highScoreIcon.getImage();
    	highScoreImage = highScoreImage.getScaledInstance(500, 200, Image.SCALE_SMOOTH);
    	highScoreIcon = new ImageIcon(highScoreImage);
    	labelHighScore.setIcon(highScoreIcon);
    	pnlTitle.add(labelHighScore);
    	
    	bigGBC.gridx = 0;
    	bigGBC.gridy = 0;
    	pnlTitle.setOpaque(false);
    	pnlHolderHighScore.add(pnlTitle, bigGBC);
    	
    	bigGBC.insets = new Insets(60, 2, 2, 30);
    	pnlHighScores.setOpaque(false);
		score1.setFont(new Font(score1.getName(), Font.PLAIN, 50));
    	gbcNames.gridx = 0;
    	gbcNames.gridy = 0;
        pnlHighScores.add(score1, gbcNames);
		score2.setFont(new Font(score1.getName(), Font.PLAIN, 50));
    	gbcNames.gridx = 0;
    	gbcNames.gridy = 1;
        pnlHighScores.add(score2, gbcNames);
		score3.setFont(new Font(score1.getName(), Font.PLAIN, 50));
    	gbcNames.gridx = 0;
    	gbcNames.gridy = 2;
        pnlHighScores.add(score3, gbcNames);
		score4.setFont(new Font(score1.getName(), Font.PLAIN, 50));
    	gbcNames.gridx = 0;
    	gbcNames.gridy = 3;
        pnlHighScores.add(score4, gbcNames);
		score5.setFont(new Font(score1.getName(), Font.PLAIN, 50));
    	gbcNames.gridx = 0;
    	gbcNames.gridy = 4;
        pnlHighScores.add(score5, gbcNames);
        blank.setFont(new Font(score1.getName(), Font.PLAIN, 50));

        
		/*labelName6.setFont(new Font(score1.getName(), Font.PLAIN, 50));
    	gbcNames.gridx = 0;
    	gbcNames.gridy = 5;
        pnlHighScores.add(labelName6, gbcNames);
    	bigGBC.gridx = 0;
    	bigGBC.gridy = 1;
    	labelName7.setPreferredSize(new Dimension(10, 50));
        pnlHighScores.add(labelName7, gbcNames);*/
    	bigGBC.gridx = 0;
    	bigGBC.gridy = 1;
        pnlHolderHighScore.add(pnlHighScores, bigGBC);
        
        homeBtn.setPreferredSize(new Dimension(100, 80));
    	Image backImage = back.getImage();
    	backImage.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
    	back = new ImageIcon(backImage);
    	backpnl.add(homeBtn, BorderLayout.CENTER);
    	
    	bigGBC.gridx = 0;
    	bigGBC.gridy = 2;
    	backpnl.setOpaque(false);
        pnlHolderHighScore.add(backpnl, bigGBC);
		
		
		/*GridBagConstraints gbcBack = new GridBagConstraints();
		gbcBack.anchor = GridBagConstraints.WEST;
		GridBagConstraints gbcTitle = new GridBagConstraints();
		gbcTitle.gridx = 1;
		gbcTitle.gridy = 0;
		Image HighScoreImage = HighScoreIcon.getImage();
    	HighScoreImage = HighScoreImage.getScaledInstance(500, 200, Image.SCALE_SMOOTH);
    	HighScoreIcon = new ImageIcon(HighScoreImage);
    	labelHighScore.setIcon(HighScoreIcon);
        pnlTitle.add(labelHighScore, gbcTitle);
    	//pnlHighScores.add(labelHighScore, gbcTitle);
        gbcTitle.anchor = GridBagConstraints.CENTER;
        gbcTitle.gridx = 1;
		gbcTitle.gridy = 2;
		score1.setFont(new Font(score1.getName(), Font.PLAIN, 60));
        pnlHighScores.add(score1, gbcTitle);
        gbcTitle.gridx = 1;
		gbcTitle.gridy = 3;
		score2.setFont(new Font(score1.getName(), Font.PLAIN, 60));
        pnlHighScores.add(score2, gbcTitle);
        gbcTitle.gridx = 1;
		gbcTitle.gridy = 4;
		score3.setFont(new Font(score1.getName(), Font.PLAIN, 60));
        pnlHighScores.add(score3, gbcTitle);
        gbcTitle.gridx = 1;
		gbcTitle.gridy = 5;
		score4.setFont(new Font(score1.getName(), Font.PLAIN, 60));
		pnlHighScores.add(score4, gbcTitle);
        gbcTitle.gridx = 1;
		gbcTitle.gridy = 6;
		score5.setFont(new Font(score1.getName(), Font.PLAIN, 60));
        pnlHighScores.add(score5, gbcTitle);
		gbcTitle.gridx = 1;
		gbcTitle.gridy = 9;
		backpnl.setPreferredSize(new Dimension(2000,300));
		backpnl.setOpaque(false);
		homeBtnHighScore.setBorderPainted(false); 
        backpnl.add(homeBtnHighScore, gbcBack);
        pnlHighScores.add(backpnl, gbcTitle);
        pnlHighScores.setOpaque(false);
        pnlTitle.setOpaque(false);
        pnlHolderHighScore.add(pnlTitle);
        pnlHolderHighScore.add(pnlHighScores);*/
        
        homeBtn.addActionListener(new ActionListener() {

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
