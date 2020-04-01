package string.maximumdepthvalidstr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 1111. Maximum Nesting Depth of Two Valid Parentheses Strings
 * 链接：https://leetcode-cn.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/
 * Created by Michael Allan on 2020/4/1.
 */
public class MaximumDepthValidStr {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            int[] arr = new Solution().maxDepthAfterSplit(line);
            System.out.println(Arrays.toString(arr));
        }
    }

    static class Solution {
        public int[] maxDepthAfterSplit(String seq) {
            int[] res = new int[seq.length()];
            int depth = 0;
            char[] chars = seq.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '(') {
                    depth++;
                    res[i] = depth % 2;
                }else {
                    res[i] = depth % 2;
                    depth--;
                }
            }
            return res;
        }
    }
}
