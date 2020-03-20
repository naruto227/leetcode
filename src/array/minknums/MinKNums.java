package array.minknums;

import util.ArrayUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 面试题40. 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * 链接：https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 * Created by Michael Allan on 2020/3/20.
 */
public class MinKNums {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line = br.readLine()) != null) {
            int[] arr = ArrayUtil.stringToIntegerArray(line);
            Integer k = Integer.valueOf(br.readLine());
            int[] res = new Solution().getLeastNumbers2(arr, k);
            System.out.println(Arrays.toString(res));
        }
    }

    static class Solution {
        /**
         * 使用JDK提供的排序
         * @param arr
         * @param k
         * @return
         */
        public int[] getLeastNumbers(int[] arr, int k) {
            Arrays.sort(arr);
            int[] dest = new int[k];
            System.arraycopy(arr, 0, dest, 0 , k);
            return dest;
        }

        public int[] getLeastNumbers1(int[] arr, int k) {
            Arrays.sort(arr);
            int[] dest = new int[k];
            System.arraycopy(arr, 0, dest, 0 , k);
            return dest;
        }

        public int[] getLeastNumbers2(int[] arr, int k) {
            if(k == 0) return new int[0];
            // Integer为升序，小根堆，堆顶为最小的元素.小根堆找的是最大k值。想要取到最小值，先将元素取反
            Queue<Integer> queue = new PriorityQueue<>(k);
            // 添加 comparator 参数使其变成最大堆
            Queue<Integer> queue2 = new PriorityQueue<>(k, (i1, i2) -> Integer.compare(i2, i1));
            for (int i = 0; i < k; i++)
                queue.add(-arr[i]);
            for (int i = k; i < arr.length; i++) {
                if(-arr[i] > queue.peek()) {
                    queue.poll();
                    queue.add(-arr[i]);
                }
            }

            int[] dest = new int[k];
            Iterator<Integer> iterator = queue.iterator();
            int i = 0;
            while (iterator.hasNext()) {
                dest[i++] = -iterator.next();
            }
            return dest;
        }
    }
}
