package string.compressstring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 面试题 01.06. Compress String LCCI
 * Implement a method to perform basic string compression using the counts of repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the "compressed" string would not become smaller than the original string, your method should return the original string. You can assume the string has only uppercase and lowercase letters (a - z).

 链接：https://leetcode-cn.com/problems/compress-string-lcci
 * Created by Michael Allan on 2020/3/16.
 */
public class CompressString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line = br.readLine()) != null) {
            String res = new Solution().compressString(line);
            System.out.println(res);
        }
    }

    static class Solution {
        public String compressString(String S) {
            if(S.isEmpty()) {
                return S;
            }
            StringBuilder sb = new StringBuilder();
            char cur = S.charAt(0);
            int cnt = 1;
            // 使用S.toCharArray()转换为字符数组，比使用S.charAt(i)执行效率高
            for (int i = 1; i < S.length(); i++) {
                if(cur == S.charAt(i)) {
                    cnt++;
                } else {
                    sb.append(cur).append(cnt);
                    cur = S.charAt(i);
                    cnt = 1;
                }
            }
            // 存储最后的元素
            sb.append(cur).append(cnt);
            return sb.length() >= S.length() ? S : sb.toString();
        }

        public String compressString1(String S) {
            StringBuilder sb = new StringBuilder();
            int cnt = 1;
            for (int i = 0; i < S.length(); i++) {
                if(i == S.length() - 1) {
                    sb.append(S.charAt(i)).append(cnt);
                    break;
                }
                if(S.charAt(i) == S.charAt(i + 1)) { // 当前字母等于下一个字母
                    cnt++;
                }else {
                    sb.append(S.charAt(i)).append(cnt);
                    cnt = 1;
                }
            }
            if(sb.length() >= S.length()) {
                return S;
            }
            return sb.toString();
        }
    }
}
