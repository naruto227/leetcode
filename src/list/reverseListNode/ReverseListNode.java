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
        public ListNode reverseList(ListNode head) {
            ListNode cur = head;
            ListNode prev = null;
            while (cur != null) {
                ListNode tmp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = tmp;
            }
            return prev;
        }
    }
}
