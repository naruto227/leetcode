// source: https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
package list.rmNode;

import list.ListNode;
import sum.twoSum.TwoSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [1,2,3,4,5]
 * Created by Michael Allan on 2019/8/12.
 */
public class RmEndNthNode {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode head = stringToListNode(line);
            line = in.readLine();
            int n = Integer.parseInt(line);

            ListNode ret = new Solution().removeNthFromEnd(head, n);

            String out = listNodeToString(ret);
            System.out.println(out);
        }
    }

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = TwoSum.stringToIntegerArray(input);
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

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode front = head;
        ListNode back = head;

        for (int i = 0; i < n; i++) {
            front = front.next;
            if (front == null) {
                return head.next;
            }
        }
        while (front.next != null) {
            front = front.next;
            back = back.next;
        }
        back.next = back.next.next;
        return head;
    }
}
