package ObserverClock;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;
import java.util.Observable;

import javax.swing.Timer;

public class Clock extends Observable implements ActionListener {

	public static Timer timer;   

	public Clock(){
		this.startClock();
	}
	
	public String getTime(){
		String time = "";

		GregorianCalendar calendario = new GregorianCalendar();   
		int h = calendario.get(GregorianCalendar.HOUR_OF_DAY);   
		int m = calendario.get(GregorianCalendar.MINUTE);   
		int s = calendario.get(GregorianCalendar.SECOND);   
		time += ((h < 10) ? "0" : "") + h + ":";
		time += ((m < 10) ? "0" : "") + m + ":";
		time += ((s < 10) ? "0" : "") + s;

		return time;
	}
	
	public void actionPerformed(ActionEvent e) {
		setChanged();
		notifyObservers(this.getTime());
	}
	
	public void startClock() {
		if (timer == null) {
			timer = new javax.swing.Timer(1000, this);
			timer.setInitialDelay(0);
			timer.start();
		}
	}

	public void restartClock(){
		if (!timer.isRunning()){
			timer.restart();	
		}
	}
		
	public void stopClock() {
		if (timer != null) {
			timer.stop();
		}
	}
}