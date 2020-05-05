package tree.validatebst;

import tree.TreeNode;
import util.ArrayUtil;
import util.TreeUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 98. Validate Binary Search Tree
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree/
 * Created by Michael Allan on 2020/5/5.
 */
public class ValidateBST {
    public static void main(String[] args) throws IOException {
        Solution solution = new ValidateBST().new Solution();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            TreeNode treeNode = TreeUtil.createTree(ArrayUtil.stringToIntegerArray(line));
            boolean validBST = solution.isValidBST(treeNode);
            System.out.println(validBST);
        }
    }

    class Solution {
        public boolean isValidBST(TreeNode root) {
            return helper(root, null, null);
        }

        private boolean helper(TreeNode root, Integer lower, Integer upper) {
            if (root == null) {
                return true;
            }
            int val = root.val;
            if (lower != null && val <= lower) {
                return false;
            }
            if (upper != null && val >= upper) {
                return false;
            }
            return helper(root.left, lower, val) && helper(root.right, val, upper);
        }
    }
}
