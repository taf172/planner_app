package menu;
import planner.PlannerApp;

public class NewCarryOverTaskCommand implements Command {
	PlannerApp app;
	
	public NewCarryOverTaskCommand (PlannerApp app) {
		this.app = app;
	}
	
	public void execute() {
		app.createTask("carryover");
	}
	
	public void undo() {
		app.removeTask(app.getMasterListSize());
	}
	
}
