package linkedlist;

import utils.ListNode;

public class ReverseNodesInKGroup {

    public static void main(String[] args) {
        // Case 1
        System.out.println(ReverseNodesInKGroup.reverseKGroup(ListNode.createList(new int[]{1, 2, 3, 4, 5}), 2));

        // Case 2
        System.out.println(ReverseNodesInKGroup.reverseKGroup(ListNode.createList(new int[]{1, 2, 3, 4, 5}), 3));

        // Case 3
        System.out.println(ReverseNodesInKGroup.reverseKGroup(ListNode.createList(new int[]{1, 2, 3, 4, 5}), 1));

        // Case 4
        System.out.println(ReverseNodesInKGroup.reverseKGroup(ListNode.createList(new int[]{1, 2, 3, 4, 5}), 4));

        // Case 5
        System.out.println(ReverseNodesInKGroup.reverseKGroup(ListNode.createList(new int[]{1, 2, 3, 4, 5}), 5));
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        return null;
    }
}
