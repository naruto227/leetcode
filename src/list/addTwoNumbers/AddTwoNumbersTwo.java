package list.addTwoNumbers;

import list.ListNode;
import util.ListNodeUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 445. Add Two Numbers II
 * You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Follow up:
 What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

 链接：https://leetcode-cn.com/problems/add-two-numbers-ii
 * Created by Michael Allan on 2020/4/14.
 */
public class AddTwoNumbersTwo {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
//        while ((line = in.readLine()) != null) {
            ListNode l1 = ListNodeUtil.stringToListNode("[5]");
//            line = in.readLine();
            ListNode l2 = ListNodeUtil.stringToListNode("[5]");
            System.out.println(l1);
            System.out.println(l2);
            ListNode ret = new AddTwoNumbersTwo().new Solution().addTwoNumbers(l1, l2);

            System.out.println(ret);
//        }
    }

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode p = reverseListNode(l1);
            ListNode q = reverseListNode(l2);
            ListNode dummyNode = new ListNode(-1);
            ListNode head = dummyNode;
            int cnt = 0;
            while (p != null || q != null) {
                int pVal = (p != null) ? p.val : 0;
                int qVal = (q != null) ? q.val : 0;
                int sum = pVal + qVal + cnt;
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
            return reverseListNode(dummyNode.next);
        }

        /**
         * 反转链表
         * @param listNode
         * @return
         */
        private ListNode reverseListNode(ListNode listNode) {
            ListNode prev = null;
            ListNode dummyNode = new ListNode(-1);
            dummyNode.next = listNode;
            ListNode cur = dummyNode.next;
            while (cur != null) {
                ListNode temp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = temp;
            }

            return prev;
        }
    }
}
