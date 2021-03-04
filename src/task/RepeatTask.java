package task;

public class RepeatTask extends Task{
	// A task that repeats every n days
	
	int cycle;
	
	public RepeatTask(String desc, int month, int day, int cycle) {
		super(desc, month, day);
		this.cycle = cycle;
	}
	
	public void complete() {
		// push to next repeat day
		date.add(date.DATE, cycle);
	}
	
	public void pastDue() {
		date.add(date.DATE, cycle);
	}
	
	public String getDescription() {
		return super.getDescription() + " (repeats every " + cycle + " days)";
	}
}
