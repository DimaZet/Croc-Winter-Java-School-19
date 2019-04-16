package week7.MultyThreads;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Company {

    public String getBestWorker(List<String> logs) throws InterruptedException {
        HashMap<String,Integer> operators = new HashMap<>();

        ArrayList<Thread> threads = new ArrayList<>();
        for (String log : logs) {
            Thread t = new Thread(new LogParser(operators, log));
            t.start();
            threads.add(t);
        }

        for (Thread t : threads) {
            t.join();
        }

        List<Map.Entry<String, Integer>> list = new ArrayList(operators.entrySet());
        list.sort((o2, o1) -> Integer.compare(o1.getValue(), o2.getValue()));

        return list.get(0).getKey();
    }

}
