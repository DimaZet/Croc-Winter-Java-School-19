package week4;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        try {
            CallCentr callCentr = new CallCentr(args[0]);
            System.out.println(callCentr.maxCrossOvers());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
