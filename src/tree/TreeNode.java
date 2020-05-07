package tree;

/**
 * Created by Michael Allan on 2020/3/10.
 */
//Definition for a binary tree node.
public class TreeNode {
      public int val;
      public TreeNode left;
      public TreeNode right;
      public TreeNode(int x) { val = x; }

      public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
      }
}
