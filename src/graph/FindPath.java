package graph;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 * Created by Chace on 7/23/14.
 */
public class FindPath {
    /*
     * Give a map which has some obstacles in it. Given a starting point S and
     * ending point E, find the shortest path from S to E. Note that you can go to
     * any(4) direction from S, but during the process, you can only go straight
     * from the previous direction, unless you hit an obstacle.
     */

    public static void findPath(int[][] M, MPoint s, MPoint e) {
        helper(M, s, e, s, Direction.NONE);
    }

    public static void helper(int[][] M, MPoint s, MPoint e, MPoint c, Direction d) {
        if (c.equals(e)) {
            System.out.println("Found");
            return;
        }
        int len = M.length;
        int v = M[c.x][c.y];
        M[c.x][c.y] = -1;
        if (d == Direction.NONE) {
            if (c.x - 1 >= 0 && M[c.x-1][c.y] != -2) {
                helper(M, s, e, new MPoint(c.x-1, c.y), Direction.UP);
            }
            if (c.x + 1 < len && M[c.x+1][c.y] != -2) {
                helper(M, s, e, new MPoint(c.x+1, c.y), Direction.DOWN);
            }
            if (c.y - 1 >= 0 && M[c.x][c.y-1] != -2) {
                helper(M, s, e, new MPoint(c.x, c.y-1), Direction.LEFT);
            }
            if (c.y + 1 < len && M[c.x][c.y+1] != -2) {
                helper(M, s, e, new MPoint(c.x, c.y+1), Direction.DOWN);
            }
        } else {
            if (d == Direction.UP) {
                if (c.x - 1 >= 0 && M[c.x-1][c.y] != -2) {
                    helper(M, s, e, new MPoint(c.x-1, c.y), d);
                } else {
                    if (c.y - 1 >= 0) {
                      helper(M, s, e, new MPoint(c.x, c.y - 1), Direction.LEFT);
                    }
                    if (c.y + 1 < len) {
                        helper(M, s, e, new MPoint(c.x, c.y + 1), Direction.RIGHT);
                    }
                }
            } else if (d == Direction.DOWN) {
                if (c.x + 1 < len && M[c.x+1][c.y] != -2) {
                    helper(M, s, e, new MPoint(c.x+1, c.y), d);
                } else {
                    if (c.y - 1 >= 0) {
                        helper(M, s, e, new MPoint(c.x, c.y - 1), Direction.LEFT);
                    }
                    if (c.y + 1 < len) {
                        helper(M, s, e, new MPoint(c.x, c.y + 1), Direction.RIGHT);
                    }
                }
            } else if (d == Direction.LEFT) {
                if (c.y - 1 >= 0 && M[c.x][c.y-1] != -2) {
                    helper(M, s, e, new MPoint(c.x, c.y-1), d);
                } else {
                    if (c.x - 1 >= 0) {
                        helper(M, s, e, new MPoint(c.x-1, c.y), Direction.UP);
                    }
                    if (c.x + 1 < len) {
                        helper(M, s, e, new MPoint(c.x+1, c.y), Direction.DOWN);
                    }
                }
            } else if (d == Direction.RIGHT) {
                if (c.y + 1 < len && M[c.x][c.y+1] != -2) {
                    helper(M, s, e, new MPoint(c.x, c.y+1), d);
                } else {
                    if (c.x - 1 >= 0) {
                        helper(M, s, e, new MPoint(c.x-1, c.y), Direction.UP);
                    }
                    if (c.x + 1 < len) {
                        helper(M, s, e, new MPoint(c.x+1, c.y), Direction.DOWN);
                    }
                }
            }
        }
        M[c.x][c.y] = v;
    }
}

class MPoint {
    int x, y;

    public MPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof MPoint) {
            return this.x == ((MPoint)o).x && this.y == ((MPoint)o).y;
        }
        return false;
    }
}

enum Direction {
    NONE, UP, DOWN, LEFT, RIGHT
}

