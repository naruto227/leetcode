package list.mergeTwoSortedList;

import list.ListNode;
import util.ListNodeUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * Created by Michael Allan on 2020/2/3.
 */
public class MergeTwoSortedLists {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line = br.readLine()) != null) {
            ListNode l1 = ListNodeUtil.stringToListNode(line);
            line = br.readLine();
            ListNode l2 = ListNodeUtil.stringToListNode(line);
            ListNode listNode = new MergeTwoSortedLists().new Solution().mergeTwoLists(l1, l2);
            String listNodeToString = ListNodeUtil.listNodeToString(listNode);
            System.out.println(listNodeToString);
        }
    }

    class Solution {
        public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
            ListNode p = new ListNode(0);
            ListNode head = p;
            while(!(l1 == null || l2 == null)) {
                if(l1.val < l2.val) {
                    p.next = l1;
                    l1 = l1.next;
                }else {
                    p.next = l2;
                    l2 = l2.next;
                }
                p = p.next;
            }
            if(l1 == null) {
                p.next = l2;
            }else if(l2 == null) {
                p.next = l1;
            }
            return head.next;
        }

//        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//            if (l1 == null) {
//                return l2;
//            }
//            if (l2 == null) {
//                return l1;
//            }
//            if (l1.val < l2.val) {
//                l1.next = mergeTwoLists(l1.next, l2);
//                return l1;
//            } else {
//                l2.next = mergeTwoLists(l1, l2.next);
//                return l2;
//            }
//        }

        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode dummyHead = new ListNode(-1);
            ListNode head = dummyHead;
            while (!(l1 == null || l2 == null)) {
                if (l1.val < l2.val) {
                    head.next = l1;
                    l1 = l1.next;
                } else {
                    head.next = l2;
                    l2 = l2.next;
                }
                head = head.next;
            }
            head.next = l1 == null ? l2 : l1;
            return dummyHead.next;
        }
    }
}


