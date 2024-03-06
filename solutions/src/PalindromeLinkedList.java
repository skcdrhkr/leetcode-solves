import utils.ListNode;

public class PalindromeLinkedList {

    public static void main(String[] args) {
        // Case 1
        System.out.println(PalindromeLinkedList.palindrome(ListNode.createList(new int[]{1, 2, 3, 2, 1})));

        // Case 2
        System.out.println(PalindromeLinkedList.palindrome(ListNode.createList(new int[]{2, 3, 5, 5, 3, 2})));
    }

    public static boolean palindrome(ListNode head) {

        // Replace this placeholder return statement with your code
        if (head == null || head.next == null)
            return true;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHalf = ListNode.reverseLinkedList(slow);
        fast = head;
        slow = secondHalf;
        while (slow != null) {
            if (fast.val != slow.val) return false;
            slow = slow.next;
            fast = fast.next;
        }
        ListNode.reverseLinkedList(secondHalf);
        return true;
    }
}
