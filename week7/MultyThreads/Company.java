package week7.MultyThreads;


import java.util.*;

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

        return Collections.max(operators.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
    }

}
