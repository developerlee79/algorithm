package linked_list;

public class leetcode_2 {
    public static void main(String[] args) {
        leetcode_2 leetcode = new leetcode_2();
        ListNode firstList = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode secondList = new ListNode(5, new ListNode(6, new ListNode(4)));
        System.out.println(leetcode.addTwoNumbers(firstList, secondList).toString());
    }

    // Solution - Iterative
    // Time Complexity : O(N)
    // Space Complexity : O(N)
    // Add the values of the two nodes until the end of each linked list navigation.
    // If a digit increase occurs, add 1 to the value of the next node.
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultNode = new ListNode();
        ListNode headNode = resultNode;

        int isRaised = 0;
        while (l1 != null || l2 != null || isRaised != 0) {
            int sum = getNodeValue(l1) + getNodeValue(l2) + isRaised;

            isRaised = (sum > 9) ? 1 : 0;

            headNode.next = new ListNode(sum % 10);
            headNode = headNode.next;

            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }

        return resultNode.next;
    }

    static int getNodeValue(ListNode node) {
        return (node != null) ? node.val : 0;
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
