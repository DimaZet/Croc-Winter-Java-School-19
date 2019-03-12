package task2plus;

public class depB extends Department {
	//protected int processingTime = 3;
	//protected ArrayList<depC> subDeps;
	//protected subDepsCount = 4;
	@Override
	protected void initSubDeps() {
		subDeps = new ArrayList<depC>(subDepCount);
	}
	
	public depB() {
		super(3, 4);
	}
}
