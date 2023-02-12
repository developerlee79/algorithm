package graph

class LeetCode_2477 {

    private var count: Long = 0

    fun minimumFuelCost(roads: Array<IntArray>, seats: Int): Long {
        val graph = Array(roads.size + 1) { mutableListOf<Int>() }

        roads.forEach {
            graph[it.first()].add(it.last())
            graph[it.last()].add(it.first())
        }

        search(0, -1, seats, graph)

        return count
    }

    private fun search(index: Int, prev: Int, seats: Int, graph: Array<MutableList<Int>>): Int {
        var people = 1

        graph[index].forEach {
            if (it != prev) {
                people += search(it, index, seats, graph)
            }
        }

        if (index > 0) {
            count += (people + seats - 1) / seats
        }

        return people
    }
}

fun main() {
    // Input
    val roads = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(0, 2),
        intArrayOf(0, 3)
    )
    val seats = 5
    // Output
    LeetCode_2477().minimumFuelCost(roads, seats).let {
        println(it)
        require(it == 3L)
    }
}
