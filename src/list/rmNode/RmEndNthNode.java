// source: https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
package list.rmNode;

import list.ListNode;
import util.ListNodeUtil;

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
            ListNode head = ListNodeUtil.stringToListNode(line);
            line = in.readLine();
            int n = Integer.parseInt(line);

            ListNode ret = new Solution().removeNthFromEnd(head, n);

            String out = ListNodeUtil.listNodeToString(ret);
            System.out.println(out);
        }
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
