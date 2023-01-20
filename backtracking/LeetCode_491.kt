package backtracking

class LeetCode_491 {

    fun findSubsequences(nums: IntArray): List<List<Int>> {
        val subSequences = mutableListOf<List<Int>>()
        backtracking(mutableListOf(), 0, nums, subSequences)
        return subSequences
    }

    private fun backtracking(list: MutableList<Int>, index: Int, nums: IntArray, subSequences: MutableList<List<Int>>) {
        if (list.size > 1) {
            subSequences.add(list.toList())
        }

        val visited = hashSetOf<Int>()

        for (i in index until nums.size) {
            if (visited.contains(nums[i])) {
                continue
            }

            if (list.isEmpty() || nums[i] >= list.last()) {
                visited.add(nums[i])
                list.add(nums[i])

                backtracking(list, i + 1, nums, subSequences)

                list.removeLast()
            }
        }
    }
}

fun main() {
    // Input
    val nums = intArrayOf(4, 6, 7, 7)
    // Output
    LeetCode_491().findSubsequences(nums).let {
        println(it)
        require(
            listOf(
                listOf(4, 6),
                listOf(4, 6, 7),
                listOf(4, 6, 7, 7),
                listOf(4, 7),
                listOf(4, 7, 7),
                listOf(6, 7),
                listOf(6, 7, 7),
                listOf(7, 7)
            ) == it
        )
    }
}
