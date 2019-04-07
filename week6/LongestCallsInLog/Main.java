package week6.LongestCallsInLog;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        final String FILE_PATH = args[0];
        final int CALL_COUNT = 3;

        ArrayList<Call> log = LogParser.parse(FILE_PATH);
        Collections.sort(log, Collections.reverseOrder());
        for (int i = 0; i < CALL_COUNT; i++) {
            System.out.println(log.get(i));
        }
    }
}
