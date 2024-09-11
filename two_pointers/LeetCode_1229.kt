package two_pointers

class LeetCode_1229 {

    fun minAvailableDuration(slots1: Array<IntArray>, slots2: Array<IntArray>, duration: Int): List<Int> {
        slots1.sortBy { it[0] }
        slots2.sortBy { it[0] }

        val n = slots1.size
        val m = slots2.size

        var pointerOne = 0
        var pointerTwo = 0

        while (pointerOne < n && pointerTwo < m) {
            val slotOne = slots1[pointerOne]
            val slotTwo = slots2[pointerTwo]

            val leftMax = maxOf(slotOne[0], slotTwo[0])
            val rightMin = minOf(slotOne[1], slotTwo[1])

            if (leftMax + duration <= rightMin) {
                return listOf(leftMax, leftMax + duration)
            }

            if (slotOne[1] <= slotTwo[1]) {
                pointerOne++
            } else {
                pointerTwo++
            }
        }

        return emptyList()
    }
}

fun main() {
    // Input
    val slots1 = arrayOf(
        intArrayOf(10, 50),
        intArrayOf(60, 120),
        intArrayOf(140, 210)
    )
    val slots2 = arrayOf(
        intArrayOf(0, 15),
        intArrayOf(60, 70)
    )
    val duration = 8
    // Output
    LeetCode_1229().minAvailableDuration(slots1, slots2, duration).run {
        println(this)
        require(
            listOf(60, 68) == this
        )
    }
}
