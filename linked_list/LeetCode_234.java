package linked_list;

public class LeetCode_234 {
    public static void main(String[] args) {
        LeetCode_234 leetcode = new LeetCode_234();
        ListNode head = new ListNode(1, new ListNode(0, new ListNode(1)));
        System.out.println(leetcode.isPalindrome(head));
    }

    /**
     * @param head head of a singly liked list
     * @return is head a palindrome
     *
     * Solution - Two pointers
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     *
     * Reverse half of linked list and compare each element to valid it's a palindrome list.
     * Use the fast & slow node to position the slow pointer in half of the linked list.
     * Reverse linked list from slow pointer to the end of the linked list.
     * If it is a palindrome list, the reversed linked list is the same as the not reversed linked list (other half)
     * Increase the head and slow pointer one by one and compare to see if the linked list is palindrome.
     *
     * Example : [1 -> 2 -> 2 -> 1] -> [1 -> 2 -> 1 -> 2] - and check it's palindrome
     */
    public boolean isPalindrome(ListNode head) {
        if (head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow = reverse(slow);

        while (head != null && slow != null) {
            if (head.val != slow.val) {
                return false;
            }
            head = head.next;
            slow = slow.next;
        }

        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode nextNode = head.next;
            head.next = prev;
            prev = head;
            head = nextNode;
        }

        return prev;
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
}
