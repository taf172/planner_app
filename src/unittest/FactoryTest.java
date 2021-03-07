package unittest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import task.*;

class FactoryTest {

	@Test
	void test() {
		TaskFactory factory = new TodayTaskFactory();
		Task task;
		
		task = factory.newTask("single");
		assertTrue(task.getType() == "single");
		
		task = factory.newTask("streak");
		assertTrue(task.getType() == "streak");
		
		task = factory.newTask("carryover");
		assertTrue(task.getType() == "carryover");
		
		task = factory.newTask("repeat");
		assertTrue(task.getType() == "repeat");
		
		task = factory.newTask("notarealtask");
		assertTrue(task == null);
		
	}

}
