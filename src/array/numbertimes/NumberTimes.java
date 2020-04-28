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

        /**
         * 思路：简化版，一个数组中只有一个数字出现一次，其它数字出现两次，如何找这个出现一次的数字？
         * 所有数字做异或，相同为0，相异为1，所以最后剩下就是要找的数字。
         * 现在的问题是由两个出现一次的数字，可以知道全部做异或肯定不为0，假设为x。按照上面简化版的思路，
         * 如果能分两组，相同的数字出现在一组中，要找的数字出现在不同的组中，然后两组数组分别全部异或，就可以
         * 找到答案了。x != 0，所以x的二进制位中至少有一个位x(i)是1。
         * 所以可以这样分组：数字二进制位的第x(i)位是0的分一组，是1的分另一组。
         * @param nums
         * @return
         */
        public int[] singleNumbers1(int[] nums) {
            int temp = 0;
            for (int num : nums) {
                temp ^= num;
            }
            int div = 1;
            while ((div & temp) == 0) {
                div <<= 1;
            }
            int a = 0;
            int b = 0;
            for (int num : nums) {
                if((div & num) == 0) {
                    a ^= num;
                }else {
                    b ^= num;
                }
            }
            return new int[] {a, b};
        }
    }
}
