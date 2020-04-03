package string.strtointeger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 8. String to Integer (atoi)
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi/
 * Created by Michael Allan on 2020/4/3.
 */
public class StringToInteger {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            int atoi = new Solution().myAtoi(line);
            System.out.println(atoi);
        }
    }

    static class Solution {
        public int myAtoi(String str) {
            char[] chars = str.toCharArray();
            int L = str.length();
            int idx = 0;
            // 字符串为空的场景
            while (idx < L && chars[idx] == ' ') {
                idx++;
            }
            // 字符串为空及全为空格情形
            if (idx == L) {
                //去掉前导空格以后到了末尾了
                return 0;
            }
            boolean negative = false;
            if (chars[idx] == '-') {
                negative = true;
            }
            if (chars[idx] == '+' || chars[idx] == '-') {
                idx++;
            }
            int res = 0;
            // 判断是否为数字可以调用API：Character.isDigit
            while (idx < L && isDigit(chars[idx])) {
                int digit = chars[idx] - '0';
                if (res > (Integer.MAX_VALUE - digit) / 10) {
                    return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                res = res * 10 + digit;
                idx++;
            }

            return negative ? -res : res;
        }

        private boolean isDigit(char c) {
            return c >= '0' && c <= '9';
        }
    }
}
