package two_pointers;

public class leetcode_876 {
    public static void main(String[] args) {
        leetcode_876 leetcode = new leetcode_876();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        System.out.println(leetcode.middleNode(head).toString());
    }

    // Solution - Two pointers
    // Time Complexity : O(N)
    // Space Complexity : O(1)
    // Start with two pointer - slow(head) & fast(pointerNode)
    // Require of this problem is "half" of the array.
    // therefore if a pointer that is "twice" as fast reached the end of the array,
    // slow pointer is unconditionally placed in the middle of the array.
    public ListNode middleNode(ListNode head) {
        ListNode pointerNode = head;

        while (pointerNode != null && pointerNode.next != null) {
            head = head.next;
            pointerNode = pointerNode.next.next;
        }

        return head;
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
