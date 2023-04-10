package string

import java.util.Stack

class LeetCode_20 {

    fun isValid(s: String): Boolean {
        if (s.isEmpty() || s.length % 2 != 0) {
            return false
        }

        val stack = Stack<Char>()

        s.forEach {
            when (it) {
                '(', '[', '{' -> stack.push(it)
                ']', '}', ')' -> {
                    if (stack.isEmpty() || (stack.peek() != it - 1 && stack.peek() != it - 2)) {
                        return false
                    }
                    stack.pop()
                }
            }
        }

        return stack.isEmpty()
    }
}

fun main() {
    // Input
    val s = "()"
    // Output
    LeetCode_20().isValid(s).let {
        println(it)
        require(it)
    }
}
