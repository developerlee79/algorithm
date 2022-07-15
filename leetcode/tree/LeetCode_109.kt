package tree

class LeetCode_109 {

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    /**
     * Solution - Two Pointers
     * Time Complexity : O(NlogN)
     * Space Complexity : O(N)
     *
     * If you find the middle, the root is the middle.
     * The left subtree is the left part of the middle.
     * The right subtree is the right part of the middle.
     *
     * @param head head of a singly linked list where elements are sorted in ascending order
     * @return height balanced BST which converted from head
     */
    fun sortedListToBST(head: ListNode?): TreeNode? {
        return recursive(head, null)
    }

    private fun recursive(head: ListNode?, tail: ListNode?): TreeNode? {
        if (head == null || head == tail) {
            return null
        }

        if (head.next == tail) {
            return TreeNode(head.`val`)
        }

        var slowPointer = head
        var fastPointer = head

        while (fastPointer != tail && fastPointer!!.next != tail) {
            fastPointer = fastPointer.next!!.next
            slowPointer = slowPointer!!.next!!
        }

        val root = TreeNode(slowPointer!!.`val`)
        root.left = recursive(head, slowPointer)
        root.right = recursive(slowPointer.next, tail)

        return root
    }
}

fun main() {
    val head = LeetCode_109.ListNode(-10)
    head.next = LeetCode_109.ListNode(-3)
    head.next!!.next = LeetCode_109.ListNode(0)
    head.next!!.next!!.next = LeetCode_109.ListNode(5)
    head.next!!.next!!.next!!.next = LeetCode_109.ListNode(9)
    println(LeetCode_109().sortedListToBST(head))
}
