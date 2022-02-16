package leetcode.array;

import leetcode.ListNode;

public class leetcode_24 {
    public static void main(String[] args) {
        leetcode_24 lc = new leetcode_24();
        ListNode list = ListNode.of(1, 2, 3, 4);
        System.out.println(lc.swapPairs(list));
    }

    public ListNode swapPairs(ListNode head) {
        ListNode list = head;

        while (head != null && head.next != null) {
            swap(head, head.next);
            head = head.next.next;
        }

        return list;
    }

    private static void swap(ListNode node1, ListNode node2) {
        int tmp = node1.val;
        node1.val = node2.val;
        node2.val = tmp;
    }
}
