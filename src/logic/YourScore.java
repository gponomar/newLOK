package logic;

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
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class YourScore {
	public JPanel pnlTitle = new JPanel();
	public JPanel pnlScore = new JPanel(new GridBagLayout());
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
	private static final Logger LOGGER = Logger.getLogger(YourScore.class.getName());
	private JTextArea getname = new JTextArea("Your_Name");
	public JTextArea getGetName() {
		return getname;
	}
	private JButton done = new JButton("done");
	public JButton getDone() {
		return done;
	}
	private int theScore;
	public void setScore(int x) {
		this.theScore = x;
	}
	private String theDiff;
	public void setDiff(String x) {
		this.theDiff = x;
	}
	private ImageIcon yourScoreIcon = new ImageIcon("resource/HighScore.png");
	private JLabel labelYourScore = new JLabel(yourScoreIcon);
	private JLabel scoreLabels = new JLabel();
	public static final JPanel pnlHolderYourScore = new JPanel(new GridBagLayout())
	{
		@Override
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
    	pnlTitle.add(scoreLabels);
    	
    	bigGBC.gridx = 0;
    	bigGBC.gridy = 0;
    	pnlTitle.setOpaque(false);
    	pnlHolderYourScore.add(pnlTitle, bigGBC);

    	
    	bigGBC.insets = new Insets(60, 2, 2, 30);
    	pnlScore.setOpaque(false);
    	scoreLabels.setFont(new Font(scoreLabels.getName(), Font.PLAIN, 50));
    	gbcNames.gridx = 0;
    	gbcNames.gridy = 0;
        pnlScore.add(scoreLabels, gbcNames);
    	bigGBC.gridx = 0;
    	bigGBC.gridy = 1;
    	
        pnlHolderYourScore.add(pnlScore, bigGBC);
        bigGBC.gridx = 0;
    	bigGBC.gridy = 2;
        pnlHolderYourScore.add(getname, bigGBC);
        bigGBC.gridx = 0;
    	bigGBC.gridy = 3;
    	pnlHolderYourScore.add(done, bigGBC);
        
        done.addActionListener(action -> {
			try {
				doneBtnAction();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
    }
	// action to be performed when done button is hit
	private void doneBtnAction() throws IOException {
		String myName = getname.getText();
		getname.setText("Your Name");
		appendStrToScoreFile(theScore, myName, theDiff); 
		homepage.frm.remove(pnlHolderYourScore);
		TopScoreManager.getInstance().refreshScores("resource/HighScoreList");
		scorepage.setHighScoreLabels();
    	homepage.frm.setContentPane(scorepage.pnlHolderHighScore);
    	homepage.frm.validate();
    	homepage.frm.repaint();
	}
    public static void appendStrToScoreFile(
            int score, String name, String diff)throws IOException
    {
    	String path = "resource/HighScoreList";
    	try (BufferedWriter br = new BufferedWriter(new FileWriter(path, true))){
    		String str = "\n" + Integer.toString(score)+ " " + name + "-"+ diff;
    		br.write(str);
    	}
    	catch (IOException e) {
    		LOGGER.severe("exception occoured" + e);
    	}
    }
}
