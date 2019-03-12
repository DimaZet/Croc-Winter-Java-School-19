package task2plus;

import java.util.ArrayList;

public abstract class Department {
	protected int processingTime;
	protected ArrayList<Department> subDeps;
	protected int subDepsCount;
	
	protected abstract void initSubDeps();
	private void fillEmptySubDeps() {
		for (Department dep: subDeps) {
			dep.initSubDeps();
			dep.fillEmptySubDeps();
		}
	}
	
	public Department(int time, int count) {
		processingTime = time;
		subDepsCount = count;
		if (subDepsCount == 0)
			return;
		initSubDeps();
		this.fillEmptySubDeps();
	}
}	
