package menu;

public class Menu {
	Command[] menuItems;
	Command undo;
	
	public Menu(int size) {
		menuItems = new Command[size];
		Command noCommand = new NoCommand();
		
		for(int i=0;i<size;i++) {
			menuItems[i] = noCommand;
		}
		
		undo = noCommand;
	}
	
	public void setCommand (int n, Command cmnd) {
		menuItems[n] = cmnd;
	}
	
	public void selectItem (int n) {
		menuItems[n].execute();
		undo = menuItems[n];
	}
	
	public void selectUndo () {
		undo.undo();
	}
	
}
