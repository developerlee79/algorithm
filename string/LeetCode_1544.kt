package string

import java.util.Stack
import kotlin.math.abs

class LeetCode_1544 {

    fun makeGood(s: String): String {
        val stack = Stack<Char>()

        s.forEach { c ->
            if (stack.isNotEmpty() && isBadString(c, stack.peek())) {
                stack.pop()
            } else {
                stack.push(c)
            }
        }

        val goodStringBuilder = StringBuilder()

        stack.forEach {
            goodStringBuilder.append(it)
        }

        return goodStringBuilder.toString()
    }

    private fun isBadString(firstChar: Char, secondChar: Char) = abs(firstChar - secondChar) == 32
}

fun main() {
    // Input
    val s = "leEeetcode"
    // Output
    LeetCode_1544().makeGood(s).run {
        println(this)
        require("leetcode" == this)
    }
}
