package sort

class LeetCode_1921 {

    fun eliminateMaximum(dist: IntArray, speed: IntArray): Int {
        val arrivalTime = IntArray(dist.size)

        for (i in dist.indices) {
            arrivalTime[i] = (dist[i] - 1) / speed[i]
        }

        arrivalTime.sort()

        for (i in dist.indices) {
            if (i > arrivalTime[i]) {
                return i
            }
        }

        return dist.size
    }

}

fun main() {
    // Input
    val dist = intArrayOf(1, 3, 4)
    val speed = intArrayOf(1, 1, 1)
    // Output
    LeetCode_1921().eliminateMaximum(dist, speed).run {
        println(this)
        require(3 == this)
    }
}
