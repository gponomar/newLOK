package logic;

import java.util.TimerTask;

public class CountDown {

	private long curTime = 0;
	public Boolean quit = false;
	
	public long timeToRun(String diff) {
		if(diff.equals("Easy")) {
			return 30000;
		} else if(diff.equals("Medium")) {
			return 20000;
		} else {
			return 10000;
		}
	}
	
	public CountDown(final Observer<Long> o, String diff) {
		java.util.Timer clock = new java.util.Timer("Timer");
		curTime = timeToRun(diff);
		TimerTask task = new TimerTask() {
			public void run() {
				curTime -= 1000;
				o.update(curTime);
				if(curTime<0 || quit) {
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