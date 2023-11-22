package array

class LeetCode_1424 {

    fun findDiagonalOrder(nums: List<List<Int>>): IntArray {
        val diagonalOrderMap = HashMap<Int, MutableList<Int>>()

        for (i in nums.indices) {
            for (j in nums[i].indices) {
                diagonalOrderMap.computeIfAbsent(i + j) { mutableListOf() }.add(nums[i][j])
            }
        }

        val diagonalOrderList = mutableListOf<Int>()

        var i = 0

        while (diagonalOrderMap.containsKey(i)) {
            diagonalOrderList.addAll(diagonalOrderMap[i]!!.reversed())
            i++
        }

        return diagonalOrderList.toIntArray()
    }
}

fun main() {
    // Input
    val nums = listOf(
        listOf(1, 2, 3),
        listOf(4, 5, 6),
        listOf(7, 8, 9),
    )
    // Output
    LeetCode_1424().findDiagonalOrder(nums).run {
        println(this.joinToString())
        require(intArrayOf(1, 4, 2, 7, 5, 3, 8, 6, 9).contentEquals(this))
    }
}
