package string.commdivisorstr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1071
 * Greatest Common Divisor of Strings
 *For strings S and T, we say "T divides S" if and only if S = T + ... + T  (T concatenated with itself 1 or more times)

 Return the largest string X such that X divides str1 and X divides str2.

 链接：https://leetcode-cn.com/problems/greatest-common-divisor-of-strings
 * Created by Michael Allan on 2020/3/12.
 */
public class GreatestCommonDivisorOfStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String str1 = line;
            String str2 = in.readLine();
            String res = new Solution().gcdOfStrings(str1, str2);
            System.out.println(res);
        }
    }

    static class Solution {
        public String gcdOfStrings(String str1, String str2) {
            if(!str1.concat(str2).equals(str2.concat(str1))) {
                return "";
            }
            return str1.substring(0, gcd(str1.length(), str2.length()));
        }

        private int gcd(int a, int b) {
            return b == 0 ? a : gcd(b, a % b);
        }

    }
}
