package fastandslow;

import utils.ListNode;

public class LinkedListCycleDetection {

    public static void main(String[] args) {

    }

    public static boolean detectCycle(ListNode head) {

        // Replace this placeholder return statement with your code
        ListNode slow = head, fast = head;
        do {
            if (fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        } while (slow != fast);
        return true;
    }
}
