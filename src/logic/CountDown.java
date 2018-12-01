package logic;
import javax.swing.*;
import java.awt.event.*;
import java.util.Date;
@SuppressWarnings("serial")
class CountDown extends JFrame {
  public CountDown(final Observer<Boolean> o) {
	
    setLocation(400,300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    final long TIME_PER_ROUND = 5000;
    final java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("mm : ss");
    final JLabel clock = new JLabel(sdf.format(new Date(TIME_PER_ROUND)),JLabel.CENTER);
    ActionListener al = new ActionListener() {
      long x = TIME_PER_ROUND - 1000;
      public void actionPerformed(ActionEvent ae) {
        clock.setText(sdf.format(new Date(x)));
        x -= 1000;
        if(x <= -1000) {
        	// CODE WILL REDIRECT TO SCORE SCREEN IN LOTK, now it just exits.
        	o.update(true);
        }
       }
    };
    
    new javax.swing.Timer(1000, al).start();
    JPanel jp = new JPanel();
    jp.add(clock);
    getContentPane().add(jp);
    pack();
  }
  
  private static CountDown cntdown;
  
  public static CountDown getInstance(Observer<Boolean> o) {
	  if(cntdown == null) {
	  }
	  return cntdown;
  }
  
}