package array.majorityelement;

import util.ArrayUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Michael Allan on 2020/3/13.
 */
public class MajorityElement {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = ArrayUtil.stringToIntegerArray(line);
            int num = new Solution().majorityElement1(nums);
            System.out.println(num);
        }
    }

    static class Solution {
        public int majorityElement(int[] nums) {
            int checkNum = nums.length >> 1;
            Map<Integer, Integer> map = new HashMap<>();
            for(int num : nums) {
                if(map.containsKey(num)) {
                    int times = map.get(num) + 1;
                    if (times > checkNum) {
                        return num;
                    }
                    map.put(num, times);
                }else {
                    map.put(num, 1);
                }
            }
            return nums[0];
        }

        public int majorityElement1(int[] nums) {
            int candidate = 0;
            int count = 0;
            for (int num : nums) {
                if(count == 0) {
                    candidate = num;
                    count++;
                    continue;
                }
                count += (candidate == num) ? 1 : -1;
            }
            return candidate;
        }
    }
}
