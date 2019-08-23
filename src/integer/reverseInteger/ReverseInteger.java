// source: https://leetcode-cn.com/problems/reverse-integer/
package integer.reverseInteger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

 * Created by Michael Allan on 2019/8/21.
 */
public class ReverseInteger {
    public static void main(String[] args) throws IOException {
        System.out.println(Integer.MAX_VALUE + "\n" + Integer.MIN_VALUE); // 2147483647  -2147483648
        System.out.println(-2 / 10); // 0
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int x = Integer.parseInt(line);
            int ret = new Solution().reverse(x);

            String out = String.valueOf(ret);

            System.out.println(out);
        }
    }
}

class Solution {
    public int reverse(int x) {
        int sign = 1;
        if (x < 0) {
            sign = -1;
            x = Math.abs(x);
        }
        long sum = 0;
        while (x != 0) {
            sum = sum * 10 + x % 10;
            x /= 10;
        }
        sum *= sign;
        if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE) {
            return 0;
        }else {
            return (int) sum;
        }
    }

    public int reverse2(int x) {
        int sum = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (sum > Integer.MAX_VALUE / 10) {
                return 0;
            }
            if (sum < Integer.MIN_VALUE / 10) {
                return 0;
            }
            sum = sum * 10 + pop;
        }
        return sum;
    }
}
