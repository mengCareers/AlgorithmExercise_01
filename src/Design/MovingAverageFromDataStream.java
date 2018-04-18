package Design;

/*
input: size
output:when called next, get next window average of size
*/
import java.util.LinkedList;
import java.util.Queue;

class MovingAverage {
    /*
    keep track of sum of curr window using Q
    then it will save a lot of work while getting moving sum
    */
    private static int sz;
    private static Queue<Integer> q;
    private static double prevSum;
    
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        sz = size;
        q = new LinkedList<>();
        prevSum = 0.0;
    }
    
    public double next(int val) {
        if (q.size() == sz)
            prevSum -= q.poll();
        prevSum += val;
        q.add(val);
        return prevSum / q.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
