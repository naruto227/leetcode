package array.kthlargestelement;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Michael Allan on 2020/6/30.
 */
public class KthLargestNum {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        Arrays.sort(nums);
        return nums[len - k];
    }

    Random random = new Random();

    public int findKthLargest1(int[] nums, int k) {
        int index = k - 1;
        quickSelect(nums, 0, nums.length - 1, index);
        return nums[index];
    }

    private void quickSelect(int[] nums, int low, int high, int k) {
        int pos = findPos(nums, low, high);
        if (pos > k) {
            quickSelect(nums, low, pos - 1, k);
        } else if (pos < k) {
            quickSelect(nums, pos + 1, high, k);
        } else {
            return;
        }
    }

    /**
     * 降序
     *
     * @param nums
     * @param low
     * @param high
     * @return
     */
    private int findPos(int[] nums, int low, int high) {
        int i = random.nextInt(high - low + 1) + low;
        swap(nums, i, low);
        int val = nums[low];
        while (low < high) {
            while (low < high && nums[high] < val) {
                high--;
            }
            if (low < high) {
                nums[low++] = nums[high];
            }
            while (low < high && nums[low] > val) {
                low++;
            }
            if (low < high) {
                nums[high--] = nums[low];
            }
        }
        nums[low] = val;
        return low;
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
