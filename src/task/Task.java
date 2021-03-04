package task;
import java.util.Calendar;

public abstract class Task {
	String description;
	Calendar date;
	boolean complete = false;
	
	public Task(String desc, int month, int day) {
		description = desc;
		date = Calendar.getInstance();
		date.set(date.get(date.YEAR), month, day);
	}
	
	public String getDescription() {
		return description;
	}
	
	public int getDay() {
		return date.get(date.DATE);
	}
	
	public int getMonth () {
		return date.get(date.MONTH) + 1;
	}
	
	public int getDayOfYear() {
		return date.get(date.DAY_OF_YEAR);
	}
	
	public boolean isComplete () {
		return complete;
	}
	
	public void complete() {
		complete = true;
	}
	
	public abstract void pastDue();
	
}
