package array.continuoussequence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 试题57 - II. 和为s的连续正数序列
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。

 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
 * Created by Michael Allan on 2020/3/6.
 */
public class ContinuousSequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            int[][] res = new Solution().findContinuousSequence(Integer.valueOf(line));
            String deepToString = Arrays.deepToString(res);
            System.out.println(deepToString);
        }
    }
    private static class Solution {
        public int[][] findContinuousSequence(int target) {
            int temp = (target + 1) >> 1;
            Deque<int[]> deque = new ArrayDeque<>();
            int start = 1;
            int end = start;
            while (start < temp) {
                int sum = start;
                end = start + 1;
                while (sum < target) {
                    sum += end;
                    if (sum == target) {
                        deque.add(new int[] { start, end });
                        break;
                    }
                    end++;
                }
                start++;
            }

            int[][] res = new int[deque.size()][];
            int index = 0;
            while (!deque.isEmpty()) {
                int[] poll = deque.poll();
                int len = poll[1] - poll[0] + 1;
                int[] arr = new int[len];
                for (int j = 0; j < len; j++) {
                    arr[j] = poll[0] + j;
                }
                res[index++] = arr;
            }

            return res;
        }
    }

}
