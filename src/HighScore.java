import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.List;
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
	public JPanel pnlTitle = new JPanel(new GridBagLayout());
	public JPanel pnlHighScores = new JPanel(new GridBagLayout());
	public JPanel backpnl = new JPanel(new GridBagLayout());
	public Home homepage;
	public ImageIcon back = new ImageIcon ("resource/BackButton.png");
	public JButton homeBtnHighScore = new JButton(back);
	ImageIcon HighScoreIcon = new ImageIcon("resource/HighScore.png");
	JLabel labelHighScore = new JLabel(HighScoreIcon);
	//get list of top 5 scores from "resource/HighScoreList"
	ArrayList<ArrayList<String>> highScoreList = 
			new ArrayList<ArrayList<String>>();
	
	JLabel score1 = new JLabel("1.	");
	JLabel score2 = new JLabel("2.	");
	JLabel score3 = new JLabel("3.	");
	JLabel score4 = new JLabel("4.	");
	JLabel score5 = new JLabel("5.	");
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
		GridBagConstraints gbcBack = new GridBagConstraints();
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
        pnlHolderHighScore.add(pnlHighScores);
        
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
		for(int j = 0; j< answer.size(); j++)
		{
			System.out.printf("Before %d: %s %s\n", j, answer.get(j).get(0), answer.get(j).get(1));
		}
		
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
