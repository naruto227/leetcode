package competition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 给你一个整数 n，请你返回一个含 n 个字符的字符串，其中每种字符在该字符串中都恰好出现 奇数次 。

 返回的字符串必须只含小写英文字母。如果存在多个满足题目要求的字符串，则返回其中任意一个即可。
 输入：n = 4
 输出："pppz"
 解释："pppz" 是一个满足题目要求的字符串，因为 'p' 出现 3 次，且 'z' 出现 1 次。当然，还有很多其他字符串也满足题目要求，比如："ohhh" 和 "love"。

 输入：n = 2
 输出："xy"
 解释："xy" 是一个满足题目要求的字符串，因为 'x' 和 'y' 各出现 1 次。当然，还有很多其他字符串也满足题目要求，比如："ag" 和 "ur"。

 输入：n = 7
 输出："holasss"
 * Created by Michael Allan on 2020/3/8.
 */
public class OddNumberString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            String str = new Solution().generateTheString(Integer.valueOf(line));
            System.out.println(str);
        }
    }

    private static class Solution {
        public String generateTheString(int n) {
            StringBuilder sb = new StringBuilder();
            if(n % 2 == 0) {
                sb.append("a");
                for (int i = 0; i < n - 1; i++) {
                    sb.append("b");
                }
            }else {
                while (n-- != 0) {
                    sb.append("b");
                }
            }
            return sb.toString();
        }
    }
}
