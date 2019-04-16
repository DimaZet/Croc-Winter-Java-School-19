package week7.MultyThreads;


import java.util.*;

public class Company {

    public String getBestWorker(List<String> logs) throws InterruptedException {
        HashMap<String,Integer> operators = new HashMap<>();

        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < logs.size(); i++) {
            Thread t = new Thread(new LogParser(operators, logs.get(i)));
            t.start();
            threads.add(t);
        }

        for (Thread t : threads) {
            t.join();
        }

        List<Map.Entry<String, Integer>> list = new ArrayList(operators.entrySet());
        Collections.sort(list, (o2, o1) -> Integer.compare(o1.getValue(), o2.getValue()));

        return list.get(0).getKey();
    }

}
