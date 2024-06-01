package array

class LeetCode_1940 {

    fun longestCommonSubsequence(arrays: Array<IntArray>): List<Int> {
        if (arrays.isEmpty()) {
            return emptyList()
        }

        var lcs = arrays[0]

        for (array in arrays.drop(1)) {
            lcs = intersection(lcs, array)

            if (lcs.isEmpty()) {
                break
            }
        }

        return lcs.toList()
    }

    private fun intersection(arr1: IntArray, arr2: IntArray): IntArray {
        var i = 0
        var j = 0

        val result = mutableListOf<Int>()

        while (i < arr1.size && j < arr2.size) {
            if (arr1[i] == arr2[j]) {
                result.add(arr1[i])
                i++
                j++
            } else if (arr1[i] < arr2[j]) {
                i++
            } else {
                j++
            }
        }

        return result.toIntArray()
    }
}

fun main() {
    // Input
    val arrays = arrayOf(
        intArrayOf(1, 3, 4),
        intArrayOf(1, 4, 7, 9)
    )
    // Output
    LeetCode_1940().longestCommonSubsequence(arrays).run {
        println(this)
        require(
            listOf(1, 4) == this
        )
    }
}
