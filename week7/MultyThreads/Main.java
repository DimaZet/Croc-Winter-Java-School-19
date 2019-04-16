package week7.MultyThreads;

import java.util.*;

public class Main {

    private static final int LOGFILE_COUNT = 7;

    public static void main(String[] args) throws InterruptedException {

        String[] files = new String[]{
                "log1.txt","log2.txt","log3.txt","log4.txt","log5.txt","log6.txt","log7.txt"
        };

        HashMap<String,Integer> operators = new HashMap<>();

        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < LOGFILE_COUNT; i++) {
            Thread t = new Thread(new LogParser(operators,files[i]));
            t.start();
            threads.add(t);
        }

        for (Thread t : threads) {
            t.join();
        }

        List list = new ArrayList(operators.entrySet());
        Collections.sort(list, (Comparator<Map.Entry<String, Integer>>) (o1, o2) -> Integer.compare(o1.getValue(), o2.getValue()));

        for (Object o : list) {
            System.out.println(o);
        }

    }
}
