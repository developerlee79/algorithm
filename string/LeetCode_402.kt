package string

import java.util.Stack

class LeetCode_402 {

    fun removeKdigits(num: String, k: Int): String {
        val n = num.length

        if (k == n) {
            return "0"
        }

        val stack = Stack<Char>()
        var k = k

        num.forEach {
            while (k > 0 && stack.isNotEmpty() && stack.peek() > it) {
                stack.pop()
                k--
            }

            stack.push(it)
        }

        repeat(k) {
            stack.pop()
        }

        val digitStringBuilder = StringBuilder()

        while (stack.isNotEmpty()) {
            digitStringBuilder.append(stack.pop())
        }

        digitStringBuilder.reverse()

        while (digitStringBuilder.length > 1 && digitStringBuilder.first() == '0') {
            digitStringBuilder.deleteAt(0)
        }

        return digitStringBuilder.toString()
    }
}

fun main() {
    // Input
    val num = "1432219"
    val k = 3
    // Output
    LeetCode_402().removeKdigits(num, k).run {
        println(this)
        require("1219" == this)
    }
}
