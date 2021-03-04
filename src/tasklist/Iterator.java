package tasklist;

import task.Task;

public interface Iterator {
	boolean hasNext();
	Task next();
}
