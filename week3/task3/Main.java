package croc.week3.task3;

import croc.week3.task3plus.Horse;
import croc.week3.task3plus.WrongWayExeption;

public class Main {
    public static void main(String[] args) {
        ChessCoord a = new ChessCoord(3, 5);
        ChessCoord b = new ChessCoord("g8");
        System.out.println(a + " " + b);

        try {
            //System.out.println(Horse.validWay("g8", "g9"));
            System.out.println(Horse.validWay("g8", "e7", "c6"));
            //System.out.println(Horse.validWay("g8", "i6"));
            System.out.println(Horse.validWay("g8", "e7", "e6"));
        } catch (WrongWayExeption wrongWayExeption) {
            System.out.println(wrongWayExeption.getMessage());
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}