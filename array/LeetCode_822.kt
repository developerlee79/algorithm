package array

class LeetCode_822 {

    fun flipgame(fronts: IntArray, backs: IntArray): Int {
        val cardSet = hashSetOf<Int>()

        val n = fronts.size

        for (i in 0 until n) {
            if (fronts[i] == backs[i]) {
                cardSet.add(fronts[i])
            }
        }

        var minGoodInteger = Int.MAX_VALUE

        for (i in 0 until n) {
            if (!cardSet.contains(fronts[i])) {
                minGoodInteger = minOf(minGoodInteger, fronts[i])
            }

            if (!cardSet.contains(backs[i])) {
                minGoodInteger = minOf(minGoodInteger, backs[i])
            }
        }

        return if (minGoodInteger == Int.MAX_VALUE) 0 else minGoodInteger
    }
}

fun main() {
    // Input
    val fronts = intArrayOf(1, 2, 4, 4, 7)
    val backs = intArrayOf(1, 3, 4, 1, 3)
    // Output
    LeetCode_822().flipgame(fronts, backs).run {
        println(this)
        require(2 == this)
    }
}
