package LinkedList.mergeksortedlists;

import list.ListNode;
import util.ListNodeUtil;

/**
 * 23. Merge k Sorted Lists
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists/
 * Created by Michael Allan on 2020/4/26.
 */
public class MergekSortedLists {
    public static void main(String[] args) {
        int[][] nums = {{},{-1,5,11},{},{6,10}};
        ListNode[] lists = new ListNode[nums.length];
        for (int i = 0; i < nums.length; i++) {
            lists[i] = ListNodeUtil.arrayToListNode(nums[i]);
//            System.out.println(lists[i]);
        }

        Solution solution = new MergekSortedLists().new Solution();
        ListNode listNode = solution.mergeKLists(lists);
        System.out.println(listNode);
    }

    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            int len = lists.length;
            if (len == 0) {
                return null;
            }
            int first = 0;
            int last = len - 1;
            while (last > 0) {
                if (first >= last) {
                    first = 0;
                    continue;
                }
                lists[first] = mergeTwoLists(lists[first], lists[last]);
                first++;
                last--;
            }
            return lists[last];
        }

        private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            } else if (l2 == null) {
                return l1;
            }
            if (l1.val < l2.val) {
                l1.next = mergeTwoLists(l1.next, l2);
                return l1;
            } else {
                l2.next = mergeTwoLists(l1, l2.next);
                return l2;
            }
        }
    }
}
