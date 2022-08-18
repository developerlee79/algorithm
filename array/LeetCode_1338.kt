package array

class LeetCode_1338 {

    /**
     * Solution - Frequency Map
     * Time Complexity : O(NlogN)
     * Space Complexity : O(N)
     *
     * Save frequency of given array at frequency map and count values in descending order to find min size.
     *
     * @param arr integer array
     * @return minimum size of the set so that at least half of the integers of the array are removed
    */
    fun minSetSize(arr: IntArray): Int {
        val frequencyMap = mutableMapOf<Int, Int>()
        arr.forEach { frequencyMap.merge(it, 1) {a, b -> a + b} }

        var count = arr.size
        val halfLength = arr.size / 2
        var minSize = 1

        frequencyMap.values.sortedDescending().forEach {
            count -= it

            if (count <= halfLength) {
                return minSize
            }

            minSize++
        }

        return minSize
    }
}

fun main() {
    val arr = intArrayOf(3, 3, 3, 3, 5, 5, 5, 2, 2, 7)
    println(LeetCode_1338().minSetSize(arr))
}
