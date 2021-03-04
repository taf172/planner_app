package task;
import java.util.Scanner;
import java.util.Calendar;

public class TodayTaskFactory extends TaskFactory {

		protected Task createTask(String type) {
			
			// Get todays date
			Calendar cal = Calendar.getInstance();
			int month = cal.get(Calendar.MONTH);
			int day = cal.get(Calendar.DATE);
			
			// Get task description
			Scanner scan = new Scanner(System.in);
			System.out.println();
			System.out.print("Enter task description: ");
			String desc = scan.nextLine();
			
			// Create task of appropriate type
			if(type.equals("single")) {
				return new SingleTask(desc, month, day);
			} else if (type.equals("carryover")) {
				return new CarryOverTask(desc, month, day);
			} else if (type.equals("streak")) {
				return new StreakTask(desc, month, day);
			} else if (type.equals("repeat")) {
				System.out.print("Days to repeat: ");
				int cycle = scan.nextInt();
				return new RepeatTask(desc, month, day, cycle);
			}
			
			return null;
			
		}
		

}
