package list.reverseListNode;

import list.ListNode;
import util.ListNodeUtil;

/**
 * Created by Michael Allan on 2021/2/2.
 */
public class ReverseListNode {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        Solution solution = new Solution();
        ListNode head = ListNodeUtil.arrayToListNode(arr);
        System.out.println(head);
        ListNode res = solution.reverseList(head);
        System.out.println(res);
    }

    private static class Solution {
        // 双指针引用，3、4相当于走了两步
        public ListNode reverseList(ListNode head) {
            ListNode cur = head;
            ListNode prev = null;
            while (cur != null) {
                ListNode tmp = cur.next; // 1
                cur.next = prev; // 2
                prev = cur;  // 3
                cur = tmp;  // 4
            }
            return prev;
        }
        // 递归写法
        public ListNode reverseList1(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode res = reverseList1(head.next);
            head.next.next = head;
            head.next = null;
            return res;
        }
        // 局部反转，最优
        // 第3步相当于走一步操作，2、4可理解为仅修改引用
        public ListNode reverseLise2(ListNode head) {
            if (head == null) {
                return head;
            }
            ListNode cur = head;
            while (head.next != null) {
                ListNode tmp = head.next.next; // 1
                head.next.next = cur;  // 2
                cur = head.next;  // 3
                head.next = tmp;  // 4
            }
            return cur;
        }
    }
}
