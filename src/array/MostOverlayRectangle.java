package array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by chace on 5/27/14.
 */
public class MostOverlayRectangle {

    // Supposed R is sorted by ll;
    public static int mostOverlay(Retangle[] R) {
        Arrays.sort(R);
        if (R == null || R.length <= 0) {
            return 0;
        }

        int result = 0;
        for (int i = 0; i < R.length; i++) {
            int overlay = 0;
            for (int j = i+1; j < R.length; j++) {
                if (R[j].ll.x > R[i].hr.x || R[j].ll.y > R[i].hr.y) {
                    break;
                } else {
                    overlay++;
                }
            }
            if (overlay > result) {
                result = overlay;
            }
        }
        return result;
    }
}

class Retangle {
    Point ll;
    Point hl;
    Point lr;
    Point hr;

    public Retangle(Point ll, Point hl, Point lr, Point hr) {
        this.ll = ll;
        this.hl = hl;
        this.lr = lr;
        this.hr = hr;
    }
}

class Point implements Comparable<Point> {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point point) {
        double d = Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
        double d2 = Math.sqrt(Math.pow(point.x, 2) + Math.pow(point.y, 2));
        return (int)(d - d2);
    }
}