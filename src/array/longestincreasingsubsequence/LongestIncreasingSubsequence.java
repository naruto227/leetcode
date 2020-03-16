package array.longestincreasingsubsequence;

import util.ArrayUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 300
 * Given an unsorted array of integers, find the length of longest increasing subsequence.

 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 * Created by Michael Allan on 2020/3/14.
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = ArrayUtil.stringToIntegerArray(line);
            int lengthOfLIS = new Solution().lengthOfLIS1(nums);
            System.out.println(lengthOfLIS);
        }
    }

    static  class Solution {
        public int lengthOfLIS(int[] nums) {
            int max = 0;

            for (int i = 0; i < nums.length; i++) {
                int prev = nums[i];
                int cur = nums[i];
                int cnt = 1;

                for (int j = i + 1; j < nums.length; j++) {
                    if (cur >= nums[j] && cnt == 1) {
                        break;
                    }
                    if (cur < nums[j]) {
                        // 升序
                        cnt++;
                        prev = cur;
                        cur = nums[j];
                    }else if (cur > nums[j] && prev < nums[j]) {
                        cur = nums[j];
                    }
                }
                max = Math.max(max, cnt);
            }
            return max;
        }

        public int lengthOfLIS1(int[] nums) {
            if(nums.length == 0) {
                return 0;
            }
            int[] dp = new int[nums.length];
            int res = 1;
            dp[0] = 1;
            for (int i = 1; i < nums.length; i++) {
                int maxVal = 0;
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i]) {
                        maxVal = Math.max(maxVal, dp[j]);
                    }
                }
                dp[i] = maxVal + 1;
                res = Math.max(res, dp[i]);
            }
            return res;
        }
    }
}
