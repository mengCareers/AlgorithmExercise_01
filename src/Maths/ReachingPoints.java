/* 780.Reaching Points
A move : (x, y) => (x, x + y) or (x + y, y)
Starting point : (sx, sy)
target point : (tx, ty)
output : true if and only if a sequence of moves exists to transform (sx, sy) to (tx, ty)
 * Thought Process:
Recursion, TLE
 * Hint :
Can we work backwards? From target to start, (x, y) <= (x, y - x) or (x - y, y)
if (tx > ty), 
next will be (tx - ty, ty) until such time that tx = tx % ty
if (7, 3) will be (4, 3) will be (1, 3)
until such time that 1 = 7 % 3


package Maths;

/**
 *
 * @author xinrong
 */
public class ReachingPoints {

    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if (sx > tx || sy > ty) {
            return false;
        }
        if (sx == tx && (ty - sy) % sx == 0) {
            return true;
        }
        if (sy == ty && (tx - sx) % sy == 0) {
            return true;
        }
        return reachingPoints(sx, sy, tx % ty, ty % tx);
    }

    public boolean reachingPointsTLE(int sx, int sy, int tx, int ty) {
        if (sx == tx && sy == ty) {
            return true;
        }
        if (sx > tx || sy > ty) {
            return false;
        }
        if (tx > ty) {

        }
        return reachingPointsTLE(sx, sx + sy, tx, ty) || reachingPointsTLE(sx + sy, sy, tx, ty);
    }

}
