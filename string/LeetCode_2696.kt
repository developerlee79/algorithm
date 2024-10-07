package string

import java.util.Stack

class LeetCode_2696 {

    fun minLength(s: String): Int {
        val stack = Stack<Char>()

        s.forEach { char ->
            if (stack.isEmpty()) {
                stack.push(char)
                return@forEach
            }

            if (char == 'B' && stack.peek() == 'A') {
                stack.pop()
            } else if (char == 'D' && stack.peek() == 'C') {
                stack.pop()
            } else {
                stack.push(char)
            }
        }

        return stack.size
    }
}

fun main() {
    // Input
    val s = "ABFCACDB"
    // Output
    LeetCode_2696().minLength(s).run {
        println(this)
        require(2 == this)
    }
}
