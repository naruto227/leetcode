// source: https://leetcode-cn.com/problems/two-sum/
package sum.twoSum;

import util.ArrayUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 *  ‰»Î£∫[2,7,11,15]
 * Created by Michael Allan on 2019/8/10.
 */
public class TwoSum {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = ArrayUtil.stringToIntegerArray(line);
            line = in.readLine();
            int target = Integer.parseInt(line);
            int[] ret = new Solution().twoSum(nums, target);

            String out = ArrayUtil.integerArrayToString(ret);
            System.out.println(out);
        }
    }

}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                return new int[] {map.get(temp), i};
            }
            map.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }
}
