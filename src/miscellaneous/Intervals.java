package miscellaneous;

import java.util.ArrayList;

/**
 * Created by chace on 6/22/14.
 */
public class Intervals {
    // Linkedin

    public static int getTotalCoveredLength(Interval[] A) {
        if (A == null) {
            throw new NullPointerException();
        }
        int len = A.length;
        ArrayList<Interval> result = new ArrayList<Interval>();
        Interval curr = A[0];
        for (int i = 1; i < len; i++) {
            Interval t = A[i];
            if (isInterset(curr, t)) {
                merge(curr, t);
            } else {
                result.add(new Interval(curr.start, curr.end));
                curr = t;
            }
        }
        result.add(new Interval(curr.start, curr.end));
        int cover = 0;
        for (Interval i : result) {
            cover += i.end - i.start;
        }
        return cover;
    }

    public static boolean isInterset(Interval i1, Interval i2) {
        return !(i1.start > i2.end && i2.start > i1.end);
    }
    public static void merge(Interval i1, Interval i2) {
        i1.start = Math.min(i1.start, i2.start);
        i2.end = Math.max(i1.end, i2.end);
    }
}

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}