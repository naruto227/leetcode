package array.maximumsubarray;

import util.ArrayUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Michael Allan on 2020/5/3.
 */
public class MaximumSubarray {
    public static void main(String[] args) throws IOException {
        Solution solution = new MaximumSubarray().new Solution();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line = br.readLine()) != null) {
            int[] nums = ArrayUtil.stringToIntegerArray(line);
            int maxSubArray = solution.maxSubArray(nums);
            System.out.println(maxSubArray);
        }
    }

    class Solution {
        public int maxSubArray(int[] nums) {
            int len = nums.length;
            if(len == 0) {
                return 0;
            }
            int[] dp = new int[len + 1];
            dp[0] = nums[0];
            int max = dp[0];
            for (int i = 1; i < len; i++) {
                dp[i] = dp[i - 1] > 0 ? (dp[i - 1] + nums[i]) : nums[i];
                if (dp[i] > max) {
                    max = dp[i];
                }
            }
            return max;
        }
    }
}
