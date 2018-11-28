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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import javax.imageio.ImageIO;
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
	ArrayList<ArrayList<String>> highScoreList = 
			new ArrayList<ArrayList<String>>();
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
		highScoreList = getTopScores();
		
		score1.setText("1.   " +
				highScoreList.get(0).get(0) +
				"   " + highScoreList.get(0).get(1));
		score2.setText("2.   " +
				highScoreList.get(1).get(0)+ 
				"   " + highScoreList.get(1).get(1));
		score3.setText("3.   " +
				highScoreList.get(2).get(0)+ 
				"   " + highScoreList.get(2).get(1));
		score4.setText("4.   " +
				highScoreList.get(3).get(0)+ 
				"   " + highScoreList.get(3).get(1));
		score5.setText("5.   " +
				highScoreList.get(4).get(0)+ 
				"   " + highScoreList.get(4).get(1));
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
	public ArrayList<ArrayList<String>> getTopScores() {
		ArrayList<ArrayList<String>> answer = new ArrayList<ArrayList<String>>();
		ArrayList<String> inner = new ArrayList<String>();
		try
		{
			Scanner scanner = new Scanner(new File("resource/HighScoreList"));
			while (scanner.hasNext())
			{
				String line = scanner.next();
				inner.add(line);
				//System.out.println(line);
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		ArrayList<String> temp = new  ArrayList<String>();
		for(int i = 0; i<= inner.size()-1; i+=2)
		{
			temp = new ArrayList<String>();
			temp.add(inner.get(i));
			temp.add(inner.get(i+1));
			answer.add(temp);
		}
		//for(int j = 0; j< answer.size(); j++)
		//{
		//	System.out.printf("Before %d: %s %s\n", j, answer.get(j).get(0), answer.get(j).get(1));
		//}
		
		Collections.sort(answer, new Comparator<ArrayList<String>>() {
			@Override
			public int compare(ArrayList<String> a, ArrayList<String>b) {
				if (Integer.parseInt(a.get(0)) > Integer.parseInt((b.get(0))))
				{
					return -1;
				}
				else if (Integer.parseInt(a.get(0)) < Integer.parseInt((b.get(0))))
				{
					return 1;
				}
				else return 0;
			}
		});
		//for(int j = 0; j< answer.size(); j++)
		//{
		//	System.out.printf("After %d: %s %s\n", j, answer.get(j).get(0), answer.get(j).get(1));
		//}
		return answer;
		
	}

}
