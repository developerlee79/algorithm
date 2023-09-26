package string

import java.util.*
class LeetCode_316 {

    fun removeDuplicateLetters(s: String): String {
        val stack = Stack<Char>()
        val visited = HashSet<Char>()
        val occurrenceMap = HashMap<Char, Int>()

        for (i in s.indices) {
            occurrenceMap[s[i]] = i
        }

        for (i in s.indices) {
            val currentChar = s[i]

            if (!visited.contains(currentChar)) {
                while (stack.isNotEmpty() && currentChar < stack.peek() && i < occurrenceMap[stack.peek()]!!) {
                    visited.remove(stack.pop())
                }

                visited.add(currentChar)
                stack.push(currentChar)
            }
        }

        val stringBuilder = StringBuilder()

        for (i in stack.indices) {
            stringBuilder.append(stack[i])
        }

        return stringBuilder.toString()
    }

}

fun main() {
    // Input
    val s = "bcabc"
    // Output
    LeetCode_316().removeDuplicateLetters(s).run {
        println(this)
        require("abc" == this)
    }
}
