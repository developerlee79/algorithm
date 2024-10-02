package array

import java.util.TreeMap

class LeetCode_1331 {

    fun arrayRankTransform(arr: IntArray): IntArray {
        val rankMap = TreeMap<Int, MutableList<Int>>()

        arr.forEachIndexed { index, num ->
            rankMap.computeIfAbsent(num) { mutableListOf() }
                .add(index)
        }

        val rankArray = IntArray(arr.size)

        var rank = 1

        rankMap.values.forEach { valueList ->
            valueList.forEach { index ->
                rankArray[index] = rank
            }

            rank++
        }

        return rankArray
    }
}

fun main() {
    // Input
    val arr = intArrayOf(40, 10, 20, 30)
    // Output
    LeetCode_1331().arrayRankTransform(arr).run {
        println(this.joinToString())
        require(
            intArrayOf(4, 1, 2, 3).contentEquals(this)
        )
    }
}
