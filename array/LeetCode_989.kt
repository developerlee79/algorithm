package array

import java.util.LinkedList

class LeetCode_989 {

    fun addToArrayForm(num: IntArray, k: Int): List<Int> {
        val result = LinkedList<Int>()

        var i = num.lastIndex
        var j = k

        while (i >= 0 || j > 0) {
            val added = if (i >= 0) num[i] + j else j
            result.addFirst(added % 10)
            j = added / 10
            i--
        }

        return result
    }
}

fun main() {
    // Input
    val num = intArrayOf(1, 2, 0, 0)
    val k = 34
    // Output
    LeetCode_989().addToArrayForm(num, k).let {
        println(it)
        require(
            listOf(1, 2, 3, 4) == it
        )
    }
}
