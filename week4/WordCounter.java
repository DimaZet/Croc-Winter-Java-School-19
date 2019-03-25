package week4;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class WordCounter {

    public static void main(String[] args) {

        try (Scanner in = new Scanner(new FileReader(args[0]))) {
            int counter = 0;
            while (in.hasNext()) {
                in.next();
                counter++;
            }
            System.out.println(counter);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
