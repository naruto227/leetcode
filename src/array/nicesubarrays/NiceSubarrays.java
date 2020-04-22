package array.nicesubarrays;

import util.ArrayUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 1248. Count Number of Nice Subarrays
 * 链接：https://leetcode-cn.com/problems/count-number-of-nice-subarrays/
 * Created by Michael Allan on 2020/4/21.
 */
public class NiceSubarrays {
    public static void main(String[] args) throws IOException {
        Solution solution = new NiceSubarrays().new Solution();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            int[] nums = ArrayUtil.stringToIntegerArray(line);
            int k = Integer.valueOf(br.readLine());
            int numberOfSubarrays = solution.numberOfSubarrays(nums, k);
            System.out.println(numberOfSubarrays);
        }
    }

    class Solution {
        /**
         * 数学法。统计所有的奇数，将下标记录到数组odd中，[ odd[i], odd[i + k - 1] ]，从 odd[i - 1] 到 odd[i]
         * 中间为偶数，odd[i + k - 1] 到 odd[i + k]之间也是偶数，因此，可以用数学计算出结果。
         * (odd[i]−odd[i−1])∗(odd[i+k]−odd[i+k−1])，注意边界的处理
         * @param nums
         * @param k
         * @return
         */
        public int numberOfSubarrays(int[] nums, int k) {
            int len = nums.length;
            int[] odd = new int[len + 2];
            int cnt = 0;
            for (int i = 0; i < len; i++) {
                if ((nums[i] & 1) == 1) {
                    odd[++cnt] = i;
                }
            }
            odd[0] = -1;
            odd[++cnt] = len;
            int sum = 0;
            for (int i = 1; i + k <= cnt; i++) {
                sum += (odd[i] - odd[i - 1]) * (odd[i + k] - odd[i + k - 1]);
            }
            return sum;
        }

        public int numberOfSubarrays1(int[] nums, int k) {

            for (int i = 0; i < nums.length; i++) {
                nums[i] = (nums[i] & 1) == 1 ? 1 : 0;
            }

            int res = 0;
            // 定义sum为nums[0:i]数据范围的前缀和
            int sum = 0;
            // 存储sum出现的次数。key为前缀和sum，value为次数
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            // sum = nums[0:i]; 连续子数组出现k个奇数的次数 = 前缀和（sum - k）出现的次数
            for (int i = 0; i < nums.length; i++) {
                // 由于前面的预处理已经将nums的值变为了0、1，sum表示已经出现过多少个奇数！
                sum += nums[i];
                if (map.containsKey(sum - k)) {
                    res += map.get(sum - k);
                }
                if (map.containsKey(sum)) {
                    map.put(sum, map.get(sum) + 1);
                } else {
                    map.put(sum, 1);
                }
            }
            return res;
        }
    }
}
