package two_pointers

class LeetCode_455 {

    fun findContentChildren(g: IntArray, s: IntArray): Int {
        g.sort()
        s.sort()

        var contentedChildren = 0
        var cookieIndex = 0

        val n = s.size

        for (child in g) {
            while (cookieIndex < n && s[cookieIndex] < child) {
                cookieIndex++
            }

            if (cookieIndex < n) {
                contentedChildren++
                cookieIndex++
            } else {
                break
            }
        }

        return contentedChildren
    }
}

fun main() {
    // Input
    val g = intArrayOf(1, 2, 3)
    val s = intArrayOf(1, 1)
    // Output
    LeetCode_455().findContentChildren(g, s).run {
        println(this)
        require(1 == this)
    }
}
