package week6.LongestCallsInLog;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        String filepath = args[0];

        ArrayList<Call> log = new ArrayList<>();
        log = LogParser.parse(filepath);
        Collections.sort(log, Collections.reverseOrder());
        for (int i = 0; i < 3; i++) {
            System.out.println(log.get(i));
        }
    }
}
