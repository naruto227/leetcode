package normal.happynum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by Michael Allan on 2020/4/30.
 */
public class HappyNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        Solution solution = new HappyNumber().new Solution();
        while ((line = in.readLine()) != null) {
            Integer num = Integer.valueOf(line);
            double pow = Math.pow(num, 2);
            System.out.println(pow);
            boolean happy = solution.isHappy1(num);
            System.out.println(happy);
        }
    }

    class Solution {
        /**
         * 计算n的下一个数字，用一个集合保存已经记录过的值
         * @param n
         * @return
         */
        public boolean isHappy(int n) {
            if (n <= 0) {
                return false;
            }
            LinkedList<Integer> linkedList = new LinkedList<>();
            linkedList.offer(n);
            for (;;) {
                int num = linkedList.getLast();
                System.out.print(num + "\t");
                if (num == 1) {
                    return true;
                }
                int res = 0;
                while (num != 0) {
                    res += (int)Math.pow(num % 10, 2);
                    num /= 10;
                }
                if(linkedList.contains(res)) {
                    return false;
                }
                linkedList.offer(res);
            }
        }

        /**
         * 弗洛伊德循环查找算法，快跑者、慢跑者，在一个循环内，快跑者和慢跑者必然会相遇
         * @param n
         * @return
         */
        public boolean isHappy1(int n) {
            int slowRunner = n;
            int fastRunner = getNext(n);
            while (fastRunner != 1 && slowRunner != fastRunner) {
                slowRunner = getNext(slowRunner);
                fastRunner = getNext(getNext(fastRunner));
            }

            return fastRunner == 1;
        }

        private int getNext(int n) {
            int totalSum = 0;
            while (n != 0) {
                int temp = n % 10;
                totalSum += temp * temp;
                n /= 10;
            }
            return totalSum;
        }
        // 如果会进入循环，一定会生成这几个数字。所以用硬编码的方式
        private Set<Integer> hashSet = new HashSet<>(Arrays.asList(4, 16, 37, 58, 89, 145, 42, 20));
        //4	16	37	58	89	145	42	20
        public boolean isHappy2(int n) {
            while (n != 1 && !hashSet.contains(n)) {
                n = getNext(n);
            }
            return n == 1;
        }
    }
}
