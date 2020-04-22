package tree.rightsideview;

import tree.TreeNode;
import util.ArrayUtil;
import util.TreeUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/**
 * 199. Binary Tree Right Side View
 * 链接：https://leetcode-cn.com/problems/binary-tree-right-side-view/
 * Created by Michael Allan on 2020/4/22.
 */
public class RightSideView {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        Solution solution = new RightSideView().new Solution();
        while ((line = br.readLine()) != null) {
            int[] arr = ArrayUtil.stringToIntegerArray(line);
            TreeNode treeNode = TreeUtil.createTree(arr, 0);
            List<Integer> rightSideView = solution.rightSideView(treeNode);
            System.out.println(rightSideView);
        }
    }

    class Solution {
        /**
         * 二叉树的右视图，BFS解法
         * @param root
         * @return
         */
        public List<Integer> rightSideView(TreeNode root) {
            LinkedList<Integer> res = new LinkedList<>();
            if (root == null) {
                return res;
            }
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode treeNode = queue.poll();
                    if (treeNode.left != null) {
                        queue.offer(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        queue.offer(treeNode.right);
                    }
                    if (i == size - 1) {
                        res.offer(treeNode.val);
                    }
                }
            }
            return res;
        }
    }
}

