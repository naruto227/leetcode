package array.searchrotatedsortedarray;

import util.ArrayUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 33. 搜索旋转排序数组
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 * Created by Michael Allan on 2020/4/27.
 */
public class SearchRotatedSortedArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        Solution solution = new SearchRotatedSortedArray().new Solution();
        while ((line = br.readLine()) != null) {
            int[] nums = ArrayUtil.stringToIntegerArray(line);
            int target = Integer.valueOf(br.readLine());
            int search = solution.search(nums, target);
            System.out.println(search);
        }
    }

    class Solution {
        public int search(int[] nums, int target) {
            if (nums.length == 0) {
                return -1;
            }
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] == target) {
                    return left;
                }
                if (nums[right] == target) {
                    return right;
                }
                int mid = (left + right) >>> 1;
                if (nums[mid] == target) {
                    return mid;
                }
                if (nums[mid] > nums[left]) {
                    if (nums[mid] > target && target > nums[left]) {
                        right = mid - 1;
                    }else {
                        left = mid;
                    }
                }else {
                    if (nums[mid] < target && target < nums[right]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
            }
            if(nums[left] == target) {
                return left;
            }
            return -1;
        }
    }
}
