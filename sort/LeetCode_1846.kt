package sort

class LeetCode_1846 {

    fun maximumElementAfterDecrementingAndRearranging(arr: IntArray): Int {
        arr.sort()

        var lastNum = 0

        for (num in arr) {
            if (num > lastNum) {
                lastNum++
            }
        }

        return lastNum
    }
}

fun main() {
    // Input
    val arr = intArrayOf(2, 2, 1, 2, 1)
    // Output
    LeetCode_1846().maximumElementAfterDecrementingAndRearranging(arr).run {
        println(this)
        require(2 == this)
    }
}
