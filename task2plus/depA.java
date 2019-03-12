package task2plus;

public class depA extends Department {
	//protected int processingTime = 5;
	//protected ArrayList<depB> subDeps;
	//protected subDepsCount = 6;
	@Override
	protected void initSubDeps() {
		subDeps = new ArrayList<depB>(subDepCount);
	}
	
	public depA() {
		super(5, 6);
	}
}
