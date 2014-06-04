package miscellaneous;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by chace on 6/4/14.
 */
public class KthClosestToPointP {
    public static Point closest(Point[] points, Point p, int k) {
        if (points == null || points.length <= 0 || p == null || k > points.length) {
            return null;
        }
        int len = points.length;
        PointComparator comparator = new PointComparator(p);
        PriorityQueue<Point> queue = new PriorityQueue<Point>(k, comparator);
        for (int i = 0; i < len; i++) {
            if (queue.size() == k) {
                queue.poll();
            }
            queue.add(points[i]);
        }
        return queue.poll();
    }

    public static void main(String[] args) {
        Point[] ps = new Point[7];
        boolean neg = true;
        for (int i = 0; i < 7; i++) {
            Point tmp;
            if (neg) {
                tmp = new Point(-(i+1), -(i+1));
            } else {
                tmp = new Point((i+1), (i+1));
            }
            neg = !neg;
            ps[i] = tmp;
        }

        PointComparator comparator = new PointComparator(new Point(-10, -10));
        PriorityQueue<Point> queue = new PriorityQueue<Point>(3, comparator);
        for (int i = 0; i < 7; i++) {
            if (queue.size() == 3) {
                queue.poll();
            }
            queue.add(ps[i]);
        }
        Point t = queue.poll();
        System.out.println(t.x + " " + t.y);

//        while (!queue.isEmpty()) {
//            Point t = queue.poll();
//            System.out.println(t.x + " " + t.y);
//        }
    }
}

class PointComparator implements Comparator<Point> {
    private Point p;

    public PointComparator(Point p) {
        this.p = p;
    }
    @Override
    public int compare(Point p1, Point p2) {
        int d1 = (int)Math.sqrt(Math.pow(p1.x - p.x, 2) + Math.pow(p1.y - p.y, 2));
        int d2 = (int)Math.sqrt(Math.pow(p2.x - p.x, 2) + Math.pow(p2.y - p.y, 2));
        return d2 - d1;
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

