package croc.week3.task3;

public class ChessCoord {
    private int x;  //0..7
    private int y;  //0..7

    public int getX() {
        return x;
    }

    public void setX(int x) {
        if (x < 0 || x > 7)
            throw new IllegalArgumentException("set illegal x in setX(" + x + ")");
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        if (y < 0 || y > 7)
            throw new IllegalArgumentException("set illegal y in setY(" + y + ")");
        this.y = y;
    }

    public ChessCoord(int x, int y) {
        setX(x);
        setY(y);
    }

    public ChessCoord(String parse) {
        if (parse == null || parse.length() != 2
         || parse.charAt(0) < 'a' || parse.charAt(0) > 'h'
         || parse.charAt(1) < '1' || parse.charAt(1) > '8')
            throw new IllegalArgumentException("illegal parse argument in ChessCoord(" + parse + ")");
        x = parse.charAt(0)-'a';
        y = parse.charAt(1)-'1';
    }

    @Override
    public String toString() {
        return String.valueOf((char)('a'+x)) + (y+1);
    }
}
