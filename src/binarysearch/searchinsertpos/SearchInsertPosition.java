package binarysearch.searchinsertpos;

import util.ArrayUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

 You may assume no duplicates in the array.

 链接：https://leetcode-cn.com/problems/search-insert-position
 * Created by Michael Allan on 2020/1/9.
 */
public class SearchInsertPosition {

    public static void main(String[] args) throws IOException {
        System.out.println(5/2);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = ArrayUtil.stringToIntegerArray(line);
            line = in.readLine();
            int target = Integer.parseInt(line);

            int ret = new Solution().searchInsert(nums, target);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }

    static class Solution {
        public int searchInsert(int[] nums, int target) {
            if(target <= nums[0]) {
                return 0;
            }
            if(target > nums[nums.length - 1]) {
                return nums.length;
            }
            int index = 1;
            for (int i = 1; i < nums.length; i++) {
                if(target <= nums[i]) {
                    index = i;
                    break;
                }
            }
            int len = nums.length - 1;
            int middle = len >> 1;
            return index;
        }
    }
}



