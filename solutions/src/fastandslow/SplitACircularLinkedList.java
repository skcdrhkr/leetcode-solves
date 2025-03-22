/**
 * Educative: https://www.educative.io/courses/grokking-coding-interview/split-a-circular-linked-list
 */

package fastandslow;

import utils.ListNode;

public class SplitACircularLinkedList {

    public static void main(String[] args) {
        // Case 1
        ListNode case1 = ListNode.createList(new int[]{1, 5, 7});
        case1.next.next.next = case1;
        SplitACircularLinkedList.splitCircularLinkedList(case1);

        // Case 2
        ListNode case2 = ListNode.createList(new int[]{2, 6, 1, 5});
        case2.next.next.next.next = case2;
        SplitACircularLinkedList.splitCircularLinkedList(case2);
    }

    public static ListNode[] splitCircularLinkedList(ListNode head) {

        ListNode first = head, second = head;
        while (second.next != head && second.next.next != head) {
            first = first.next;
            second = second.next.next;
        }
        ListNode nxt = first.next;
        if (second.next == head) {
            second.next = nxt;
        } else {
            second.next.next = nxt;
        }
        first.next = head;
        // Placeholder for actual implementation
        return new ListNode[]{head, nxt}; // Return two empty lists as placeholders
    }
}
