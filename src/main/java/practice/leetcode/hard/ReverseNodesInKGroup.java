package practice.leetcode.hard;

import practice.leetcode.ListNode;

/*
Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.

Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]

Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]
 */
public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        int[] n1 = new int[]{1, 2, 3, 4, 5};
        int k = 3;
        ListNode head = ListNode.init(n1);
        ListNode result = reverseKGroup(head, k);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        ListNode root = new ListNode(0, head); // hold the start point while the head node is changed
        ListNode current = head;
        ListNode prev = root;

        while (current != null) {
            // Hold the last node of the group after reversed by set tail node as the current node
            ListNode tail = current;
            int listIndex = 0;
            // Move the current node to the last node of the group
            while (current != null && listIndex < k) {
                current = current.next;
                listIndex++;
            }

            // If the remaining node which is not in any groups --> point prev node to the tail node
            // else -> reverse the group
            if (listIndex != k) {
                prev.next = tail;
            } else {
                // prev node points to the head node of the reversed group
                prev.next = reverse(tail, k);
                // Set prev to the old current node (the first node of the group before reverse, the last node of the reversed group)
                prev = tail;
            }
        }
        return root.next;
    }

    /*
    Reverse the list containing k nodes. Beginning from the head node.
    Return the head of reversed list.
     */
    static ListNode reverse(ListNode head, int k) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next;
        while (current != null && k-- > 0) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}
