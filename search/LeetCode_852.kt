package search

class LeetCode_852 {

    fun peakIndexInMountainArray(arr: IntArray): Int {
        var low = 0
        var high = arr.lastIndex

        while (low <= high) {
            val middle = (high + low) / 2

            if ((middle == 0 || arr[middle - 1] < arr[middle]) && (middle == arr.lastIndex || arr[middle + 1] < arr[middle])) {
                return middle
            } else if (middle > 0 && arr[middle - 1] > arr[middle]) {
                high = middle - 1
            } else {
                low = middle + 1
            }
        }

        return -1
    }
}

fun main() {
    // Input
    val arr = intArrayOf(0, 2, 1, 0)
    // Output
    LeetCode_852().peakIndexInMountainArray(arr).run {
        println(this)
        require(1 == this)
    }
}
