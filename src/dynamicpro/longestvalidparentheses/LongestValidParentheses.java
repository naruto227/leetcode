package dynamicpro.longestvalidparentheses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Michael Allan on 2020/7/4.
 */
public class LongestValidParentheses {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        LongestValidParentheses solution = new LongestValidParentheses();
        while((line = br.readLine()) != null) {
            int res = solution.longestValidParentheses(line);
            System.out.println(res);
        }
    }

    public int longestValidParentheses(String s) {
        int ans = 0;
        int n = s.length();
        char[] chars = s.toCharArray();
        int[] dp = new int[n + 1];
        for (int i = 1; i < n; i++) {
            if(chars[i] == ')' && (i - dp[i - 1] - 1) >= 0 && chars[i - dp[i - 1] - 1] == '(') {
                dp[i] = 2 + dp[i - 1] + ((i - dp[i - 1] - 2) >= 0 ? dp[i - dp[i - 1] - 2] : 0);
                ans = Math.max(ans, dp[i]);
            }
        }

        return ans;
    }
}
