package linked_list;

public class leetcode_206 {
    public static void main(String[] args) {
        leetcode_206 leetcode = new leetcode_206();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(leetcode.reverseList(head).toString());
    }

    // Solution - Recursion
    // Time Complexity : O(N)
    // Space Complexity : O(N)
    // Recursive until head is null
    // If the recursion is over, set head.next.next as head(set head sequentially) & head.next null
    // Example (h1 = head.next, h2 = head.next.next)
    //         R(Recursive to here)
    // 1 2 3 4 5
    //         h h1 h2
    // 1 2 3 4 5
    //       h h1 h2
    // 1 2 3 4 5
    //     h h1 h2
    // 1 2 3 4 5
    //   h h1 h2
    // 1 2 3 4 5
    // h h1 h2
    // 1 2 3 4 5
    // h1 h2
    // 1 2 3 4 5
    // h2
    // after than, head.next.next gonna be 1 (ListNode's first)
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode reverseHead = reverseList(head.next);

        head.next.next = head;
        head.next = null;

        return reverseHead;
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
