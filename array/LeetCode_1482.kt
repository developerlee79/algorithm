package array

class LeetCode_1482 {

    fun minDays(bloomDay: IntArray, m: Int, k: Int): Int {
        if (m.toLong() * k > bloomDay.size) {
            return -1
        }

        var low = 1
        var high = Integer.MAX_VALUE

        while (low < high) {
            val mid = low + (high - low) / 2

            if (isPossibleBouquets(bloomDay, m, k, mid)) {
                high = mid
            } else {
                low = mid + 1
            }
        }

        return low
    }

    private fun isPossibleBouquets(bloomDay: IntArray, m: Int, k: Int, day: Int): Boolean {
        var total = 0
        var i = 0

        val dayRange = bloomDay.indices

        while (i in dayRange) {
            var count = 0

            while (i in dayRange && count < k && bloomDay[i] <= day) {
                count++
                i++
            }

            if (count == k) {
                total++
                i--
            }

            if (total == m) {
                return true
            }

            i++
        }

        return false
    }
}

fun main() {
    // Input
    val bloomDay = intArrayOf(1, 10, 3, 10, 2)
    val m = 3
    val k = 1
    // Output
    LeetCode_1482().minDays(bloomDay, m, k).run {
        println(this)
        require(3 == this)
    }
}
