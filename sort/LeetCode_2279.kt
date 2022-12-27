package sort

class LeetCode_2279 {

    fun maximumBags(capacity: IntArray, rocks: IntArray, additionalRocks: Int): Int {
        val sortedRock = IntArray(capacity.size)

        rocks.forEachIndexed { index, rock ->
            sortedRock[index] = capacity[index] - rock
        }

        sortedRock.sort()

        var additionalRocks = additionalRocks
        var numberOfFullBag = 0
        var i = 0

        while (i < sortedRock.size && additionalRocks >= 0) {
            if (sortedRock[i] <= additionalRocks) {
                numberOfFullBag++
                additionalRocks -= sortedRock[i++]
            } else {
                break
            }
        }

        return numberOfFullBag
    }
}

fun main() {
    // Input
    val capacity = intArrayOf(2, 3, 4, 5)
    val rocks = intArrayOf(1, 2, 4, 4)
    val additionalRocks = 2
    // Output
    LeetCode_2279().maximumBags(capacity, rocks, additionalRocks).let {
        println(it)
        require(it == 3)
    }
}
