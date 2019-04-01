package week5.log;

import java.sql.Time;

public class Log {
    public Time start;
    public Time stop;
    public String operator;

    public Log(Time start, Time stop, String operator) {
        this.start = start;
        this.stop = stop;
        this.operator = operator;
    }

}
