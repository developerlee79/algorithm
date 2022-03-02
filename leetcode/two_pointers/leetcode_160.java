package leetcode.two_pointers;

public class leetcode_160 {

    // Solution 1 - brute force
    // Time Complexity : O(mn) (it can be n^ or n by len)
    // Space Complexity : O(N)
    // Compare A to B until B ended.
    // If A equal B till loop ended, break loop and return C (ListNode what saved first join point)
    // If not, move headA next and keep compare till a is end.
    // If loop ended, result C contain value of join point or null.
    public ListNode getIntersectionNodeBruteForce(ListNode headA, ListNode headB) {
        ListNode resultA = headA;
        ListNode resultB = headB;
        ListNode resultC = null;

        while (headA != null) {
            while (headB != null) {
                if (headB == headA) {
                    headA = headA.next;
                    if (resultC == null)
                        resultC = headB;
                } else
                    resultC = null;
                headB = headB.next;
            }
            if (resultC != null) break;
            headA = resultA.next;
            headB = resultB;
            resultA = headA;
        }

        return resultC;
    }

    // Solution 2 - Two Pointers
    // Time Complexity : O(m + n)
    // Space Complexity : O(N)
    // Iterate until Node A equal Node B (Because )
    // If Node A == null (A ended & A never equal B) then change Node A to head B (init value of Node B)
    // If Node B == null (B ended & B never equal A) then change Node B to head A (init value of Node A)
    // There may be 4 different case
    // 1. Have intersection & Same length : move till meet at midpoint -> loop end
    // 2. Have intersection & Diff length : move till node is null -> swap start point -> meet at midpoint(because the long one will be late as a.len - b.len)
    // 3. No intersection & Same length : move till node is null -> loop end(because at last null == null)
    // 4. No intersection & Diff length : same principle as case 2 & 3
    public ListNode getIntersectionNodePointer(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode nodeA = headA, nodeB = headB;

        while (nodeA != nodeB) {
            nodeA = (nodeA == null) ? headB : nodeA.next;
            nodeB = (nodeB == null) ? headA : nodeB.next;
        }

        return nodeA;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
