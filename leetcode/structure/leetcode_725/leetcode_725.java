package leetcode.structure.leetcode_725;

import java.util.Arrays;

public class leetcode_725 {
    public static void main(String[] args) {
        leetcode_725 lc = new leetcode_725();

        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5,
                new ListNode(6, new ListNode(7, new ListNode(8, new ListNode(9, new ListNode(10))))))))));
        System.out.println(listNode.toString());

        System.out.println(Arrays.toString(lc.splitListToParts(listNode, 3)));
    }

    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] result = new ListNode[k];
        int size = 0;
        ListNode node = head;

        while (node != null) {
            node = node.next;
            size++;
        }

        int n = size / k;
        int r = size % k;

        ListNode prev = null;
        node = head;
        for (int i = 0; node != null; i++, r--) {
            result[i] = node;
            for (int j = 0; j < n + (r > 0 ? 1 : 0); j++) {
                prev = node;
                node = node.next;
            }
            prev.next = null;
        }

        return result;
    }
}
