package tree

import java.util.Stack

class LeetCode_105 {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    /**
     * Solution - Stack
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * Two Pointer strategy with Stack solves the problem.
     * Before we solve the problem, let's get to the clear facts first.
     *
     * 1. First elements in preorder array is root of binary tree.
     * 2. If the pointers in the two arrays point to the same value, the node is where the two navigation methods collide (with different directions to explore later).
     * 3. Last elements in each array is always last node of binary tree.
     *
     * Let's solve the problem using these features.
     * Use a preorder array that is easy to organize trees in order.
     * Add nodes until the top value of the stack equals the inorder[pointer] (i.e., when you need to change direction).
     * If the top value of the stack is equal to the value of the inorder[pointer], empty the stack and increase the pointer until it is no longer equal. (Move right node to add)
     * Add the right node, circle the array again, and configure the tree.
     *
     * @param preorder preorder traversal of a binary tree
     * @param inorder inorder traversal of a binary tree
     * @return original binary tree
    */
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode {
        val stack = Stack<TreeNode>()

        val root = TreeNode(preorder[0])
        var currentNode = root

        var pointer = 0
        for (i in 1 until preorder.size) {
            if (currentNode.`val` != inorder[pointer]) {
                currentNode.left = TreeNode(preorder[i])
                stack.push(currentNode)
                currentNode = currentNode.left!!
            } else {
                pointer++

                while (stack.isNotEmpty() && stack.peek().`val` == inorder[pointer]) {
                    currentNode = stack.pop()
                    pointer++
                }

                currentNode.right = TreeNode(preorder[i])
                currentNode = currentNode.right!!
            }
        }
        return root
    }
}

fun main() {
    val preorder = intArrayOf(3, 9, 20, 15, 7)
    val inorder = intArrayOf(9, 3, 15, 20, 7)
    println(LeetCode_105().buildTree(preorder, inorder))
}
