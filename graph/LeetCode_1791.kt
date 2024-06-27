package graph

class LeetCode_1791 {

    fun findCenter(edges: Array<IntArray>) =
        if (edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1]) edges[0][0] else edges[0][1]
}

fun main() {
    // Input
    val edges = arrayOf(
        intArrayOf(1, 2),
        intArrayOf(2, 3),
        intArrayOf(4, 2)
    )
    // Output
    LeetCode_1791().findCenter(edges).run {
        println(this)
        require(2 == this)
    }
}
