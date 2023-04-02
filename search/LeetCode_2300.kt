package search

class LeetCode_2300 {

    fun successfulPairs(spells: IntArray, potions: IntArray, success: Long): IntArray {
        val successfulSpells = IntArray(spells.size)

        potions.sort()

        val n = potions.size

        spells.forEachIndexed { i, spell ->
            successfulSpells[i] = n - getHighestPoint(spell, success, potions)
        }

        return successfulSpells
    }

    private fun getHighestPoint(spell: Int, success: Long, potions: IntArray): Int {
        var low = 0
        var high = potions.lastIndex

        while (low <= high) {
            val mid = (high - low) / 2 + low
            val currentPoint = spell * potions[mid].toLong()

            if (currentPoint >= success) {
                high = mid - 1
            } else {
                low = mid + 1
            }
        }

        return low
    }
}

fun main() {
    // Input
    val spells = intArrayOf(5, 1, 3)
    val potions = intArrayOf(1, 2, 3, 4, 5)
    val success = 7L
    // Output
    LeetCode_2300().successfulPairs(spells, potions, success).let {
        println(it.joinToString())
        require(
            intArrayOf(4, 0, 3).contentEquals(it)
        )
    }
}
