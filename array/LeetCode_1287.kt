package array

class LeetCode_1287 {

    fun findSpecialInteger(arr: IntArray): Int {
        val n = arr.size
        val divide = n / 4

        var i = 0

        while (i < n - divide) {
            val currentValue = arr[i]

            if (currentValue == arr[i + divide]) {
                return currentValue
            }

            while (i < n && currentValue == arr[i]) {
                i++
            }
        }

        return -1
    }
}

fun main() {
    // Input
    val arr = intArrayOf(1, 2, 2, 6, 6, 6, 6, 7, 10)
    // Output
    LeetCode_1287().findSpecialInteger(arr).run {
        println(this)
        require(6 == this)
    }
}
