package week7.MultyThreads;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class LogParser implements Runnable{
    private volatile Map<String, Integer> log;
    private String filepath;
    private volatile static Object lock = new Object();

    private void parseFromFile() throws IOException {

        BufferedReader in = new BufferedReader(new FileReader(filepath));
        String line;
        while ((line = in.readLine()) != null) {
             Call c = Call.valueOf( line.split(",") );
             synchronized (lock) {
                 if (log.keySet().contains(c.getOperator())) {
                     Integer i = log.get(c.getOperator()) + 1;
                     log.put(c.getOperator(), i);
                 } else {
                     log.put(c.getOperator(), 1);
                 }
             }
        }
        in.close();
    }

    public LogParser(Map<String, Integer> log, String filepath) {
        this.log = log;
        this.filepath = filepath;
    }

    @Override
    public void run() {
        try {
            parseFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
