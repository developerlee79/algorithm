package string

class LeetCode_1614 {

    fun maxDepth(s: String): Int {
        var maximumDepth = 0
        var currentDepth = 0

        s.forEach { char ->
            if (char == '(') {
                currentDepth++
            } else if (char == ')') {
                maximumDepth = maxOf(maximumDepth, currentDepth)
                currentDepth--
            }
        }

        return maximumDepth
    }
}

fun main() {
    // Input
    val s = "(1+(2*3)+((8)/4))+1"
    // Output
    LeetCode_1614().maxDepth(s).run {
        println(this)
        require(3 == this)
    }
}
