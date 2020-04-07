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
}
