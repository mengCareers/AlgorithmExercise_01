/*
Answers within 10^-6 of the true value will be accepted as correct => Binary Search && while (l + 1e-6 < r)
For d within range [0, stations[stations.length - 1] - stations[0]], we do BS. To shrink the range, we compare cnt with K (cnt is # of additional gas stations)
 */
package Searching;

/**
 *
 * @author xinrong
 */
public class MinimizeMaxDistancetoGasStation {

    public static void main(String[] args) {
        System.out.println(1e-6 == 0.000001);
    }

    public double minmaxGasDist(int[] stations, int K) {
        double l = 0, r = stations[stations.length - 1] - stations[0];
        while (l + 1e-6 < r) {
            double d = l + (r - l) / 2;
            int cnt = 0;
            for (int i = 0; i < stations.length - 1; i++) {
                cnt += Math.ceil((stations[i + 1] - stations[i]) / d) - 1;// 10 / 3, ceil 4
            }
            if (cnt <= K) { // cnt can be larger, i.e., d can be smaller
                r = d;
            } else {
                l = d;
            }
        }
        return l;
    }

}
