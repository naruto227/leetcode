package LinkedList.deletenode;

import LinkedList.ListNode;

/**
 * 203. Remove Linked List Elements
 * 链接：https://leetcode-cn.com/problems/remove-linked-list-elements/
 * Created by Michael Allan on 2020/4/7.
 */
public class DeleteNode {
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        if(head == null) {
            return head;
        }
        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = prev.next.next;
                delNode.next = null;
            }else {
                prev = prev.next;
            }
        }

        return head;
    }

    public ListNode removeElements1(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;

        while (pre.next != null) {
            if (pre.next.val == val) {
                ListNode delNode = pre.next;
                pre.next = pre.next.next;
                delNode.next = null;
            }else {
                pre = pre.next;
            }
        }

        return dummyHead.next;
    }
}
