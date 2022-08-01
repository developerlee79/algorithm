package array

class LeetCode_275 {

    /**
     * Solution - Binary Search
     * Time Complexity : O(logN)
     * Space Complexity : O(1)
     *
     * Finds the H-index by binary search.
     * Returns the median immediately if the current median is equal to the remaining length.
     * Because it is an ordered array, the remaining length is unconditionally greater than the median, and the next value is greater than the median, so it can never be H-index.
     * If it is greater than or equal to the median value, continue with the binary search.
     *
     * @param citations array of sorted in ascending order which number of citations a researcher received for their paper and citations
     * @return h-index* of researcher
     *    * h-index : the maximum value of h such that the given author/journal has published at least h papers that have each been cited at least h times
     */
    fun hIndex(citations: IntArray): Int {
        val len = citations.size

        var left = 0
        var right = len - 1

        while (left <= right) {
            val mid = (left + right) / 2

            if (citations[mid] == len - mid) {
                return citations[mid]
            }

            if (citations[mid] > len - mid) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }

        return len - left
    }
}

fun main() {
    val citations = intArrayOf(0, 1, 3, 5, 6)
    println(LeetCode_275().hIndex(citations))
}
