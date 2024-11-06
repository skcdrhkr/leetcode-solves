package linkedlist;

import utils.ListNode;

public class ReverseLinkedList {

    public static void main(String[] args) {
        // Case 1
        System.out.println(ReverseLinkedList.reverse(ListNode.createList(new int[]{1, -2, 3, 4, -5, 4, 3, -2, 1})));

        // Case 2
        System.out.println(ReverseLinkedList.reverse(ListNode.createList(new int[]{-1, 2, -3, 4})));
    }

    public static ListNode reverseRecursive(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode rest = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return rest;
    }


    public static ListNode reverse(ListNode head) {
        ListNode nxt, prev = null;
        while (head != null) {
            nxt = head.next;
            head.next = prev;
            prev = head;
            head = nxt;
        }
        return prev;
    }
}
