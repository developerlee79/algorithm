package linked_list;

public class leetcode_237 {
    public static void main(String[] args) {
        leetcode_237 leetcode = new leetcode_237();
        System.out.println(head.toString());
        leetcode.deleteNode(head.next);
        System.out.println(head.toString());
    }

    static ListNode head = new ListNode(4, new ListNode(5, new ListNode(1, new ListNode(9))));

    // Solution - Simple node manipulate
    // Time Complexity : O(1)
    // Space Complexity : O(1)
    // Umm....that's all. I think modifying is a more correct word than deletion.
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        ListNode(int x, ListNode node) {
            val = x;
            next = node;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
