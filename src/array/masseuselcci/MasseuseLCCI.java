package array.masseuselcci;

/**
 * 面试题 17.16. The Masseuse LCCI
 * A popular masseuse receives a sequence of back-to-back appointment requests and is debating which ones to accept. She needs a break between appointments and therefore she cannot accept any adjacent requests. Given a sequence of back-to-back appoint­ ment requests, find the optimal (highest total booked minutes) set the masseuse can honor. Return the number of minutes.

 Note: This problem is slightly different from the original one in the book.

 链接：https://leetcode-cn.com/problems/the-masseuse-lcci
 * Created by Michael Allan on 2020/3/24.
 */
public class MasseuseLCCI {
    public static void main(String[] args) {

    }

    static class Solution {
        public int massage(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            int[] dp = new int[nums.length + 1];
            dp[1] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[i]);
            }
            return dp[nums.length];
        }

        public int massage1(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            int pre = 0;
            int cur = 0;
            int next = nums[0];
            for (int i = 0; i < nums.length; i++) {
                next = Math.max(cur, pre + nums[i]);
                pre = cur;
                cur = next;
            }
            return next;
        }
    }
}
