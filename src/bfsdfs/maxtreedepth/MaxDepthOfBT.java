package bfsdfs.maxtreedepth;

import tree.TreeNode;

import java.util.LinkedList;

/**
 * Created by Michael Allan on 2020/7/28.
 */
public class MaxDepthOfBT {
    class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }

        public int maxDepth1(TreeNode root) {
            if (root == null) {
                return 0;
            }
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int ans = 0;
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
                }
                ans++;
            }

            return ans;
        }
    }
}
