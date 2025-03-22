package fastandslow;

import utils.ListNode;

public class LinkedListCycleIII {
    public static int countCycleLength(ListNode head) {

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }
        if (fast == null || fast.next == null) return 0;

        int cycle = 0;
        do {
            slow = slow.next;
            cycle += 1;
        } while (slow != fast);
        return cycle;
    }
}
