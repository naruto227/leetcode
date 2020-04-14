package list;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("ListNode: ");
        ListNode head = this;
        while (head != null) {
            res.append(head.val).append("->");
            head = head.next;
        }
        res.append("null");
        return res.toString();
    }
}
