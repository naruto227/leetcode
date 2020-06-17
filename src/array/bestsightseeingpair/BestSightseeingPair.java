package array.bestsightseeingpair;

/**
 * Created by Michael Allan on 2020/6/17.
 */
public class BestSightseeingPair {
    public int maxScoreSightseeingPair(int[] A) {
        int max = A[0] + 0;
        int res = max;
        for (int j = 1; j < A.length; j++) {
            res = Math.max(res, max + A[j] - j);
            max = Math.max(max, A[j] + j);
        }

        return res;
    }
}
