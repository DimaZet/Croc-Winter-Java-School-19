package task2plus;

public class depB extends depA {
    private static int depBMaxCount = 7;
    private int processingTime;
    public int minTime() {
        return processingTime + super.minTime();
    }
}
