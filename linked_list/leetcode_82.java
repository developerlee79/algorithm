package linked_list;

public class leetcode_82 {
    public static void main(String[] args) {
        leetcode_82 leetcode = new leetcode_82();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5)))))));
        System.out.println(leetcode.deleteDuplicates(head).toString());
    }

    // Solution - Two pointers
    // Time Complexity : O(N)
    // Space Complexity : O(N)
    // First, declare countNode with initialized node for actual process
    // (call head h1 / head.next h2 / countNode c)
    // if h2 != null && h1.val equal h2.val that means its duplicates
    // therefore increase head value till h1.val != h2.val
    // and increase h1 again(cause loop compare next value) and skip the loop(cause h1 nullable)
    // if h1 doesn't duplicate, addition h1 at c & increase h1.
    public ListNode deleteDuplicates(ListNode head) {
        ListNode resultNode = new ListNode(0);
        ListNode countNode = resultNode;

        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val)
                    head = head.next;
                head = head.next;
                continue;
            }

            countNode.next = head;
            countNode = countNode.next;
            head = head.next;
        }

        countNode.next = null;
        return resultNode.next;
    }

    static class ListNode {
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
