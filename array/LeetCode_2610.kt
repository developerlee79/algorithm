package array

class LeetCode_2610 {

    fun findMatrix(nums: IntArray): List<List<Int>> {
        val matrix = mutableListOf<MutableList<Int>>()
        val frequencyMap = HashMap<Int, Int>()

        for (num in nums) {
            frequencyMap.merge(num, 1) { a, b -> a + b }

            if (matrix.size == frequencyMap[num]!! - 1) {
                matrix.add(mutableListOf())
            }

            matrix[frequencyMap[num]!! - 1].add(num)
        }

        return matrix
    }
}

fun main() {
    // Input
    val nums = intArrayOf(1, 3, 4, 1, 2, 3, 1)
    // Output
    LeetCode_2610().findMatrix(nums).run {
        println(this)
        require(
            listOf(
                listOf(1, 3, 4, 2),
                listOf(1, 3),
                listOf(1)
            ) == this
        )
    }
}
