package list.addTwoNumbers;

import list.ListNode;
import list.rmNode.RmEndNthNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode l1 = RmEndNthNode.stringToListNode(line);
            line = in.readLine();
            ListNode l2 = RmEndNthNode.stringToListNode(line);

            ListNode ret = new Solution().addTwoNumbers(l1, l2);

            String out = RmEndNthNode.listNodeToString(ret);

            System.out.println(out);
        }
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1;
        ListNode q = l2;
        ListNode dumpRoot = new ListNode(0);
        ListNode head = dumpRoot;
        int cnt = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = x + y + cnt;
            cnt = sum / 10;
            if (cnt > 0) {
                sum %= 10;
            }
            head.next = new ListNode(sum);
            head = head.next;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }
        if (cnt > 0) {
            head.next = new ListNode(cnt);
        }

        return dumpRoot.next;
    }

    public ListNode addTwoNumbersTwo(ListNode l1, ListNode l2) {
        ListNode p = l1;
        ListNode q = l2;
        ListNode dumpRoot = new ListNode(0);
        ListNode head = dumpRoot;
        int cnt = 0;
        while (p != null || q != null) {
            if (p != null && q != null) {
                int sum = p.val + q.val + cnt;
                cnt = sum / 10;
                if (cnt > 0) {
                    sum %= 10;
                }
                head.next = new ListNode(sum);
                head = head.next;
                p = p.next;
                q = q.next;
            } else {
                if (p != null) {
                    int sum = p.val + cnt;
                    cnt = sum / 10;
                    if (cnt > 0) {
                        sum %= 10;
                    }
                    head.next = new ListNode(sum);
                    head = head.next;
                    p = p.next;
                } else {
                    int sum = q.val + cnt;
                    cnt = sum / 10;
                    if (cnt > 0) {
                        sum %= 10;
                    }
                    head.next = new ListNode(sum);
                    head = head.next;
                    q = q.next;
                }
            }
        }
        if (cnt > 0) {
            head.next = new ListNode(cnt);
            head = head.next;
        }

        return dumpRoot.next;
    }
}
