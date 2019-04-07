package week6.LongestCallsInLog;

public class Call implements Comparable<Call>{
    public int start;
    public int stop;
    public String operator;

    public Call(int start, int stop, String operator) {
        this.start = start;
        this.stop = stop;
        this.operator = operator;
    }

    public int getTime() {
        return stop - start;
    }

    @Override
    public int compareTo(Call o) {
        return Integer.compare(this.getTime(),o.getTime());
    }

    @Override
    public String toString() {
        return "" + start + "," + stop + "," + operator;
    }

    public static Call valueOf(String [] parsed) {
        return new Call(Integer.valueOf(parsed[0]),Integer.valueOf(parsed[1]),parsed[2]);
    }
}
