package week8;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Graph {
    private Map<Integer, Node> graph;

    private class Node {
        public String name;
        public Map<Integer, Integer> links = new HashMap<>();

        public Node(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "name='" + name + '\'' +
                    ", links=" + links +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return Objects.equals(name, node.name);
        }

        @Override
        public int hashCode() {

            return Objects.hash(name);
        }
    }

    public Graph() {
        graph = new HashMap<>();
    }

    public Map<Integer, Node> getGraphMap() {
        return graph;
    }

    public void setFilmsFromFile(String filePath) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = in.readLine()) != null) {
            String []parsed = line.split(",");
            if (parsed.length != 2)
                throw new IllegalArgumentException("Broken line from film list file!");
            graph.put(Integer.valueOf(parsed[0]), new Node(parsed[1]));
        }
    }

    public void setViewsFromFile(String filePath) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = in.readLine()) != null) {
            //String[] parsed = line.split(",");
            int[] parsed = Arrays.stream(line.split(",")).mapToInt(Integer::parseInt).toArray();
            for (int i = 0; i < parsed.length-1; i++) {
                for (int j = i; j < parsed.length; j++) {
                    if (parsed[i] == parsed[j])
                        continue;
                    link(parsed[i],parsed[j]);
                }

            }
        }
    }

    public void initialize(String filmsPath, String viewsPath) throws IOException {
        setFilmsFromFile(filmsPath);
        setViewsFromFile(viewsPath);
    }

    private void link(int i, int j) {
        incMapValue(graph.get(i).links, j, 1);
        incMapValue(graph.get(j).links, i, 1);
    }

    public List getRecommended(List<Integer> arg) {
        HashSet<Integer> views = new HashSet<>(arg);

        Map<Integer,Integer> recommended = new HashMap<>();
        for (int i : views) {
            Map<Integer, Integer> map = graph.get(i).links;
            for(Map.Entry<Integer,Integer> e : map.entrySet()) {
                if(!views.contains(e.getKey()))
                    incMapValue(recommended,e.getKey(),e.getValue());
            }
        }

        List list = new ArrayList(recommended.entrySet());
        list.sort((Comparator<Map.Entry<Integer, Integer>>) (o2, o1) -> o1.getValue() - o2.getValue());
        return list.subList(0,list.size()>2?3:list.size());
    }

    private void incMapValue(Map<Integer,Integer> map, int key, int value){
        if (map.containsKey(key)) {
            int count = map.get(key) + 1;
            map.put(key,count);
        } else {
            map.put(key,1);
        }
    }


}
