package week4;

import java.io.*;
import java.util.ArrayList;

public class CallCentr {

    private ArrayList<Call> log = new ArrayList<>();

    CallCentr(String filepath) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(filepath));
        String line;
        while ((line = in.readLine()) != null) {
            String[] ints = line.split(",");
            int from = Integer.valueOf(ints[0]);
            int to = Integer.valueOf(ints[1]);
            log.add(new Call(from, to));
        }
    }


    private class Call {
        int from;
        int to;
        int crossCount;

        Call(int from, int to) {
            this.from = from;
            this.to = to;
            crossCount = 1;
        }

        Call(int from, int to, int crossCount) {
            this.from = from;
            this.to = to;
            this.crossCount = crossCount;
        }
    }

    private boolean isCrossOver(Call l, Call r) {
        if ((((l.from >= r.from && l.from <= r.to) || (l.to >= r.from && l.to <= r.to))) && log.indexOf(l) != log.indexOf(r))
            return true;
        return false;
    }

    private int countCrosses(Call call, int index) {
        int max = 1;
        for (int i = index; i < log.size(); i++) {
            Call c = log.get(i);
            if ((index != i) && (isCrossOver(call,c))) {
                int l = call.from>c.from?call.from:c.from;
                int r = call.to<c.to?call.to:c.to;
                countCrosses(new Call(l,r), i+1);
            } else {
                int t = callCountInDiapasone(call);
                max = max>t?max:t;
            }
        }
        return max;
    }

    public int maxCrosses() {
        if (log.size() < 1)
            return 0;
        else
            return countCrosses(log.get(0), 0);
    }

    private int callCountInDiapasone(Call diapasone) {
        int count = 0;
        for (Call c : log) {
            if (isCrossOver(c,diapasone)){
                ++count;
            }
        }
        return count;
    }
}
