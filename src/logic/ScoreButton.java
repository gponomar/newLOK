package logic;

import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ScoreButton implements DrawnButton {

	@Override
	public JButton draw() {
	    ImageIcon scoreIcon = new ImageIcon ("resource/HighScore.png");
	    JButton scoreBtn = new JButton(scoreIcon);

    	scoreBtn.setPreferredSize(new Dimension(100, 100));
    	Image scoreImage = scoreIcon.getImage();
    	scoreImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		
    	return scoreBtn;
	}
}
