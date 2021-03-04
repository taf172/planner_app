package planner;
import menu.*;

public class TaskSelectionState implements PlannerState{
	PlannerApp app;
	Menu menu;
	
	public TaskSelectionState(PlannerApp app) {
		this.app = app;
		
		Command normal = new NewTaskCommand(app);
		Command carry = new NewCarryOverTaskCommand(app);
		Command repeat = new NewRepeatTaskCommand(app);
		Command streak = new NewStreakTaskCommand(app);
		
		menu = new Menu(4);
		menu.setCommand(0, normal);
		menu.setCommand(1, carry);
		menu.setCommand(2, repeat);
		menu.setCommand(3, streak);
	}
	
	public void printMenu() {
		System.out.println();
		System.out.println("Select type of task:");
		System.out.println("1. Normal task");
		System.out.println("2. Carry over task");
		System.out.println("3. Repeated task");
		System.out.println("4. Streak task");
		System.out.println("5. Undo");
		System.out.println("6. Back to main menu");
	}
	
	public void enterCommand() {
		int input = app.getInput();
		
		switch (input) {
		case 1: case 2: case 3: case 4:
			menu.selectItem(input - 1);
			break;
		case 5:
			menu.selectUndo();
			break;
		case 6:
			app.setState(app.getMainMenuState());
			break;
		default:
			System.out.println("Invalid command!");
			break;
		}
		
	}
}
