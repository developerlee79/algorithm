package array

class LeetCode_1450 {

    /**
     * Solution - Iteration
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     *
     * Just.. Simple compare.
     *
     * @param startTime integer array what contains time of started doing student's homework
     * @param endTime integer array what contains time of finished doing student's homework
     * @param queryTime integer
     * @return number of students doing their homework at time queryTime
     */
    fun busyStudent(startTime: IntArray, endTime: IntArray, queryTime: Int): Int {
        return startTime.filterIndexed { index, time ->
            time <= queryTime && endTime[index] >= queryTime
        }.size
    }
}

fun main() {
    val startTime = intArrayOf(1, 2, 3)
    val endTime = intArrayOf(3, 2, 7)
    val queryTime = 4
    println(LeetCode_1450().busyStudent(startTime, endTime, queryTime))
}
