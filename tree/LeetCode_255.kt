package tree

import java.util.Stack

class LeetCode_255 {

    fun verifyPreorder(preorder: IntArray): Boolean {
        var low = Int.MIN_VALUE
        val stack = Stack<Int>()

        preorder.forEach { node ->
            if (node < low) {
                return false
            }

            while (stack.isNotEmpty() && node > stack.peek()) {
                low = stack.pop()
            }

            stack.push(node)
        }

        return true
    }
}

fun main() {
    // Input
    val preorder = intArrayOf(5, 2, 1, 3, 6)
    // Output
    LeetCode_255().verifyPreorder(preorder).run {
        println(this)
        require(this)
    }
}
