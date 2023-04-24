package practice.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        int[] numbers1 = new int[]{1, 2, 4};
        int[] numbers2 = new int[]{1, 3, 4};
        List<ListNode> list1 = init(numbers1);
        List<ListNode> list2 = init(numbers2);

        ListNode result = mergeTwoLists(list1.get(0), list2.get(0));
        while (result.next != null) {
            System.out.print(result.val);
            result = result.next;
        }
    }

    static List<ListNode> init(int[] numbers) {
        List<ListNode> list = new ArrayList<>();
        ListNode node = new ListNode();
        for (int i = 0; i < numbers.length; i++) {
            node.val = numbers[i];
            list.add(node);
            if (i < numbers.length - 1) {
                node.next = new ListNode(numbers[i + 1]);
            }
            node = node.next;
        }
        return list;
    }

    static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode prehead = new ListNode();
        ListNode current = prehead;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        current.next = list1 == null ? list2 : list1;
        return prehead.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
