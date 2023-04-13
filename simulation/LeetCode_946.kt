package simulation

import java.util.Stack

class LeetCode_946 {

    fun validateStackSequences(pushed: IntArray, popped: IntArray): Boolean {
        val validationStack = Stack<Int>()
        var i = 0

        popped.forEach {
            if (validationStack.isEmpty() || validationStack.peek() != it) {
                while (i in pushed.indices && pushed[i] != it) {
                    validationStack.push(pushed[i++])
                }
                i++
            } else {
                validationStack.pop()
            }
        }

        return validationStack.isEmpty()
    }
}

fun main() {
    // Input
    val pushed = intArrayOf(1, 2, 3, 4, 5)
    val popped = intArrayOf(4, 5, 3, 2, 1)
    // Output
    LeetCode_946().validateStackSequences(pushed, popped).let {
        println(it)
        require(it)
    }
}
