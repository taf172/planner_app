package menu;
import planner.PlannerApp;

public class NewRepeatTaskCommand implements Command {
	PlannerApp app;
	
	public NewRepeatTaskCommand (PlannerApp app) {
		this.app = app;
	}
	
	public void execute() {
		app.createTask("repeat");
	}
	
	public void undo() {
		app.removeTask(app.getMasterListSize());
	}
	
}
