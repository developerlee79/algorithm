package linked_list;

import java.util.ArrayDeque;
import java.util.Deque;

public class leetcode_25 {
    public static void main(String[] args) {
        leetcode_25 leetcode = new leetcode_25();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        // It doesn't work at same time. have to annotated another method for test.
        System.out.println(leetcode.reverseKGroup(head, 3).toString());
        System.out.println(leetcode.reverseKGroupBrute(head, 3).toString());
    }

    // Solution 1 - Recursive
    // Time Complexity : O(N)
    // Space Complexity : O(N)
    // First, set node to node(k). if length of remain nodes less then k, return head(non-reverse).
    // Second, recursive until node doesn't have
    // At recursive - set head.next node pre(head of lower recursion) for put value reverse order
    //                set pre to head, head to next and count--.
    // It gonna be like this - (1 2 3 4 5)  (Pretend case 1~5 & 3)
    //                          h n   p     (p - pre, h - head, n - head.next)
    //                         (1 2 3 4 5)  (iterative until count > 0)
    //                          h     p
    //                                n
    //                         (1 2 3 4 5)  basically this recursive add value by reverse order
    //                          p     n     start at listNode / k at each
    //                          h
    //                count--  (1 2 3 4 5)
    //                          p h n
    //
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode node = head;

        int count = 0;
        while (count < k) {
            if (node == null) return head;
            node = node.next;
            count++;
        }

        ListNode pre = reverseKGroup(node, k);

        while (count > 0) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
            count -= 1;
        }

        return pre;
    }

    // Solution 2 - Brute force what use deque
    // Time Complexity : O(N)
    // Space Complexity : O(N)
    // Push node value k times to deque
    // then compare the size of deque with k
    // if size >= k, it means reverse node - so use deque as stack to add reverse value at result node
    // if size < k, it means remain node - so use deque as queue to add natural value at result node
    public ListNode reverseKGroupBrute(ListNode head, int k) {
        ListNode result = new ListNode();
        ListNode saveNode = result;

        Deque<Integer> deque = new ArrayDeque<>();
        while (head != null) {
            for (int i = k; i > 0 && head != null; i--) {
                deque.push(head.val);
                head = head.next;
            }

            int size = deque.size();
            while (!deque.isEmpty()) {
                result.val = (size < k) ? deque.pollLast() : deque.pop();
                if (deque.isEmpty() && head == null) break;
                result.next = new ListNode();
                result = result.next;
            }
        }

        return saveNode;
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
