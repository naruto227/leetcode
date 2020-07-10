package dynamicpro.investstock;

import util.ArrayUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 309. Best Time to Buy and Sell Stock with Cooldown
 * Created by Michael Allan on 2020/7/10.
 */
public class InvestStock {
    public static void main(String[] args) throws IOException {
        Solution solution = new InvestStock().new Solution();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            int[] prices = ArrayUtil.stringToIntegerArray(line);
            int maxProfit = solution.maxProfit(prices);
            System.out.println(maxProfit);
        }
    }

    class Solution {
        public int maxProfit(int[] prices) {
            if (prices.length == 0) {
                return 0;
            }
            int n = prices.length;
            // dp[][0]，持有股票时的最大收益
            // dp[][1]，未持有股票，且是冻结状态时的最大收益
            // dp[][2]，未持有股票，非冻结状态时的最大收益
            int[][] dp = new int[n][3];
            dp[0][0] = -prices[0];
            for (int i = 1; i < n; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
                dp[i][1] = dp[i - 1][0] + prices[i];
                dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
            }

            return Math.max(dp[n - 1][1], dp[n - 1][2]);
        }
    }
}
