package string

import java.util.Stack

class LeetCode_1249 {

    fun minRemoveToMakeValid(s: String): String {
        val validParenthesisBuilder = StringBuilder()

        val stack = Stack<Int>()

        s.forEach { c ->
            if (c == '(') {
                validParenthesisBuilder.append(c)
                stack.push(validParenthesisBuilder.lastIndex)
            } else if (c == ')') {
                if (stack.isNotEmpty()) {
                    validParenthesisBuilder.append(c)
                    stack.pop()
                }
            } else {
                validParenthesisBuilder.append(c)
            }
        }

        while (stack.isNotEmpty()) {
            validParenthesisBuilder.deleteAt(stack.pop())
        }

        return validParenthesisBuilder.toString()
    }
}

fun main() {
    // Input
    val s = "lee(t(c)o)de)"
    // Output
    LeetCode_1249().minRemoveToMakeValid(s).run {
        println(this)
        require("lee(t(c)o)de" == this)
    }
}
