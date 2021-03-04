package planner;
import menu.*;

public class MainMenuState implements PlannerState {
	PlannerApp app;
	Menu menu;
	
	public MainMenuState(PlannerApp app) {
		this.app = app;
	}
	
	public void printMenu() {
		System.out.println();
		System.out.println("Main Menu:");
		System.out.println("1. View today's tasks");
		System.out.println("2. Create a new task");
		System.out.println("3. Delete a task");
		System.out.println("4. Advance to next day");
		System.out.println("5. Quit");
	}
	
	public void enterCommand() {
		int input = app.getInput();
		
		switch (input) {
		case 1:
			app.setState(app.getTaskListState());
			break;
		case 2: 
			app.setState(app.getTaskSelectionState());
			break;
		case 3: 
			app.setState(app.getMasterListState());
			break;
		case 4:
			app.nextDay();
			break;
		case 5: 
			System.exit(0);
			break;
		default:
			System.out.println("Invalid command!");
			break;
		}
		
	}
}
