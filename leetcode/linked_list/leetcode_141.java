package leetcode.linked_list;

import java.util.HashSet;
import java.util.Set;

public class leetcode_141 {
    public static void main(String[] args) {
        leetcode_141 leetcode = new leetcode_141();
        ListNode firstNode = new ListNode(3);
        firstNode.next = new ListNode(2);
        firstNode.next.next = new ListNode(0);
        firstNode.next.next.next = new ListNode(-4);
        firstNode.next.next.next.next = firstNode.next;
        System.out.println(leetcode.hasCycle(firstNode));
        System.out.println(leetcode.hasCycleBrute(firstNode));
    }

    // Solution 1 - Two pointers
    // Time Complexity : O(N)
    // Space Complexity : O(1)
    // Start with firstPointer(call p1) n secondPointer(call p2)
    // iterate till p2 & p2.next == null (p2 always after then p1, so p1 null check not necessary)
    // p1 increase by 1 and p2 increase by 2 (node)
    // if ListNode has cycle, they unconditionally meet at some point.
    // if ListNode doesn't have cycle, end of head will be null so loop is end and return false.
    // therefore, compare p1 p2 in end of every loop and if there same return true.
    public boolean hasCycle(ListNode head) {
        ListNode firstPointer = head;
        ListNode secondPointer = head;

        while (secondPointer != null && secondPointer.next != null) {
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next.next;
            if (firstPointer == secondPointer) return true;
        }

        return false;
    }

    // Solution 2 - Brute force
    // Time Complexity : O(N)
    // Space Complexity : O(N)
    public boolean hasCycleBrute(ListNode head) {
        Set<ListNode> set = new HashSet<>();

        while (head != null) {
            if (set.contains(head)) return true;
            set.add(head);
            head = head.next;
        }

        return false;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
