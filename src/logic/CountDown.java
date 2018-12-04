package logic;
import java.util.TimerTask;
class CountDown {
  private long curTime = 0;
  CountDown(final Observer<Long> o, String diff) {
	 if(diff.equals("Easy")) {
		 curTime = 15000;
	 } else if(diff.equals("Medium")) {
		 curTime = 10000;
	 } else {
		 curTime = 5000;
	 }
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
  public long getcurTime() {
	  return curTime;
  }
}