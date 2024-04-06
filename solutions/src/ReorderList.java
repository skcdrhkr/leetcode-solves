import utils.ListNode;

public class ReorderList {

    public static void main(String[] args) {
        // Case 1
        ListNode head = ListNode.createList(new int[]{1, 2, 3, 4});
        ReorderList.reorderList(head);
        System.out.println(head);

        // Case 2
        head = ListNode.createList(new int[]{1, 2, 3, 4, 5});
        ReorderList.reorderList(head);
        System.out.println(head);
    }

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode slow = head, fast = head, prev = head, cur, nxt;
        // Find middle node from List
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        // slow is pointing to middle node
        // Reverse second half of the list
        prev = null;
        cur = slow;
        while (cur != null) {
            nxt = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nxt;
        }
        // prev is pointing to head of reversed linked list,
        // i.e. Last node of original list

        slow = head;
        fast = prev;
        while (slow != null) {
            nxt = slow.next;
            cur = fast.next;
            slow.next = fast;
            if (nxt != null)
                fast.next = nxt;
            slow = nxt;
            fast = cur;
        }

    }

}
