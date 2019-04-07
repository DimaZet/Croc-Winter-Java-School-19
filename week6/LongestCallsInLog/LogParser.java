package week6.LongestCallsInLog;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LogParser {

    public static ArrayList<Call> parse (String filepath) throws IOException {
        ArrayList<Call> log = new ArrayList<>();
        BufferedReader in = new BufferedReader(new FileReader(filepath));
        String line;
        while ((line = in.readLine()) != null) {
            log.add( Call.valueOf( line.split(",") ) );
        }
        in.close();
        return log;
    }

}
