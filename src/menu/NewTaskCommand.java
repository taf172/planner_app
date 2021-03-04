package menu;
import planner.PlannerApp;

public class NewTaskCommand implements Command {
	PlannerApp app;
	
	public NewTaskCommand (PlannerApp app) {
		this.app = app;
	}
	
	public void execute() {
		app.createTask("single");
	}
	
	public void undo() {
		app.removeTask(app.getMasterListSize());
	}
	
}
