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
            ListNode node = removeDN.removeDuplicateNodes(head);
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
}
