package week5.log;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LogParser {
    private Map<String, Integer> operators;

    public LogParser(String filepath) {
        operators = new HashMap<>();

        try (BufferedReader in = new BufferedReader(new FileReader(filepath))){
            String line;
            while ((line = in.readLine()) != null) {
                addLog(line.split(","));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addLog(String[] parsed) {
        if (operators.containsKey(parsed[2])) {
            Integer i = operators.get(parsed[2]) + Integer.valueOf(parsed[1]) - Integer.valueOf(parsed[0]);
            operators.put(parsed[2], i);
        } else {
            Integer i = Integer.valueOf(parsed[1]) - Integer.valueOf(parsed[0]);
            operators.put(parsed[2], i);
        }
    }

    public int getMidWorkTime() {
        int sum = 0;
        for (Integer i : operators.values()) {
            sum += i;
        }

        return sum / operators.size();
    }
}
