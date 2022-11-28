package dp

class LeetCode_2225 {

    /**
     * Solution : Map
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * @param matches integer array where matches[i] = [winneri, loseri] indicates that the player winneri defeated player loseri in a match
     * @return Return a list [list of all players that have not lost any matches / list of all players that have lost exactly one match]
    */
    fun findWinners(matches: Array<IntArray>): List<List<Int>> {
        val matchMap = hashMapOf<Int, Int>()

        for (match in matches) {
            if (!matchMap.containsKey(match.first()))
                matchMap[match.first()] = 0

            matchMap[match.last()] =
                if (matchMap.containsKey(match.last()))
                    matchMap[match.last()]!! + 1
                else 1
        }

        val winners = mutableListOf<Int>()
        val losers = mutableListOf<Int>()

        matchMap.forEach { (key, value) ->
            if (value == 0)
                winners.add(key)
            else if (value == 1)
                losers.add(key)
        }

        return listOf(winners.sorted(), losers.sorted())
    }
}

fun main() {
    // Input
    val matches = arrayOf(
        intArrayOf(1, 3),
        intArrayOf(2, 3),
        intArrayOf(3, 6),
        intArrayOf(5, 6),
        intArrayOf(5, 7),
        intArrayOf(4, 5),
        intArrayOf(4, 8),
        intArrayOf(4, 9),
        intArrayOf(10, 4),
        intArrayOf(10, 9),
    )
    // Output
    val result = LeetCode_2225().findWinners(matches)
    println(result)
    require(
        listOf(
            listOf(1, 2, 10),
            listOf(4, 5, 7, 8)
        ) == result
    )
}
