package planner;

public class TaskListState implements PlannerState{
	PlannerApp app;
	
	public TaskListState(PlannerApp app) {
		this.app = app;
	}
	
	public void printMenu() {
		app.updateTaskLists();
		System.out.println();
		System.out.println("Choose task to complete: ");
		
		int size = app.getTaskListSize();
		app.printTodaysTasks();
		
		System.out.println(size + 1 + ". Back to main menu");
	}
	
	public void enterCommand() {
		int input = app.getInput();
		int size = app.getTaskListSize();
		
		if(input > 0 && input <= size) {
			app.completeTask(input - 1);
		} else if (input == size + 1) {
			app.setState(app.getMainMenuState());
		} else {
			System.out.println("Invalid command!");
		}
	}
}
