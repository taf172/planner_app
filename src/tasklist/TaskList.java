package tasklist;
import java.util.ArrayList;

import task.Task; 

public class TaskList {
	ArrayList<Task> list;
	
	public TaskList() {
		list = new ArrayList<Task>();
	}
	
	public void add(Task task) {
		list.add(task);
	}
	
	public void remove(int ind) {
		list.remove(ind);
	}
	
	public int size() {
		return list.size();
	}
	
	public void completeTask(int ind) {
		list.get(ind).complete();
	}
	public Iterator createIterator() {
		Task[] array = new Task[list.size()];
		return new TaskListIterator(list.toArray(array));
	}
}
