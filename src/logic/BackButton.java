package logic;

import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BackButton implements DrawnButton {

	@Override
	public JButton draw() {
		ImageIcon back = new ImageIcon ("resource/BackButton.png");
		JButton homeBtn = new JButton(back);
		
        homeBtn.setPreferredSize(new Dimension(100, 80));
    	Image backImage = back.getImage();
    	backImage.getScaledInstance(300, 300, Image.SCALE_SMOOTH);

    	return homeBtn;
	}
}
