package planner;

import task.*;
import tasklist.*;

import java.util.Scanner;
import java.util.Calendar;

public class PlannerApp {
	TaskList allTasks;
	TaskList todaysTasks;
	TaskFactory factory;
	
	PlannerState mainMenu;
	PlannerState masterList;
	PlannerState taskList;
	PlannerState taskSelection;
	PlannerState currentState;
	
	Calendar date;
	
	public PlannerApp() {
		date = Calendar.getInstance();
		
		allTasks = new TaskList();
		todaysTasks = new TaskList();
		factory = new TodayTaskFactory();
		
		mainMenu = new MainMenuState(this);
		masterList = new MasterListState(this);
		taskList = new TaskListState(this);
		taskSelection = new TaskSelectionState(this);
		currentState = mainMenu;
	}
	
	// State Methods
	public void printMenu() {
		currentState.printMenu();
	}
	
	public void enterCommand() {
		currentState.enterCommand();
	}
	
	void setState(PlannerState state) {
		this.currentState = state;
	}
	
	PlannerState getMainMenuState() {
		return this.mainMenu;
	}
	
	PlannerState getMasterListState() {
		return this.masterList;
	}
	
	PlannerState getTaskListState() {
		return this.taskList;
	}
	
	PlannerState getTaskSelectionState() {
		return this.taskSelection;
	}
	
	// Planner app methods
	public void createTask(String type) {
		Task task = factory.newTask(type);
		allTasks.add(task);
		System.out.println("Task created!");
	}
	
	public void addTask(Task task) {
		allTasks.add(task);
	}
	
	public void removeTask(int ind) {
		allTasks.remove(ind - 1);
		System.out.println("Task removed");
	}
	
	public void printAllTasks() {
		
		Iterator iterator = allTasks.createIterator();
		int count = 1;
		
		while(iterator.hasNext()) {
			Task current = iterator.next();
			System.out.println(count + ". "
					+ current.getMonth() 
					+ "/" + current.getDay() 
					+ " " + current.getDescription());
			count += 1;
		}
	}
	
	public void printTodaysTasks() {
		Iterator iterator = todaysTasks.createIterator();
		int count = 1;
		
		while(iterator.hasNext()) {
			Task current = iterator.next();
			System.out.println(count + ". " + current.getDescription());
			count += 1;
		}
	}
	
	public void setTodaysTasks() {
		todaysTasks = new TaskList();
		Iterator iterator = allTasks.createIterator();
		
		while(iterator.hasNext()) {
			Task current = iterator.next();
			if(!current.isComplete() && this.getDayOfYear() == current.getDayOfYear())
				todaysTasks.add(current);
		}
		
	}
	
	public void setAllTasks() {
		Iterator iterator;
		TaskList temp;
		
		// Check for past due tasks
		iterator = allTasks.createIterator();
		while(iterator.hasNext()) {
			Task current = iterator.next();
			if(current.getDayOfYear() < this.getDayOfYear())
				current.pastDue();
		}
		
		// Update task list
		temp = new TaskList();
		iterator = allTasks.createIterator();
		while(iterator.hasNext()) {
			// Update master list
			Task current = iterator.next();
			if(current.getDayOfYear() >= this.getDayOfYear())
				temp.add(current);
		}
		
		allTasks = temp;
	}

	public void updateTaskLists() {
		this.setAllTasks();
		this.setTodaysTasks();
	}
	
	public void completeTask(int ind) {
		todaysTasks.completeTask(ind);
	}
	
	public void nextDay() {
		date.add(date.DATE, 1);
	}
	
	// Getters
	public int getMasterListSize() {
		return allTasks.size();
	}
	
	public int getTaskListSize() {
		return todaysTasks.size();
	}
	
	public int getDayOfYear() {
		return date.get(date.DAY_OF_YEAR);
	}
	
	public int getInput() {
		Scanner scan = new Scanner(System.in);
		System.out.print(">> ");
		int input = scan.nextInt();
		return input;
	}
	
	// Main program
	public static void main(String[] args) {
		PlannerApp app = new PlannerApp();
		
		while(true) {
			app.printMenu();
			app.enterCommand();
		}

	}

}
