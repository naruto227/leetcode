package util;

import tree.TreeNode;

/**
 * Created by Michael Allan on 2020/3/10.
 */
public class TreeUtil {

    public static TreeNode createTree(int[] arr, int index) {
        TreeNode root = null;
        if(index < arr.length) {
            int value = arr[index];
            root = new TreeNode(value);
            root.left = createTree(arr, 2 * index + 1);
            root.right = createTree(arr, 2 * index + 2);
        }
        return root;
    }
}
