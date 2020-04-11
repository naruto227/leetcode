package dynamicpro.supereggdrop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 链接：https://leetcode-cn.com/problems/super-egg-drop/submissions/
 * Created by Michael Allan on 2020/4/11.
 */
public class SuperEggDrop {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        System.out.print("please input K = ");
        while ((line = br.readLine()) != null) {
            int K = Integer.valueOf(line);
            System.out.print("please input N = ");
            int N = Integer.valueOf(br.readLine());
            int superEggDrop = new Solution().superEggDrop(K, N);
            System.out.println(superEggDrop);
            System.out.print("please input K = ");
        }
    }
    static class Solution {
        public int superEggDrop(int K, int N) {
            return getDropStep(K, N);
        }

        private int getDropStep(int K, int N) {
            int[][] dp = new int[N + 1][K + 1];

            for (int i = 0; i < dp.length; i++) {
                Arrays.fill(dp[i], i);
            }
            dp[1][0] = 0;

            for (int i = 0; i < N; i++) {
                dp[i][0] = 0;
                dp[i][1] = i;
            }

            for (int i = 2; i <= N; i++) {
                for (int j = 2; j <= K; j++) {
                    int low = 1;
                    int high = i;
                    while (low < high) {
                        int mid = (low + high + 1) >> 1;
                        int brokenNum = dp[mid - 1][j - 1];
                        int notBrokenNum = dp[i - mid][j];
                        if (brokenNum > notBrokenNum) {
                            high = mid - 1;
                        }else {
                            low = mid;
                        }
                    }

                    dp[i][j] = 1 + Math.max(dp[low - 1][j - 1], dp[i - low][j]);
                }
            }
            return dp[N][K];
        }
    }
}
