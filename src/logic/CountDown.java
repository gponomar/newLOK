package logic;
import javax.swing.*;
import java.awt.event.*;
import java.util.Date;
import java.util.TimerTask;
@SuppressWarnings("serial")
class CountDown {
  public static long curTime = 5000;
  public CountDown(final Observer<Long> o) {
	 curTime= 5000;
	 java.util.Timer clock = new java.util.Timer("Timer");
	 TimerTask task = new TimerTask() {
	      public void run() {
	    	  curTime -= 1000;
	          o.update(curTime);
	          if(curTime<0) {
	        	  clock.cancel();
	        	  clock.purge();
	          }
	      }
	  };
    clock.schedule(task, 1000, 1000);
  }
}