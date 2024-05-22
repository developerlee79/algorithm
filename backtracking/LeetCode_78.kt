package backtracking

class LeetCode_78 {

    fun subsets(nums: IntArray): List<List<Int>> {
        val subsetList = mutableListOf<List<Int>>()
        subsetList.add(listOf())

        nums.forEach { num ->
            val n = subsetList.size

            repeat (n) {
                val subset = subsetList[it].toMutableList()
                subset.add(num)
                subsetList.add(subset)
            }
        }

        return subsetList
    }
}

fun main() {
    // Input
    val nums = intArrayOf(1, 2, 3)
    // Output
    LeetCode_78().subsets(nums).run {
        println(this)
        require(
            listOf(
                listOf(),
                listOf(1),
                listOf(2),
                listOf(1, 2),
                listOf(3),
                listOf(1, 3),
                listOf(2, 3),
                listOf(1, 2, 3)
            ) == this
        )
    }
}
