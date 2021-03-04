package task;
import java.util.Calendar;

public class CarryOverTask extends Task{
	// A task that carries over to the next day if not complete
	
	public CarryOverTask(String desc, int month, int day) {
		super(desc, month, day);
	}
	
	public void pastDue() {
		// if not complete push to next day
		if(!complete) {
			date.add(date.DATE, 1);
		}
	}
}
