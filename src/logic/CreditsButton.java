package logic;

import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class CreditsButton implements DrawnButton {
	
	@Override 
	public JButton draw() {
	    
		ImageIcon creditsIcon = new ImageIcon ("resource/CreditsButton.png");
	    JButton creditsBtn = new JButton(creditsIcon);

    	creditsBtn.setPreferredSize(new Dimension(100, 100));
    	Image creditsImage = creditsIcon.getImage();
    	creditsImage.getScaledInstance(400, 400, Image.SCALE_SMOOTH);
		
    	return creditsBtn;
	}

}
