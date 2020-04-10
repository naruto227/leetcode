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
        Solution solution = new Solution();
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

        public String reverseWords1(String s) {
            // 除去开头和末尾的空白字符
            s = s.trim();
            // 正则匹配连续的空白字符作为分隔符分割
            String[] split = s.split("\\s+");
            StringBuilder sb = new StringBuilder();
            for (int i = split.length - 1; i > -1; i--) {
                sb.append(split[i]).append(" ");
            }

            return sb.substring(0, sb.lastIndexOf(" ")).toString();
//            List<String> wordList = Arrays.asList(split);
//            Collections.reverse(wordList);
//
//            return String.join(" ", wordList);

        }

    }
}
