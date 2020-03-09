package array.stockinvest;

import util.ArrayUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Michael Allan on 2020/3/9.
 */
public class StockInvest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            int[] prices = ArrayUtil.stringToIntegerArray(line);
            int maxProfit = Solution.maxProfit1(prices);
            System.out.println(maxProfit);
        }
    }

    private static class Solution {
        /**
         * for循环的暴力破解
         * @param prices
         * @return
         */
        public static int maxProfit(int[] prices) {
            int max = 0;
            for (int i = 0; i < prices.length - 1; i++) {
                for (int j = i + 1; j < prices.length; j++) {
                    if(prices[j] - prices[i] > max) {
                        max = prices[j] - prices[i];
                    }
                }
            }
            return max;
        }

        public static int maxProfit1(int[] prices) {
            int max = 0;
            int end = prices.length - 1;
            int begin = 0;
            while (begin != end && end > 0) {
                for (int i = begin; i > -1; i--) {
                    if (prices[end] - prices[i] > max) {
                        max = prices[end] - prices[i];
                    }
                    end--;
                }
                end = prices.length - 1;
                begin++;
            }
            return max;
        }

        /**
         * 用动态规划解
         * @param prices
         * @return
         */
        public static int maxProfit2(int[] prices) {

            return 0；
        }
    }
}
