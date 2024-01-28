import utils.ListNode;

/**
 * Problem URL: https://leetcode.com/problems/add-two-numbers/description/
 * Level: Medium
 */

public class AddTwoNumbers {

    public static void main(String[] args) {
        // Case 1
        int[] arr1 = new int[]{2, 4, 3};
        int[] arr2 = new int[]{5, 6, 4};
        System.out.println(AddTwoNumbers.addTwoNumbers(ListNode.createList(arr1), ListNode.createList(arr2)).toString());

        // Case 2
        arr1 = new int[]{0};
        arr2 = new int[]{0};
        System.out.println(AddTwoNumbers.addTwoNumbers(ListNode.createList(arr1), ListNode.createList(arr2)).toString());

        // Case 3
        arr1 = new int[]{9, 9, 9, 9, 9, 9, 9};
        arr2 = new int[]{9, 9, 9, 9};
        System.out.println(AddTwoNumbers.addTwoNumbers(ListNode.createList(arr2), ListNode.createList(arr1)).toString());
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int car = 0, cur;
        ListNode first = l1, second = l2, temp = l1;
        while (first != null && second != null) {
            cur = first.val + second.val + car;
            first.val = cur % 10;
            car = cur / 10;
            if (first.next == null && second.next != null) {
                first.next = second.next;
                second.next = null;
            }
            temp = first;
            first = first.next;
            second = second.next;
        }
        while (first != null && car != 0) {
            cur = first.val + car;
            first.val = cur % 10;
            car = cur / 10;
            temp = first;
            first = first.next;
        }
        if (car != 0) {
            temp.next = new ListNode(car);
        }
        return l1;
    }
}
