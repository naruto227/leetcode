package hash.firstmissingpositive;

/**
 * 41. First Missing Positive
 * 同268
 * Created by Michael Allan on 2020/6/27.
 */
public class FirstMissingPositive {
    class Solution {
        public int firstMissingPositive(int[] nums) {
            int len = nums.length;
            for(int i = 0; i < len; i++) {
                if(nums[i] <= 0) {
                    nums[i] = len + 1;
                }
            }

            for(int i = 0; i < len; i++) {
                int index = Math.abs(nums[i]);
                if(index <= len) {
                    nums[index - 1] = -Math.abs(nums[index - 1]);
                }
            }

            for(int i = 0; i < len; i++) {
                if(nums[i] > 0) {
                    return i + 1;
                }
            }

            return len + 1;
        }
    }
}
