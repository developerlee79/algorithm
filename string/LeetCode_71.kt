package string

import java.util.Stack

class LeetCode_71 {

    fun simplifyPath(path: String): String {
        val pathStack = Stack<String>()
        val pathArray = path.split("/")

        pathArray.forEach {
            if (pathStack.isNotEmpty() && it == "..") {
                pathStack.pop()
            } else if (it.isNotBlank() && it != "." && it != "..") {
                pathStack.push(it)
            }
        }

        if (pathStack.isEmpty()) {
            return "/"
        }

        val stringBuilder = StringBuilder()

        while (pathStack.isNotEmpty()) {
            stringBuilder
                .insert(0, "/" + pathStack.pop())
        }

        return stringBuilder.toString()
    }
}

fun main() {
    // Input
    val path = "/home/"
    // Output
    LeetCode_71().simplifyPath(path).let {
        println(it)
        require("/home" == it)
    }
}
