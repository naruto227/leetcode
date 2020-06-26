package LinkedList.removeduplicatenode;

import list.ListNode;
import util.ListNodeUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Michael Allan on 2020/6/26.
 */
public class RemoveDuplicateNode {
    public static void main(String[] args) throws IOException {
        RemoveDuplicateNode removeDN = new RemoveDuplicateNode();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            ListNode head = ListNodeUtil.stringToListNode(line);
            ListNode node = removeDN.removeDuplicateNodes1(head);
            System.out.println(node);
        }
    }

    public ListNode removeDuplicateNodes(ListNode head) {
        Set<Integer> set = new HashSet<>();
        ListNode dummyHead = new ListNode(0);
        ListNode newHead = dummyHead;
        while(head != null) {
            if (!set.contains(head.val)) {
                dummyHead.next = head;
                set.add(head.val);
                dummyHead = dummyHead.next;
            }
            head = head.next;
        }
        dummyHead.next = null;
        return newHead.next;
    }

    public ListNode removeDuplicateNodes1(ListNode head) {
        if(head == null) {
            return head;
        }
        Set<Integer> set = new HashSet<>();
        set.add(head.val);
        ListNode dummyHead = head;
        while(dummyHead.next != null) {
            // 当前待删除节点
            ListNode cur = dummyHead.next;
            if (set.add(cur.val)) {
                dummyHead = dummyHead.next;
            }else {
                dummyHead.next = dummyHead.next.next;
            }
        }
        dummyHead.next = null;
        return head;
    }
}
