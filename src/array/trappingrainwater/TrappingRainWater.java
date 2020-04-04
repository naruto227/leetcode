package array.trappingrainwater;

import util.ArrayUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 42. Trapping Rain Water
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water/
 * Created by Michael Allan on 2020/4/4.
 */
public class TrappingRainWater {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            int trap = new Solution().trap(ArrayUtil.stringToIntegerArray(line));
            System.out.println(trap);
        }
    }

    static class Solution {
        public int trap(int[] height) {
            int res = 0;
            int len = height.length;
            int start = 0;
//            while (height[start] == 0) {
//                start++;
//            }

            while (start < len - 2) {
                int end = start + 1;
                // 从start位置开始找比height[start]更高的
                boolean find_higher = false;
                for (int i = end; i < len; i++) {
                    if (height[i] > height[start]) {
                        end = i;
                        find_higher = true;
                        break; // 跳出内部for循环
                    }
                    // 没有找到则使用第二高的
                    end = height[end] >= height[i] ? end : i;
                }

                if (find_higher) {
                    res += (end - start - 1) * height[start];
                    for (int i = start + 1; i < end; i++) {
                        res -= height[i];
                    }
                }else {
                    res += (end - start - 1) * height[end];
                    for (int i = start + 1; i < end; i++) {
                        res -= height[i];
                    }
                }
                // 从下一个位置开始找区间
                start = end;
            }
            return res;
        }
    }
}
