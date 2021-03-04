package planner;

public class MasterListState implements PlannerState{
	PlannerApp app;
	
	public MasterListState(PlannerApp app) {
		this.app = app;
	}
	
	public void printMenu() {
		app.updateTaskLists();
		System.out.println();
		System.out.println("Choose task to delete: ");
		
		int size = app.getMasterListSize();
		app.printAllTasks();
		
		System.out.println(size + 1 + ". Back to main menu");
	}
	
	public void enterCommand() {
		int input = app.getInput();
		int size = app.getMasterListSize();
		
		if(input > 0 && input <= size) {
			app.removeTask(input);
		} else if (input == size + 1) {
			app.setState(app.getMainMenuState());
		} else {
			System.out.println("Invalid command!");
		}
	}
}
