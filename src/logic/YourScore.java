package logic;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class YourScore {
	public JPanel pnlTitle = new JPanel();
	public JPanel pnlScore = new JPanel(new GridBagLayout());
	public JPanel backpnl = new JPanel();
	public Home homepage;
	public void setHomepage(Home val) {
		homepage = val;
	}
	public Game gamepage;
	public void setGamepage(Game val) {
		gamepage = val;
	}
	public HighScore scorepage;
	public void setScorepage(HighScore val) {
		scorepage = val;
	}
	public ImageIcon back = new ImageIcon ("resource/BackButton.png");
	public JButton homeBtn = new JButton(back);
	public static JTextArea getname = new JTextArea("Your_Name");
	public JButton done = new JButton("done");
	ImageIcon yourScoreIcon = new ImageIcon("resource/HighScore.png");
	JLabel labelYourScore = new JLabel(yourScoreIcon);
	JLabel yourScore = new JLabel();//(Integer.toString(gamepage.getScore()));
	JLabel score = new JLabel();
	JLabel blank = new JLabel("");
	public static final JPanel pnlHolderYourScore = new JPanel(new GridBagLayout())
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
	public YourScore() {
		//score.setText(Integer.toString(gamepage.score));
		
		getname.setFont(new Font(getname.getName(), Font.ITALIC, 50));
		GridBagConstraints gbcNames = new GridBagConstraints();
    	gbcNames.fill = GridBagConstraints.HORIZONTAL;
    	GridBagConstraints bigGBC = new GridBagConstraints();
    	bigGBC.fill = GridBagConstraints.HORIZONTAL;
    	bigGBC.anchor = GridBagConstraints.NORTH;
		
    	Image highScoreImage = yourScoreIcon.getImage();
    	highScoreImage = highScoreImage.getScaledInstance(500, 200, Image.SCALE_SMOOTH);
    	yourScoreIcon = new ImageIcon(highScoreImage);
    	labelYourScore.setIcon(yourScoreIcon);
    	pnlTitle.add(yourScore);
    	
    	bigGBC.gridx = 0;
    	bigGBC.gridy = 0;
    	pnlTitle.setOpaque(false);
    	pnlHolderYourScore.add(pnlTitle, bigGBC);

    	
    	bigGBC.insets = new Insets(60, 2, 2, 30);
    	pnlScore.setOpaque(false);
		yourScore.setFont(new Font(yourScore.getName(), Font.PLAIN, 50));
    	gbcNames.gridx = 0;
    	gbcNames.gridy = 0;
        pnlScore.add(yourScore, gbcNames);
    	bigGBC.gridx = 0;
    	bigGBC.gridy = 1;
    	
        pnlHolderYourScore.add(pnlScore, bigGBC);
        bigGBC.gridx = 0;
    	bigGBC.gridy = 2;
        pnlHolderYourScore.add(getname, bigGBC);
        bigGBC.gridx = 0;
    	bigGBC.gridy = 3;
    	//System.out.println(name);
    	pnlHolderYourScore.add(done, bigGBC);
        
        homeBtn.setPreferredSize(new Dimension(100, 80));
    	Image backImage = back.getImage();
    	backImage.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
    	back = new ImageIcon(backImage);
    	backpnl.add(homeBtn, BorderLayout.CENTER);
    	
    	bigGBC.gridx = 0;
    	bigGBC.gridy = 4;
    	backpnl.setOpaque(false);
        pnlHolderYourScore.add(backpnl, bigGBC);
        homeBtn.addActionListener(action -> homeBtnAction());
        done.addActionListener(action -> doneBtnAction());
    }
	// action to be performed when back button is hit
	private void homeBtnAction() {
		System.out.printf("%d", gamepage.getScore());
    	homepage.frm.remove(pnlHolderYourScore);
    	homepage.frm.setContentPane(homepage.pnl);
    	homepage.frm.validate();
    	homepage.frm.repaint();
	}
	private void doneBtnAction() {
		String myName = getname.getText();
		getname.setText("Your Name");
		appendStrToScoreFile(gamepage.getScore(), myName); 
		homepage.frm.remove(pnlHolderYourScore);
		scorepage.setHighScoreLabels();
    	homepage.frm.setContentPane(scorepage.pnlHolderHighScore);
    	homepage.frm.validate();
    	homepage.frm.repaint();
	}
    public static void appendStrToScoreFile(
            int score, String name)
    {
    	try {
    		BufferedWriter out = new BufferedWriter(
    				new FileWriter("resource/HighScoreList", true));
    		String str = "\n" + Integer.toString(score)+ " " + name;
    		out.write(str);
    		out.close();
    	}
    	catch (IOException e) {
    		System.out.println("exception occoured" + e);
    	}
    }
}
