package croc.week3.task3plus;

import croc.week3.task3.ChessCoord;

public class WrongWayExeption extends Exception{
    private ChessCoord from;
    private ChessCoord to;

    /**
     * Constructs a new exception with {@code null} as its detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     */
    public WrongWayExeption(ChessCoord from, ChessCoord to) {
        //super();
        this.from = from;
        this.to = to;
    }

    @Override
    public String getMessage() {
        return ("конь так не ходит: " + from + " -> " + to);
    }
}