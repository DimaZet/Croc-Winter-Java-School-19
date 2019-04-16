package week7.MultyThreads;

public class Call {
    private final int start;
    private final int stop;
    private final String operator;

    public Call(int start, int stop, String operator) {
        this.start = start;
        this.stop = stop;
        this.operator = operator;
    }

    public int getTime() {
        return stop - start;
    }

    @Override
    public String toString() {
        return "" + start + "," + stop + "," + operator;
    }

    public static Call valueOf(String [] parsed) {
        return new Call(Integer.valueOf(parsed[0]),Integer.valueOf(parsed[1]),parsed[2]);
    }

    public int getStart() {
        return start;
    }

    public int getStop() {
        return stop;
    }

    public String getOperator() {
        return operator;
    }
}
