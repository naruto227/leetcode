package string.reversewords;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string/
 * Created by Michael Allan on 2020/4/10.
 */
public class ReverseWords {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {

        }
    }

    static class Solution {
        public String reverseWords(String s) {
            if (s == null || s.trim().length() == 0) {
                return "";
            }
            s = s.trim();
            String[] split = s.split(" ");
            StringBuilder sb = new StringBuilder();
            for (int i = split.length - 1; i > -1; i--) {
                if (!split[i].isEmpty()) {
                    sb.append(split[i]).append(" ");
                }
                // System.out.println(split[i] + "\t" + split[i].length());
            }

            return sb.substring(0, sb.lastIndexOf(" ")).toString();
        }
    }
}
