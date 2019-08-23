// source: https://leetcode-cn.com/problems/palindrome-number/
package integer.palindromeNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 回文数
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

 * Created by Michael Allan on 2019/8/23.
 */
public class PalindromeNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int x = Integer.parseInt(line);
            boolean ret = new Solution().isPalindrome(x);
            String out = booleanToString(ret);

            System.out.println(out);
        }
    }

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }
}

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }

        return x == rev || x == rev / 10;
    }
}