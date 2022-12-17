package string

import java.util.Stack

class LeetCode_150 {

    fun evalRPN(tokens: Array<String>): Int {
        val operations = arrayOf("+", "-", "*", "/")

        val stack = Stack<Int>()

        tokens.forEach { token ->
            if (operations.contains(token)) {
                val number1 = stack.pop()
                val number2 = stack.pop()

                when (token) {
                    "+" -> stack.push(number2 + number1)
                    "-" -> stack.push(number2 - number1)
                    "*" -> stack.push(number2 * number1)
                    "/" -> stack.push(number2 / number1)
                }
            } else {
                stack.push(token.toInt())
            }
        }

        return stack.peek()
    }
}

fun main() {
    // Input
    val tokens = arrayOf(
        "2", "1", "+", "3", "*"
    )
    // Output
    LeetCode_150().evalRPN(tokens).let {
        println(it)
        require(it == 9)
    }
}
