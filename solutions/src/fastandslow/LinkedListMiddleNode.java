package fastandslow;

import utils.ListNode;

public class LinkedListMiddleNode {
    public static void main(String[] args) {
        // Case 1
        System.out.println(LinkedListMiddleNode.middleNode(ListNode.createList(new int[]{1, 2, 3, 4, 5})));

        // Case 2
        System.out.println(LinkedListMiddleNode.middleNode(ListNode.createList(new int[]{1, 2})));
    }

    public static ListNode middleNode(ListNode head) {

        // Replace this placeholder return statement with your code
        ListNode slow = head, fast = head;
        if (head == null || head.next == null) return head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
