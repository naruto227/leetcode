package array.divingboard;

/**
 * Created by Michael Allan on 2020/7/8.
 */
public class DivingBoard {

    class Solution {
        public int[] divingBoard(int shorter, int longer, int k) {
            if (k == 0) {
                return new int[]{};
            }
            if (shorter == longer) {
                return new int[] {shorter * k};
            }
            int a1 = shorter * k;
            int an = longer * k;
            int diff = longer - shorter;
            int n = (an - a1) / diff + 1;
            int[] res = new int[n];
            for (int i = 0; i < n; i++) {
                res[i] =  a1 + i * diff;
            }

            return res;
        }

        public int[] divingBoard1(int shorter, int longer, int k) {
            if (k == 0) {
                return new int[k];
            }
            if (shorter == longer) {
                return new int[] {shorter * k};
            }
            int a1 = shorter * k;
            int diff = longer - shorter;
            int[] res = new int[k + 1];
            for (int i = 0; i <= k; i++) {
                res[i] = a1  + i * diff;
            }

            return res;
        }
    }
}
