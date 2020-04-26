package util;

import list.ListNode;

/**
 * Created by Michael Allan on 2020/2/3.
 */
public class ListNodeUtil {
    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = ArrayUtil.stringToIntegerArray(input);
        // Now convert that list into linked list
        return arrayToListNode(nodeValues);
    }

    public static ListNode arrayToListNode(int[] nodeValues) {
        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for (int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }

        return "[" + result.substring(0, result.length() - 2) + "]";
    }
}
