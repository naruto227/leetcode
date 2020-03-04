package removeElement;

import util.ArrayUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.

 Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

 The order of elements can be changed. It doesn't matter what you leave beyond the new length.

 链接：https://leetcode-cn.com/problems/remove-element
 * Created by Michael Allan on 2020/1/27.
 */
public class RemoveElement {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line = br.readLine()) != null) {
            int[] nums = ArrayUtil.stringToIntegerArray(line);
            line = br.readLine();
            int val = Integer.parseInt(line);
            int len = new Solution().removeElement(nums, val);
            for (int i = 0; i < len; i++) {
                System.out.println(nums[i]);
            }
        }
    }

}

class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i++] = nums[j];
            }
        }
        return i;
    }
}
