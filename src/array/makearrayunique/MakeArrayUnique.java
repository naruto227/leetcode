package array.makearrayunique;

import util.ArrayUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 945. Minimum Increment to Make Array Unique
 * Given an array of integers A, a move consists of choosing any A[i], and incrementing it by 1.

 Return the least number of moves to make every value in A unique.

 链接：https://leetcode-cn.com/problems/minimum-increment-to-make-array-unique
 * Created by Michael Allan on 2020/3/22.
 */
public class MakeArrayUnique {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            int[] A = ArrayUtil.stringToIntegerArray(line);
            int moveNum = new Solution().minIncrementForUnique3(A);
            System.out.println(moveNum);
        }
    }

    static class Solution {
        /**
         * 运行超时了
         * @param A
         * @return
         */
        public int minIncrementForUnique(int[] A) {
            List<Integer> list = new ArrayList<>();
            Stack<Integer> stack = new Stack<>();
            for (int val : A) {
                if(list.contains(val)) {
                    stack.push(val);
                }else {
                    list.add(val);
                }
            }
            int moveNum = 0;
            while (!stack.empty()) {
                Integer pop = stack.pop();
                while (true) {
                    pop++;
                    moveNum++;
                    if (list.contains(pop)) {
                        continue;
                    } else {
                        list.add(pop);
                        break;
                    }
                }
            }
            return moveNum;
        }

        /**
         * 先排序，再依次遍历数组元素，若当前元素小于等于它前一个元素，则将其变为前一个数+1。
         * @param A
         * @return
         */
        public int minIncrementForUnique1(int[] A) {
            Arrays.sort(A);
            int moveNum = 0;
            for (int i = 1; i < A.length; i++) {
                if(A[i] <= A[i - 1]) {
                    int cur = A[i];
                    A[i] = A[i - 1] + 1;
                    moveNum += A[i] - cur;
                }
            }
            return moveNum;
        }

        /**
         * 计数排序
         * @param A
         * @return
         */
        public int minIncrementForUnique2(int[] A) {
            int moveNum = 0;
            int[] counter = new int[40001];
            int max = -1;
            int min = Integer.MAX_VALUE;
            for (int val : A) {
                counter[val]++;
                max = Math.max(max, val);
                min = Math.min(min, val);
            }

            for (int i = min; i <= max; i++) {
                if(counter[i] > 1) {
                    int remain = counter[i] - 1;
                    counter[i + 1] += remain;
                    moveNum += remain;
                }
            }

            int remain = counter[max + 1] - 1;
            moveNum += (remain + 1) * remain >> 1;
            return moveNum;
        }

        private int[] pos = new int[80000];

        /**
         * 线性探测法 + 路径压缩
         * @param A
         * @return
         */
        public int minIncrementForUnique3(int[] A) {
            Arrays.fill(pos, -1); // -1 表示空位
            int moveNum = 0;
            for (int val : A) {
                int pos = findPos(val);
                moveNum += pos - val;
            }
            return moveNum;
        }

        /**
         * 线性探测法 + 路径压缩
         * @param num
         * @return
         */
        private int findPos(int num) {
            int position = pos[num];
            if (position == -1) {
                pos[num] = num;
                return num;
            }
            position = findPos(pos[num] + 1);
            pos[num] = position;
            return position;
        }

        /**
         * 普通的线性探测法
         * @param num
         * @return
         */
        private int findPos1(int num) {
            int position = pos[num];
            if (position == -1) {
                pos[num] = num;
                return num;
            }
            position = findPos(num + 1);
            return position;
        }
    }
}
