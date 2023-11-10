package array

class LeetCode_1743 {

    fun restoreArray(adjacentPairs: Array<IntArray>): IntArray {
        if (adjacentPairs.size == 1) {
            return adjacentPairs[0]
        }

        val pairMap = HashMap<Int, MutableList<Int>>()

        for (pair in adjacentPairs) {
            pairMap.computeIfAbsent(pair[0]) { mutableListOf() }.add(pair[1])
            pairMap.computeIfAbsent(pair[1]) { mutableListOf() }.add(pair[0])
        }

        val startPosition = pairMap.keys.find { pairMap[it]!!.size == 1 }!!

        val originList = mutableListOf<Int>()
        val visited = hashSetOf<Int>()

        searchAdjustNumber(pairMap, startPosition, originList, visited)

        return originList.toIntArray()
    }

    private fun searchAdjustNumber(
        pairMap: HashMap<Int, MutableList<Int>>,
        key: Int,
        originList: MutableList<Int>,
        visited: MutableSet<Int>
    ) {
        if (visited.contains(key)) {
            return
        }

        visited.add(key)
        originList.add(key)

        pairMap[key]?.forEach {
            searchAdjustNumber(pairMap, it, originList, visited)
        }
    }

}

fun main() {
    // Input
    val adjacentPairs = arrayOf(
        intArrayOf(2, 1),
        intArrayOf(3, 4),
        intArrayOf(3, 2),
    )
    // Output
    LeetCode_1743().restoreArray(adjacentPairs).run {
        println(this.joinToString())
        require(
            intArrayOf(1, 2, 3, 4).contentEquals(this)
        )
    }
}
