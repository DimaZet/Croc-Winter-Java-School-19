package week7.MultyThreads;


import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        List<String> logs = Arrays.asList("log1.txt","log2.txt","log3.txt","log4.txt","log5.txt","log6.txt","log7.txt");
        Company cr0c0c = new Company();
        String best = cr0c0c.getBestWorker(logs);
        System.out.println("Coolest monkey is " + best);
    }
}
