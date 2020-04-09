package bfsdfs.generateparentheses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Michael Allan on 2020/4/9.
 */
public class GenerateParentheses {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            List<String> parenthesis = new Solution().generateParenthesis(Integer.valueOf(line));
            System.out.println(parenthesis);
            System.out.println(Arrays.toString(parenthesis.toArray()));
//            for (String str : parenthesis) {
//                System.out.println(str);
//            }
        }
    }
    static class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            dfs("", n, n, res);
            return res;
        }

        private void dfs(String curStr, int left, int right, List<String> res) {
            if (left == 0 && right == 0) {
                res.add(curStr);
                return;
            }
            // 剪枝
            if (left > right) {
                return;
            }
            if (left > 0) {
                dfs(curStr + "(", left - 1, right, res);
            }
            if(right > 0) {
                dfs(curStr + ")", left, right - 1, res);
            }
        }
    }
}
