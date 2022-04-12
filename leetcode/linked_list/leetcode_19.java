package linked_list;

public class leetcode_19 {
    public static void main(String[] args) {
        leetcode_19 leetcode = new leetcode_19();
        ListNode head = new ListNode(1, new ListNode(2));
        System.out.println(leetcode.removeNthFromEnd(head, 1).toString());
    }

    // Solution - Two pointers
    // Time Complexity : O(N)
    // Space Complexity : O(N)
    // Start with Zero-head result Node and two pointers what as slower / faster as K.
    // move forward each pointer till faster pointer reach the end of array.
    // after that, next node of slow pointer is the node that needs to be removed.
    // (because distance of between slower / faster pointers is K)
    // therefore replace the next node of slow node with .next.next node to complete the removal operation.
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode startNode = new ListNode(0, head);
        ListNode slowerPointerNode = startNode, fasterPointerNode = startNode;

        while (n-- > 0) {
            fasterPointerNode = fasterPointerNode.next;
        }

        while (fasterPointerNode.next != null) {
            slowerPointerNode = slowerPointerNode.next;
            fasterPointerNode = fasterPointerNode.next;
        }

        slowerPointerNode.next = slowerPointerNode.next.next;

        return startNode.next;
    }

    public static class ListNode {
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

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
