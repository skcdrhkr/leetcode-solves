package utils;

public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode createList(int[] lst) {
        int n = lst.length;
        if (n == 0)
            return null;
        ListNode head = new ListNode(lst[0]);
        ListNode prev = head, cur;
        for (int i = 1; i < n; i++) {
            cur = new ListNode(lst[i]);
            prev.next = cur;
            prev = cur;
        }
        return head;
    }

    public static ListNode reverseLinkedList(ListNode slowPtr) {
        ListNode prev = null;
        ListNode next = null;
        ListNode curr = slowPtr;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        ListNode cur = this;
        if (cur != null) {
            res.append(cur.val).append(" ");
            cur = cur.next;
        }
        while (cur != null && cur != this) {
            res.append(cur.val).append(" ");
            cur = cur.next;
        }
        return res.toString();
    }
}