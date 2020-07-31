package array.magicindex;

/**
 * Created by Michael Allan on 2020/7/31.
 */
public class MagicIndex {
    class Solution {
        public int findMagicIndex(int[] nums) {
            return helper(nums, 0, nums.length - 1);
        }

        private int helper(int[] nums, int low, int high) {
            if (low >  high) {
                return -1;
            }
            int mid = low + (high - low) / 2;
            int lIndex = helper(nums, low, mid - 1);
            if (lIndex != -1) {
                return lIndex;
            } else if(nums[mid] == mid) {
                return mid;
            }

            return helper(nums, mid + 1, high);
        }
    }
}
