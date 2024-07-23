package sort

class LeetCode_2418 {

    fun sortPeople(names: Array<String>, heights: IntArray): Array<String> {
        val peopleTable = sortedMapOf<Int, String>(compareByDescending { it })

        for (i in names.indices) {
            peopleTable[heights[i]] = names[i]
        }

        return peopleTable.values.toTypedArray()
    }
}

fun main() {
    // Input
    val names = arrayOf("Mary", "John", "Emma")
    val heights = intArrayOf(180, 165, 170)
    // Output
    LeetCode_2418().sortPeople(names, heights).run {
        println(this.joinToString())
        require(
            arrayOf("Mary", "Emma", "John").contentEquals(this)
        )
    }
}
