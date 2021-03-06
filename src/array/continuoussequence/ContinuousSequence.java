package array.continuoussequence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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
            int[][] res = new Solution().findContinuousSequence2(Integer.valueOf(line));
            String deepToString = Arrays.deepToString(res);
            System.out.println(deepToString);
        }
    }
    private static class Solution {
        /**
         * 暴力：遍历
         * @param target
         * @return
         */
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

        /**
         * 滑动窗口法
         * @param target
         * @return
         */
        public int[][] findContinuousSequence1(int target) {
            List<int[]> list = new ArrayList<>();
            int sum = 1;
            int left = 1;
            int right = 2;
            while (left < (target + 1) >> 1) {
                if (sum < target) {
                    sum += right;
                    right++;
                }else if (sum > target) {
                    sum -= left;
                    left++;
                }else {
                    int[] arr = new int[right - left];
                    for (int i = 0; i < arr.length; i++) {
                        arr[i] = i + left;
                    }
                    list.add(arr);
                    sum -= (2 * left + 1);
                    left += 2;
//                    sum -= left;
//                    left++;
                }
            }
            return list.toArray(new int[list.size()][]);
        }

        /**
         * 双指针法
         * @param target
         * @return
         */
        public int[][] findContinuousSequence2(int target) {
            List<int[]> list = new ArrayList<>();
            int low = 1;
            int high = 2;
            while (low < high) {
                int sum = (low + high) * (high - low + 1) / 2;
                if(sum < target) {
                    high++;
                }else if (sum > target) {
                    low++;
                }else {
                    int[] arr = new int[high - low + 1];
                    for (int i = 0; i < arr.length; i++) {
                        arr[i] = i + low;
                    }
                    list.add(arr);
                    sum -= low;
                    low++;
                }
            }
            return list.toArray(new int[list.size()][]);
        }

        /**
         * 听说很快，记录一下
         * @param target
         * @return
         */
        public int[][] findContinuousSequence3(int target) {

            List<int[]> result = new ArrayList<>();
            int i = 1;

            while(target>0)
            {
                target -= i++;
                if(target>0 && target%i == 0)
                {
                    int[] array = new int[i];
                    for(int k = target/i, j = 0; k < target/i+i; k++,j++)
                    {
                        array[j] = k;
                    }
                    result.add(array);
                }
            }
            Collections.reverse(result);
            return result.toArray(new int[0][]);
        }

    }

}
