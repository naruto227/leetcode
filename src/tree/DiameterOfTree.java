package tree;


import util.ArrayUtil;
import util.TreeUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [1,2,3,4,5]
 * Created by Michael Allan on 2020/3/10.
 */
public class DiameterOfTree {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            int[] arr = ArrayUtil.stringToIntegerArray(line);
            TreeNode tree = TreeUtil.createTree(arr, 0);
            int len = Solution.diameterOfBinaryTree(tree);
            System.out.println(len);
        }

    }

    private static class Solution {
        static int len = 0;
        public static int diameterOfBinaryTree(TreeNode root) {
            if (root != null) {
                getTreeLen(root);
                return len;
            }
            return 0;
        }

        private static int getTreeLen(TreeNode root) {
            if (root != null) {
                int left = getTreeLen(root.left);
                int right = getTreeLen(root.right);
                if (left + right > len) {
                    len = left + right;
                }
                return Math.max(left, right) + 1;
            }
            return 0;
        }
    }
}
