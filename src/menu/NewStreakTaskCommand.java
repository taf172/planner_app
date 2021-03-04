package menu;
import planner.PlannerApp;

public class NewStreakTaskCommand implements Command {
	PlannerApp app;
	
	public NewStreakTaskCommand (PlannerApp app) {
		this.app = app;
	}
	
	public void execute() {
		app.createTask("streak");
	}
	
	public void undo() {
		app.removeTask(app.getMasterListSize());
	}
	
}
