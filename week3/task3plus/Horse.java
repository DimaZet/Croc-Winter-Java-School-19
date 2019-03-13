package croc.week3.task3plus;

import croc.week3.task3.ChessCoord;

public class Horse {

    public static String validWay(String... way) throws WrongWayExeption {
        ChessCoord current = new ChessCoord(way[0]);
        ChessCoord nextCoord;
        for (String next : way) {
            nextCoord = new ChessCoord(next);
            if (!canMove(current, nextCoord))
                throw new WrongWayExeption("конь так не ходит", current, nextCoord);
            current = nextCoord;
        }
        return "OK";
    }

    private static boolean canMove(ChessCoord from, ChessCoord to) {
        if ( (Math.abs(to.getX() - from.getX()) == 2  &&  Math.abs(to.getY() - from.getY()) == 1)
          || (Math.abs(to.getX() - from.getX()) == 1  &&  Math.abs(to.getY() - from.getY()) == 2)
          || (from.getY() == to.getY() && from.getX() == to.getX()) )
            return true;
        return false;
    }
}
