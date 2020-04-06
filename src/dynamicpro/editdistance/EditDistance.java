package dynamicpro.editdistance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 72. Edit Distance
 * Created by Michael Allan on 2020/4/6.
 */
public class EditDistance {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            String word2 = br.readLine();
            int minDistance = new Solution().minDistance(line, word2);
            System.out.println(minDistance);
        }
    }

    static class Solution {
        public int minDistance(String word1, String word2) {
            int word1_len = word1.length();
            int word2_len = word2.length();
            int[][] dp = new int[word1_len + 1][word2_len + 1];

            for (int i = 0; i <= word2_len; i++) {
                dp[0][i] = i;
            }
            for (int i = 0; i <= word1_len; i++) {
                dp[i][0] = i;
            }

            char[] word1Chars = word1.toCharArray();
            char[] word2Chars = word2.toCharArray();

            for (int i = 0; i < word1_len; i++) {
                for (int j = 0; j < word2_len; j++) {
                    if (word1Chars[i] == word2Chars[j]) {
                        dp[i + 1][j + 1] = dp[i][j];
                        continue;
                    }
                    dp[i + 1][j + 1] = Math.min(Math.min(dp[i][j + 1], dp[i + 1][j]), dp[i][j]) + 1;
                }
            }
            return dp[word1_len][word2_len];
        }
    }
}
