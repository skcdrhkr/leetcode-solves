import utils.ListNode;

/**
 * Problem URL: https://leetcode.com/problems/merge-two-sorted-lists/description/
 * Level: Easy
 */

public class Merge2SortedLinkedList {

    public static void main(String[] args) {
        // Case 1
        System.out.println(Merge2SortedLinkedList.mergeTwoLists(ListNode.createList(new int[]{1, 2, 4}), ListNode.createList(new int[]{1, 3, 4})).toString());

        // Case 2
        System.out.println(Merge2SortedLinkedList.mergeTwoLists(ListNode.createList(new int[]{}), ListNode.createList(new int[]{0})).toString());

        // Case 3
        System.out.println(Merge2SortedLinkedList.mergeTwoLists(ListNode.createList(new int[]{0,0,1,2,3}), ListNode.createList(new int[]{0})).toString());

        // Case 4
        System.out.println(Merge2SortedLinkedList.mergeTwoLists(ListNode.createList(new int[]{0,0,1,2,3,60}), ListNode.createList(new int[]{0,10,50})).toString());
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        ListNode nhead, cura, curb, prev, temp;
        if (list1.val < list2.val) {
            nhead = list1;
            cura = nhead;
            curb = list2;
        } else {
            nhead = list2;
            cura = nhead;
            curb = list1;
        }
        while (cura != null && curb != null) {
            prev = null;
            while (cura != null && cura.val <= curb.val) {
                prev = cura;
                cura = cura.next;
            }
            if (cura == null) {
                prev.next = curb;
            } else {
                prev.next = curb;
                temp = curb;
                curb = cura;
                cura = temp;
            }
        }
        return nhead;
    }
}
