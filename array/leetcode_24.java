package array;

public class leetcode_24 {
    public static void main(String[] args) {
        leetcode_24 lc = new leetcode_24();
        ListNode list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        System.out.println(lc.swapPairs(list));
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
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
