package practice.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

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

        List<ListNode> l1 = init(numbers1);
        List<ListNode> l2 = init(numbers2);
        ListNode result = addTwoNumbers(l1.get(0), l2.get(0));
        while (result.next != null) {
            System.out.print(result.value);
            result = result.next;
        }

    }

    private static List<ListNode> init(int[] numbers) {
        List<ListNode> list = new ArrayList<>();
        ListNode node = new ListNode();
        for (int i = 0; i < numbers.length; i++) {
            node.value = numbers[i];
            if (i < numbers.length - 1) {
                // add the next node value
                node.next = new ListNode(numbers[i + 1]);
            }
            list.add(node);
            // move the next node
            node = node.next;
        }
        return list;
    }

    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;
        int carry = 0; // nhớ trong phép toán. VD 10 nhớ 1, 21 nhớ 2
        ListNode head = new ListNode();
        ListNode current = head;
        while (l1 != null || l2 != null || carry > 0) {
            if (l1 != null) {
                sum += l1.value;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.value;
                l2 = l2.next;
            }
            sum += carry;
            carry = sum / 10;
//            head.next = new ListNode(sum % 10);
            current.value = sum % 10;

            sum = 0;
            current.next = new ListNode(sum);
            current = current.next;
//            System.out.print(current.value);
        }
        return head.next;
    }
}

class ListNode {
    int value;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int value) {
        this.value = value;
    }

    public ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }
}
