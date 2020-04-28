package array.numbertimes;

import util.ArrayUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 数组中数字出现的次数
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
 *
 * Created by Michael Allan on 2020/4/28.
 */
public class NumberTimes {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        Solution solution = new NumberTimes().new Solution();
        while ((line = br.readLine()) != null) {
            int[] nums = ArrayUtil.stringToIntegerArray(line);
            int[] singleNumbers = solution.singleNumbers(nums);
            System.out.println(ArrayUtil.integerArrayToString(singleNumbers));
        }
    }


    class Solution {
        public int[] singleNumbers(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                if (map.containsKey(num)) {
                    map.put(num, map.get(num) + 1);
                }else {
                    map.put(num, 1);
                }
            }
            Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
            int[] res = new int[2];
            int i = 0;
            for (Map.Entry<Integer, Integer> entry : entrySet) {
                if(entry.getValue() == 1) {
                    res[i++] = entry.getKey();
                }
            }
            return res;
        }
    }
}
