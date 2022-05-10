package leetcode.linked_list;

public class leetcode_203 {
    public static void main(String[] args) {
        leetcode_203 leetcode = new leetcode_203();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(6, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6)))))));
        System.out.println(leetcode.removeElements(head, 6).toString());
    }

    /**
     * @param head Head of ListNode which containing nodes to be removed
     * @param val Value what has to be removed
     * @return ListNode after val removed
     *
     * Solution - Iteration
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * If the value of a Node is a value that needs to be removed, change the next Node of that ListNode to Null until the correct value is obtained.
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode resultNode = new ListNode(-1);
        ListNode prevNode = resultNode;

        while (head != null) {
            if (head.val == val)
                prevNode.next = null;
            else {
                prevNode.next = head;
                prevNode = head;
            }
            head = head.next;
        }

        return resultNode.next;
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

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
