package tasklist;

import task.Task;

public class TaskListIterator implements Iterator {
	Task[] tasks;
	int position = 0;
	
	public TaskListIterator(Task[] tasks) {
		this.tasks = tasks;
	}
	
	public Task next() {
		Task task = tasks[position];
		position += 1;
		return task;
	}
	
	public boolean hasNext() {
		if (position >= tasks.length||tasks[position] == null) {
			return false;
		} else {
			return true;
		}
	}
}
