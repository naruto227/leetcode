package bfsdfs.generateparentheses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * BFS或DFS，按照某种规则搜索可能解。使用已有数据信息，构造结点及二叉树
 * 该问题还有几种解法：做加法的DFS，BFS，及动态规划的解法，留待后续补充
 * 参考题解：https://leetcode-cn.com/problems/generate-parentheses/solution/hui-su-suan-fa-by-liweiwei1419/
 * 链接：https://leetcode-cn.com/problems/generate-parentheses/
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
        }
    }
    static class Solution {
        // 做减法的优先搜索
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            // 初始有n个左括号，n个右括号，开始做深度搜索
            dfs("", n, n, res);
            return res;
        }

        /**
         *
         * @param curStr 保存当前递归的结果
         * @param left 剩于的左括号数
         * @param right 剩余的右括号数
         * @param res 结果集
         */
        private void dfs(String curStr, int left, int right, List<String> res) {
            // 因为每一次尝试，都使用新的字符串变量，所以无需回溯
            // 在递归终止的时候，直接把它添加到结果集即可
            if (left == 0 && right == 0) {
                res.add(curStr);
                return;
            }
            // 剪枝。剩于的左括号数 > 剩余的右括号数，说明右括号先用了，会产生如：())……，成不了正确的括号
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
