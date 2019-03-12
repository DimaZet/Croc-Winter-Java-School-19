package task2plus;

public class depC extends Department {
	//protected int processingTime = 2;
	//protected ArrayList<depD> subDeps;
	//protected subDepsCount = 0;
	@Override
	protected void initSubDeps() {
		//nothing
	}
	
	public depC() {
		super(2, 0);
	}
}
