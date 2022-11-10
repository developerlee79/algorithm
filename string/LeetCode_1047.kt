package string

import java.util.Stack

class LeetCode_1047 {

    /**
     * Solution : Stack
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * @param s string
     * @return Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique
    */
    fun removeDuplicates(s: String): String {
        val stack = Stack<Char>()

        s.forEach {
            if (stack.isNotEmpty() && stack.peek() == it) {
                stack.pop()
            } else {
                stack.push(it)
            }
        }

        val stringBuilder = StringBuilder()

        stack.forEach {
            stringBuilder.append(it)
        }

        return stringBuilder.toString()
    }
}

fun main() {
    // Input
    val s = "abbaca"
    // Output
    val result = LeetCode_1047().removeDuplicates(s)
    println(result)
    require(result == "ca")
}
