import java.io.File;
import java.io.IOException;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Image;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
public class BackgroundImageJFrame extends JFrame {

	private Image img;
	public BackgroundImageJFrame(String img)
	{
		new ImageIcon(img).getImage();
		
	}
}
