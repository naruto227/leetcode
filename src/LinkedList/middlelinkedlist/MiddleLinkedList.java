package LinkedList.middlelinkedlist;

import LinkedList.ListNode;

/**
 * 876. Middle of the Linked List
 * Given a non-empty, singly linked list with head node head, return a middle node of linked list.

 If there are two middle nodes, return the second middle node.

 链接：https://leetcode-cn.com/problems/middle-of-the-linked-list
 * Created by Michael Allan on 2020/3/23.
 */
public class MiddleLinkedList {
    public static void main(String[] args) {

    }

    static class Solution {
        public ListNode middleNode(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (true) {
                if (fast.next == null)
                    break;
                if (fast.next.next == null) {
                    slow = slow.next;
                    break;
                }
                slow = slow.next;
                fast = fast.next.next;
            }

            return slow;
        }
    }
}
