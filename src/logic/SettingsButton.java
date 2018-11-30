package logic;

import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class SettingsButton implements DrawnButton {

	@Override
	public JButton draw() {
	    ImageIcon settingsIcon = new ImageIcon ("resource/SettingsButton.png");
	    JButton settingBtn = new JButton(settingsIcon);

    	settingBtn.setPreferredSize(new Dimension(100, 100));
    	Image settingsImage = settingsIcon.getImage();
    	settingsImage.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
    	
		return settingBtn;
	}
}
