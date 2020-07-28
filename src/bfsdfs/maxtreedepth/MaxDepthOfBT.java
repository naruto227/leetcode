package bfsdfs.maxtreedepth;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.Stack;

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

        public int maxDepth2(TreeNode root) {
            if (root == null)
                return 0;
            //stack记录的是节点，而level中的元素和stack中的元素
            //是同时入栈同时出栈，并且level记录的是节点在第几层
            Stack<TreeNode> stack = new Stack<>();
            Stack<Integer> level = new Stack<>();
            stack.push(root);
            level.push(1);
            int max = 0;
            while (!stack.isEmpty()) {
                //stack中的元素和level中的元素同时出栈
                TreeNode node = stack.pop();
                int temp = level.pop();
                max = Math.max(temp, max);
                if (node.left != null) {
                    //同时入栈
                    stack.push(node.left);
                    level.push(temp + 1);
                }
                if (node.right != null) {
                    //同时入栈
                    stack.push(node.right);
                    level.push(temp + 1);
                }
            }
            return max;
        }
    }
}
