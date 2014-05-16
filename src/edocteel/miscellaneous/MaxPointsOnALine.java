package edocteel.miscellaneous;

import java.util.HashMap;

/**
 * Created by chace on 5/15/14.
 */
public class MaxPointsOnALine {
    public int maxPoints(Point[] points) {
        if (points == null || points.length <= 0) {
            return 0;
        }

        int maxCount = 1;
        int length = points.length;
        for (int i = 0; i < length; i++) {
            int duplicateCount = 0;
            int currentCount = 0;
            HashMap<Double, Integer> counter = new HashMap<Double, Integer>();
            for (int j = 0; j < length; j++) {
                if (i == j) {
                    continue;
                }
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    duplicateCount++;
                } else {
                    double slope;
                    if (points[i].x == points[j].x) {
                        slope = Double.MAX_VALUE;
                    } else {
                        slope = (double)(points[i].y - points[j].y) / (points[i].x - points[j].x);
                    }
                    if (counter.containsKey(slope)) {
                        int count = counter.get(slope) + 1;
                        counter.put(slope, count);
                        currentCount = Math.max(currentCount, count);
                    } else {
                        counter.put(slope, 1);
                        currentCount = Math.max(currentCount, 1);
                    }
                }
            }
            currentCount += duplicateCount + 1;
            maxCount = Math.max(maxCount, currentCount);
        }
        return maxCount;
    }
}

class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}

