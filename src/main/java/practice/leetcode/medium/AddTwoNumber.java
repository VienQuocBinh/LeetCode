package practice.leetcode.medium;

import static practice.leetcode.medium.ListNode.init;

/**
 * Single link list has many nodes
 * Cộng 2 số (Node) của 2 chuỗi (ListNode) có tính số dư
 * {2, 4, 3}
 * + {5, 6, 4}
 * = 7, 0, 8
 */

public class AddTwoNumber {
    public static void main(String[] args) {
//        int[] numbers1 = new int[]{9, 9, 9, 9, 9, 9, 9};
//        int[] numbers2 = new int[]{9, 9, 9, 9};
        int[] numbers1 = new int[]{2, 4, 3};
        int[] numbers2 = new int[]{5, 6, 4};
//        int[] numbers1 = new int[]{0};
//        int[] numbers2 = new int[]{0};

        ListNode l1 = init(numbers1);
        ListNode l2 = init(numbers2);
        ListNode result = addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.print(result.val);
            result = result.next;
        }

    }


    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;
        int carry = 0; // nhớ trong phép toán. VD 10 nhớ 1, 21 nhớ 2
        ListNode head = new ListNode();
        ListNode current = head;
        while (l1 != null || l2 != null || carry > 0) {
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            sum += carry;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            sum = 0;
            current = current.next;
        }
        return head.next;
    }
}