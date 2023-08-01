package backtracking

class LeetCode_77 {

    fun combine(n: Int, k: Int): List<List<Int>> {
        val resultList = mutableListOf<List<Int>>()
        findCombinations(1, n, k, mutableListOf(), resultList)
        return resultList
    }

    private fun findCombinations(
        number: Int,
        n: Int,
        k: Int,
        currentList: MutableList<Int>,
        resultList: MutableList<List<Int>>
    ) {
        if (currentList.size == k) {
            resultList.add(currentList.toList())
            return
        }

        for (i in number .. n) {
            currentList.add(i)
            findCombinations(i + 1, n, k, currentList, resultList)
            currentList.removeAt(currentList.lastIndex)
        }
    }
}

fun main() {
    // Input
    val n = 4
    val k = 2
    // Output
    LeetCode_77().combine(n, k).run {
        println(this)
        require(
            listOf(
                listOf(1, 2),
                listOf(1, 3),
                listOf(1, 4),
                listOf(2, 3),
                listOf(2, 4),
                listOf(3, 4)
            ) == this
        )
    }
}
