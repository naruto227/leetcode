package array.sortarray;

/**
 * 912. 排序数组
 * Created by Michael Allan on 2020/3/31.
 */
public class SortArray {
    public static void main(String[] args) {

    }

    static class Solution {
        public int[] sortArray(int[] nums) {
            quickSort(nums, 0, nums.length - 1);
            return nums;
        }

        /**
         * 快速排序
         * @param nums
         * @param low
         * @param high
         */
        private void quickSort(int[] nums, int low, int high) {
            if (low <= high) {
                int pos = findPos(nums, low, high);
                quickSort(nums, low, pos - 1);
                quickSort(nums, pos + 1, high);
            }
        }

        private int findPos(int[] nums, int low, int high) {
            int val = nums[low];
            while (low < high) {
                while (low < high && val <= nums[high]) {
                    high--;
                }
                if (low < high) {
                    nums[low++] = nums[high];
                }
                while (low < high && val >= nums[low]) {
                    low++;
                }
                if (low < high) {
                    nums[high--] = nums[low];
                }
            }
            nums[low] = val;
            return low;
        }
    }
}
