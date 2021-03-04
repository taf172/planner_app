package task;

public class StreakTask extends Task{
	// A repeated task that talies consecutive days completed
	
	int count;
	
	public StreakTask(String desc, int month, int day) {
		super(desc, month, day);
		count = 0;
	}
	
	public void complete() {
		// increase streak counter
		count += 1;
		// push to next day
		date.add(date.DATE, 1);
	}
	
	public void pastDue() {
		// if not complete, reset counter and push to next day
		if(!complete)
			count = 0;
		date.add(date.DATE, 1);
	}
	
	public String getDescription() {
		return super.getDescription() + " (streak count: " + count + ")";
	}
}
