package fastandslow;

import utils.ListNode;

public class MaximumTwinSumInLinkedList {

    public static void main(String[] args) {
        // Case 1
        System.out.println(MaximumTwinSumInLinkedList.twinSum(ListNode.createList(new int[]{2, 3, 5, 7})));

        // Case 2
        ListNode case2 = ListNode.createList(new int[]{11, 77, 44, 99, 22, 66, 55, 88});
        System.out.println(MaximumTwinSumInLinkedList.twinSum(case2));
        System.out.println(case2);
    }

    public static int twinSum(ListNode head) {

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode half = reverse(slow);
        slow = half;
        fast = head;
        int mx = -1;
        while (slow != null) {
            mx = Math.max(mx, fast.val + slow.val);
            fast = fast.next;
            slow = slow.next;
        }
        reverse(half);
        return mx;
    }

    private static ListNode reverse(ListNode head) {
        ListNode cur = head, prev = null, nxt;
        while (cur != null) {
            nxt = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nxt;
        }
        return prev;
    }
}
