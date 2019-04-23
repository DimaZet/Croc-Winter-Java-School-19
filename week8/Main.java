package week8;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String films = "films.txt";
        String history = "history.txt";
        Graph graph = new Graph();

        try {
            graph.initialize(films, history);
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Integer> request= Arrays.asList(2,1);
        System.out.println(graph.getRecommended(request));
    }
}
