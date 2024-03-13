/**
 * Problem URL: https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/description
 * Level: Medium
 */

import utils.ListNode;

import java.util.ArrayList;

public class RemoveZeroSumNodesLinkedList {

    public static void main(String[] args) {

        // Case 0
        System.out.println(RemoveZeroSumNodesLinkedList.removeZeroSumSublists(ListNode.createList(new int[]{0})));

        // Case 1
        System.out.println(RemoveZeroSumNodesLinkedList.removeZeroSumSublists(ListNode.createList(new int[]{1, 2, -3, 3, 1})));

        // Case 2
        System.out.println(RemoveZeroSumNodesLinkedList.removeZeroSumSublists(ListNode.createList(new int[]{1, 2, 3, -3, 4})));

        // Case 3
        System.out.println(RemoveZeroSumNodesLinkedList.removeZeroSumSublists(ListNode.createList(new int[]{1, 2, 3, -3, -2})));

        // Case 4
        System.out.println(RemoveZeroSumNodesLinkedList.removeZeroSumSublists(ListNode.createList(new int[]{1, 2, 3, -2, 0, 1, -3, 2, -4})));
    }

    public static ListNode removeZeroSumSublists(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode iter = head;
        while (iter != null) {
            list.add(iter.val);
            iter = iter.next;
        }

        int sum = 0, cur, k;
        for (int i = 0; i < list.size(); i++) {
            sum = 0;
            for (int j = i; j < list.size(); j++) {
                cur = list.get(j);
                if (cur != -2000) {
                    sum += cur;
                    if (sum == 0) {
                        k = i;
                        while (k <= j) {
                            list.set(k, -2000);
                            k += 1;
                        }
                    }
                }
            }
        }
        ListNode nHead = new ListNode(0);
        iter = nHead;
        for (Integer integer : list) {
            if (integer != -2000) {
                iter.next = new ListNode(integer);
                iter = iter.next;
            }
        }
        return nHead.next;
    }
}
