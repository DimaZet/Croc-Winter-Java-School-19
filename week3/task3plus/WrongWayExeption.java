package croc.week3.task3plus;

import croc.week3.task3.ChessCoord;

public class WrongWayExeption extends Exception{
    public WrongWayExeption(String message, ChessCoord from, ChessCoord to){
        super(message + ": " + from + " -> " + to);
    }
}