package logic;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.util.logging.Logger;


public class Credits {
	private DrawnButtonFactory btnFactory = new DrawnButtonFactory();
	private static final Logger LOGGER = Logger.getLogger(Credits.class.getName());
	private JPanel pnlTitle = new JPanel();
	private JPanel pnlcredits = new JPanel(new GridBagLayout());
	private JPanel backpnl = new JPanel();
	private Home homepage;
	public void setHomepage(Home val) {
		homepage = val;
	}
	private JButton homeBtn;
	private ImageIcon creditsIcon = new ImageIcon("resource/Credits.png");
	private JLabel labelCredits = new JLabel();
	private JLabel labelName1 = new JLabel("Evan Jameson", SwingConstants.CENTER);
	private JLabel labelName2 = new JLabel("Ryan Nevils", SwingConstants.CENTER);
	private JLabel labelName3 = new JLabel("Ishan Pandey", SwingConstants.CENTER);
	private JLabel labelName4 = new JLabel("Grant Parton", SwingConstants.CENTER);
	private JLabel labelName5 = new JLabel("Grace Ponomaroff", SwingConstants.CENTER);
	private JLabel labelName6 = new JLabel("Kiley Roberson", SwingConstants.CENTER);
	private JLabel labelName7 = new JLabel("");
	
	public String getGrantLabel() {
		return labelName4.getText();
	}
	
	public static final JPanel pnlHolderCredits = new JPanel(new GridBagLayout())
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
				LOGGER.severe("File not found");
			}
			g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
			}
		};
	
		public Credits() {
    	GridBagConstraints gbcNames = new GridBagConstraints();
    	gbcNames.fill = GridBagConstraints.HORIZONTAL;
    	GridBagConstraints bigGBC = new GridBagConstraints();
    	bigGBC.fill = GridBagConstraints.HORIZONTAL;
    	bigGBC.anchor = GridBagConstraints.NORTH;
		
		
		Image creditsImage = creditsIcon.getImage();
    	creditsImage = creditsImage.getScaledInstance(500, 200, Image.SCALE_SMOOTH);
    	creditsIcon = new ImageIcon(creditsImage);
    	labelCredits.setIcon(creditsIcon);
    	pnlTitle.add(labelCredits);
    	
    	bigGBC.gridx = 0;
    	bigGBC.gridy = 0;
    	pnlTitle.setOpaque(false);
    	pnlHolderCredits.add(pnlTitle, bigGBC);
    	
    	bigGBC.insets = new Insets(20, 2, 2, 30);
    	pnlcredits.setOpaque(false);
		labelName1.setFont(new Font(labelName1.getName(), Font.PLAIN, 50));
    	gbcNames.gridx = 0;
    	gbcNames.gridy = 0;
        pnlcredits.add(labelName1, gbcNames);
		labelName2.setFont(new Font(labelName1.getName(), Font.PLAIN, 50));
    	gbcNames.gridx = 0;
    	gbcNames.gridy = 1;
        pnlcredits.add(labelName2, gbcNames);
		labelName3.setFont(new Font(labelName1.getName(), Font.PLAIN, 50));
    	gbcNames.gridx = 0;
    	gbcNames.gridy = 2;
        pnlcredits.add(labelName3, gbcNames);
		labelName4.setFont(new Font(labelName1.getName(), Font.PLAIN, 50));
    	gbcNames.gridx = 0;
    	gbcNames.gridy = 3;
        pnlcredits.add(labelName4, gbcNames);
		labelName5.setFont(new Font(labelName1.getName(), Font.PLAIN, 50));
    	gbcNames.gridx = 0;
    	gbcNames.gridy = 4;
        pnlcredits.add(labelName5, gbcNames);
		labelName6.setFont(new Font(labelName1.getName(), Font.PLAIN, 50));
    	gbcNames.gridx = 0;
    	gbcNames.gridy = 5;
        pnlcredits.add(labelName6, gbcNames);
    	bigGBC.gridx = 0;
    	bigGBC.gridy = 1;
    	labelName7.setPreferredSize(new Dimension(10, 50));
        pnlcredits.add(labelName7, gbcNames);
    	bigGBC.gridx = 0;
    	bigGBC.gridy = 1;
        pnlHolderCredits.add(pnlcredits, bigGBC);
        
		DrawnButton dbBack = btnFactory.getButton("BACK");
		homeBtn = dbBack.draw();
    	backpnl.add(homeBtn, BorderLayout.CENTER);
    	
    	bigGBC.gridx = 0;
    	bigGBC.gridy = 2;
    	backpnl.setOpaque(false);
        pnlHolderCredits.add(backpnl, bigGBC);      
        
        homeBtn.addActionListener(action -> homeBtnAction());

    }
		
	public JButton getBackBtn() {
		return homeBtn;
	}
	
	// action to be performed when back button is hit
	private void homeBtnAction() {
    	homepage.frm.remove(pnlHolderCredits);
    	homepage.frm.setContentPane(homepage.pnl);
    	homepage.frm.validate();
    	homepage.frm.repaint();
	}

}
