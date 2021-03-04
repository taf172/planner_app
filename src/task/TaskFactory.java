package task;

public abstract class TaskFactory {
	public Task newTask(String type) {
		Task task;
		
		task = createTask(type);
		
		return task;
	}
	
	protected abstract Task createTask(String type);
}
