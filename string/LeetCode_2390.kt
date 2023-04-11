package string

import java.util.Stack

class LeetCode_2390 {

    fun removeStars(s: String): String {
        val stack = Stack<Char>()

        s.forEach {
            if ('*' == it) {
                if ('*' != stack.peek()) {
                    stack.pop()
                } else {
                    stack.push(it)
                }
            } else {
                stack.push(it)
            }
        }

        val stringBuilder = StringBuilder()

        while (stack.isNotEmpty()) {
            stringBuilder.append(stack.pop())
        }

        return stringBuilder.reverse().toString()
    }
}

fun main() {
    // Input
    val s = "leet**cod*e"
    // Output
    LeetCode_2390().removeStars(s).let {
        println(it)
        require("lecoe" == it)
    }
}
