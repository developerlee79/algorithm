package linked_list;

public class leetcode_1721 {
    public static void main(String[] args) {
        leetcode_1721 leetcode = new leetcode_1721();
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(leetcode.swapNodes(node, 2).toString());
    }

    // Solution - Two pointers
    // Time Complexity : O(N)
    // Space Complexity : O(1)
    // Start with 3 node - n1, n2, p(pointer)
    // First, move pointer to k - 1 point to make k distance between each pointers.
    // when pointer reach the end of linked list, slower pointer is swappable node.
    // then save pointed node at n1.
    // Second, increase n2 & p simultaneously till reach the end of linked list.
    // now we now both point of nodes. just swap it.
    public ListNode swapNodes(ListNode head, int k) {
        ListNode n1, n2, p;
        p = n2 = head;

        for (int i = 0; i < k - 1; i++)
            p = p.next;

        n1 = p;

        while (p.next != null) {
            n2 = n2.next;
            p = p.next;
        }

        int tmp = n1.val;
        n1.val = n2.val;
        n2.val = tmp;

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
