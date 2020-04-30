package normal.happynum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

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
            boolean happy = solution.isHappy(num);
            System.out.println(happy);
        }
    }

    class Solution {
        public boolean isHappy(int n) {
            if (n <= 0) {
                return false;
            }
            LinkedList<Integer> linkedList = new LinkedList<>();
            linkedList.offer(n);
            for (;;) {
                int num = linkedList.getLast();
//                System.out.print(num + "\t");
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
    }
}
