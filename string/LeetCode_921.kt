package string

import java.util.Stack

class LeetCode_921 {

    fun minAddToMakeValid(s: String): Int {
        val parenthesesStack = Stack<Char>()

        s.forEach {
            if (parenthesesStack.isEmpty()) {
                parenthesesStack.add(it)
            } else {
                if (it == ')' && parenthesesStack.peek() == '(') {
                    parenthesesStack.pop()
                } else {
                    parenthesesStack.add(it)
                }
            }
        }

        return parenthesesStack.size
    }
}

fun main() {
    // Input
    val s = "())"
    // Output
    LeetCode_921().minAddToMakeValid(s).let {
        println(it)
        require(it == 1)
    }
}
