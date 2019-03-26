package week4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CallCentr {

    private ArrayList<Call> log = new ArrayList<>();

    CallCentr(String filepath) throws FileNotFoundException {
        Scanner in = new Scanner(new File(filepath));
        int x, y;
        while (in.hasNext()) {
            x = in.nextInt();
            in.nextByte();
            y = in.nextInt();
            log.add(new Call(x, y));
        }
    }


    private class Call {
        int from;
        int to;
        int crossCount;

        Call(int from, int to) {
            this.from = from;
            this.to = to;
            crossCount = 0;
        }
    }

    private boolean isCrossOver(Call l, Call r) {
        if ((((l.from >= r.from && l.from <= r.to) || (l.to >= r.from && l.to <= r.to))) && log.indexOf(l) != log.indexOf(r))
            return true;
        return false;
    }

    public int maxCrossOvers(){
        int max = Integer.MIN_VALUE;
        for (Call a : log) {
            for (Call b : log){
                if (isCrossOver(a,b)) {
                    if ( ++(a.crossCount) > max) {
                        max = a.crossCount;
                    }

                }
            }
        }
        return max;
    }


}
