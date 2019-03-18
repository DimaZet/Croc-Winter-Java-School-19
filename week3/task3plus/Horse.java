package croc.week3.task3plus;

import croc.week3.task3.ChessCoord;

public class Horse {

    public static String validWay(String... way) throws WrongWayExeption {
        ChessCoord current = new ChessCoord(way[0]);
        ChessCoord nextCoord;
        for (int i=1; i<way.length; ++i){
            nextCoord = new ChessCoord(way[i]);
            if (!canMove(current, nextCoord))
                throw new WrongWayExeption(current, nextCoord);
            current = nextCoord;
        }
        return "OK";
    }

    private static boolean canMove(ChessCoord from, ChessCoord to) {
        if ( (Math.abs(to.getX() - from.getX()) == 2  &&  Math.abs(to.getY() - from.getY()) == 1)
          || (Math.abs(to.getX() - from.getX()) == 1  &&  Math.abs(to.getY() - from.getY()) == 2))
            return true;
        return false;
    }
}
