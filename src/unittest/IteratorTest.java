package unittest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import tasklist.*;
import task.*;

class IteratorTest {

	@Test
	void test() {
		Task task1 = new SingleTask("desc", 1, 1);
		Task task2 = new RepeatTask("desc", 1, 1, 1);
		Task task3 = new StreakTask("desc", 1, 1);
		Task task4 = new CarryOverTask("desc", 1, 1);
		Task temp;
		
		TaskList list = new TaskList();
		Iterator iterator = list.createIterator();
		assertFalse(iterator.hasNext());
		
		list.add(task1);
		list.add(task2);
		list.add(task3);
		list.add(task4);
		assertFalse(iterator.hasNext());
		
		iterator = list.createIterator();
		assertTrue(iterator.hasNext());
		
		temp = iterator.next();
		assertTrue(temp.getType() == "single");
		assertTrue(iterator.hasNext());
		
		temp = iterator.next();
		assertTrue(temp.getType() == "repeat");
		assertTrue(iterator.hasNext());
		
		temp = iterator.next();
		assertTrue(temp.getType() == "streak");
		assertTrue(iterator.hasNext());
		
		temp = iterator.next();
		assertTrue(temp.getType() == "carryover");
		assertFalse(iterator.hasNext());
		
	}

}
