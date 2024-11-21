/**
 * Educative: https://www.educative.io/courses/grokking-coding-interview/remove-nth-node-from-end-of-list
 */

package twopointers;

import utils.ListNode;

public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        // Case 1
        System.out.println(RemoveNthNodeFromEndOfList.removeNthLastNode(ListNode.createList(new int[]{23, 28, 10, 5, 67, 39, 70, 28}), 8));

        // Case 2
        System.out.println(RemoveNthNodeFromEndOfList.removeNthLastNode(ListNode.createList(new int[]{288, 224, 275, 390, 4, 383, 330, 60, 193}), 4));
    }

    public static ListNode removeNthLastNode(ListNode head, int n) {
        ListNode first = head, second = head;
        if (head == null) return null;
        int count = 0;
        while (count < n) {
            first = first.next;
            count += 1;
        }
        if (first == null) return head.next;
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return head;
    }
}
