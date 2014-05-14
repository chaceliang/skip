package edocteel.miscellaneous;

import java.util.ArrayList;

/**
 * Created by chace on 5/14/14.
 */
public class MergeIntervals {

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> results = new ArrayList<Interval>();
        for (int i = 0; i < intervals.size(); i++) {
            results = insert(results, intervals.get(i));
        }
        return results;
    }

    public boolean isOverlay(Interval i1, Interval i2) {
        return !(i1.start > i2.end || i2.start > i1.end);
    }

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> results = new ArrayList<Interval>();
        Interval prev = new Interval(newInterval.start, newInterval.end);
        int i = 0;
        boolean inserted = false;
        while (i < intervals.size() || !inserted) {
            if (i < intervals.size()) {
                Interval current = intervals.get(i);
                if (inserted || current.end < prev.start) {
                    results.add(current);
                } else if (isOverlay(current, prev)) {
                    prev.start = Math.min(current.start, prev.start);
                    prev.end = Math.max(current.end, prev.end);
                } else {
                    results.add(prev);
                    results.add(current);
                    inserted = true;
                }
            } else {
                results.add(prev);
                inserted = true;
            }
            i++;
        }
        return results;
    }
}

