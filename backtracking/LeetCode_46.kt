package backtracking

class LeetCode_46 {

    fun permute(nums: IntArray): List<List<Int>> {
        val resultList = mutableListOf<List<Int>>()
        findPermutation(resultList, mutableListOf(), nums)
        return resultList
    }

    private fun findPermutation(resultList: MutableList<List<Int>>, currentList: MutableList<Int>, nums: IntArray) {
        if (currentList.size == nums.size) {
            resultList.add(currentList.toList())
            return
        }

        nums.forEach {
            if (currentList.contains(it)) {
                return@forEach
            }
            currentList.add(it)
            findPermutation(resultList, currentList, nums)
            currentList.removeLast()
        }
    }
}

fun main() {
    // Input
    val nums = intArrayOf(1, 2, 3)
    // Output
    LeetCode_46().permute(nums).run {
        println(this)
        require(
            listOf(
                listOf(1, 2, 3),
                listOf(1, 3, 2),
                listOf(2, 1, 3),
                listOf(2, 3, 1),
                listOf(3, 1, 2),
                listOf(3, 2, 1)
            ) == this
        )
    }
}
