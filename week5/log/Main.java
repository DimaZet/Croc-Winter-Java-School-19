package week5.log;

public class Main {
    public static void main(String[] args) {
        String filepath = args[0];
        LogParser log = new LogParser(filepath);
        int midWorkTime = log.getMidWorkTime();
        System.out.println(midWorkTime);
    }
}
