package croc.week3.task3;

public class ChessCoord {
    private int x;  //1..8
    private int y;  //1..8

    public int getX() {
        return x;
    }

    public void setX(int x) {
        if (x < 1 || x > 8)
            throw new IllegalArgumentException("set illegal x in setX(" + x + ")");
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        if (y < 1 || y > 8)
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
        x = parse.charAt(0)-'a'+1;
        y = parse.charAt(1)-'0';
    }

    @Override
    public String toString() {
        return String.valueOf((char)('a'-1+x)) + y;
    }
}
