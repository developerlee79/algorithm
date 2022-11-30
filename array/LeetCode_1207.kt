package array

class LeetCode_1207 {

    /**
     * Solution : Frequency Map
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * @param arr array of integers
     * @return return true if the number of occurrences of each value in the array is unique, or false otherwise
    */
    fun uniqueOccurrences(arr: IntArray): Boolean {
        val frequencyMap = hashMapOf<Int, Int>()

        arr.forEach {
            frequencyMap.merge(it, 1) { a, b -> a + b }
        }

        val frequencySet = hashSetOf<Int>()

        return frequencyMap.values.all { frequencySet.add(it) }
    }
}

fun main() {
    // Input
    val arr = intArrayOf(1, 2, 2, 1, 1, 3)
    // Output
    val result = LeetCode_1207().uniqueOccurrences(arr)
    println(result)
    require(result)
}
