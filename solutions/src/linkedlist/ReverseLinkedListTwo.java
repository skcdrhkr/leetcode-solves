package linkedlist;

import utils.ListNode;

public class ReverseLinkedListTwo {

    public static void main(String[] args) {
        // Case 1
        System.out.println(ReverseLinkedListTwo.reverseBetweenBetter(ListNode.createList(new int[]{1, 2, 3, 4, 5}), 2, 4));

        // Case 2
        System.out.println(ReverseLinkedListTwo.reverseBetweenBetter(ListNode.createList(new int[]{1, 2, 3, 4, 5, 4, 3, 2, 1}), 1, 9));

        // Case 3
        System.out.println(ReverseLinkedListTwo.reverseBetweenBetter(ListNode.createList(new int[]{-499, 399, -299, 199, -99, 9}), 3, 5));
    }

    public static ListNode reverseBetweenBetter(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }
        ListNode cur = prev.next, nxt;
        for (int count = 0; count < (right - left); count++) {
            nxt = cur.next;
            cur.next = nxt.next;
            nxt.next = prev.next;
            prev.next = nxt;
        }
        return dummy.next;
    }


    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right)
            return head;
        int count = left;
        ListNode prefixNodes = null, cur = head;
        while (left > 1) {
            prefixNodes = cur;
            cur = cur.next;
            left -= 1;
        }
        ListNode prev = null, nxt, reverseEnd = cur;
        while (count <= right) {
            nxt = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nxt;
            count += 1;
        }
        reverseEnd.next = cur;
        if (prefixNodes != null) {
            prefixNodes.next = prev;
        } else {
            head = prev;
        }
        return head;
    }
}
