package logic;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class PauseButton implements DrawnButton {
	@Override
	public JButton draw() {
	    ImageIcon playIcon = new ImageIcon ("resource/pause.png");
	    JButton playBtn = new JButton(playIcon);
	    
        playBtn.setPreferredSize(new Dimension(100, 100));
    	Image playImage = playIcon.getImage();
    	playImage.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
    	
    	return playBtn;
	}
}
