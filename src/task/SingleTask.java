package task;


public class SingleTask extends Task {
	// A single task that goes away at the end of the day
	
	public SingleTask(String desc, int month, int day) {
		super(desc, month, day);
		
		type = "single";
	}
	
	public void complete() {
		this.complete = true;
	}
	
	public void pastDue() {
		complete = true;
	}
}
