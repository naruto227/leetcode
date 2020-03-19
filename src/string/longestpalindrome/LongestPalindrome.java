package string.longestpalindrome;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 409. Longest Palindrome
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

 This is case sensitive, for example "Aa" is not considered a palindrome here.
 * 链接：https://leetcode-cn.com/problems/longest-palindrome/
 * Created by Michael Allan on 2020/3/19.
 */
public class LongestPalindrome {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            int res = new Solution().longestPalindrome(line);
            System.out.println(res);
        }
    }

    static class Solution {
        public int longestPalindrome(String s) {
            int sum = 0;
            boolean hasOne = false;
            int[] chars_count = count(s);
            for (int num : chars_count) {
                if (num == 1 && !hasOne) {
                    hasOne = true;
                }else {
                    if(num > 1) {
                        if(num % 2 == 0) {
                            sum += num;
                        }else {
                            sum += (num - 1);
                            if (!hasOne) {
                                hasOne = true;
                            }
                        }
                    }
                }
            }
            if(hasOne) {
                sum += 1;
            }
            return sum;
        }

        private int[] count(String s) {
            int[] counter = new int[58];
            char[] chars = s.toCharArray();
            for (char c : chars) {
                counter['z' - c]++;
            }
            return counter;
        }
    }
}
