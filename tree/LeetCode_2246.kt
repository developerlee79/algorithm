package tree

import java.util.PriorityQueue

class LeetCode_2246 {

    private var longestPath = 0

    fun longestPath(parent: IntArray, s: String): Int {
        val children = Array<MutableList<Int>>(parent.size) { mutableListOf() }

        for (i in 1 until parent.size) {
            children[parent[i]].add(i)
        }

        dfs(
            children = children,
            index = 0,
            targetString = s
        )

        return longestPath
    }

    private fun dfs(children: Array<MutableList<Int>>, index: Int, targetString: String): Int {
        val priorityQueue = PriorityQueue<Int>()

        children[index].forEach {
            val currentNode = dfs(children, it, targetString)

            if (targetString[index] != targetString[it]) {
                priorityQueue.add(-currentNode)
            }
        }

        val biggerNode = if (priorityQueue.isNotEmpty()) -priorityQueue.poll() else 0
        val secondBiggerNode = if (priorityQueue.isNotEmpty()) -priorityQueue.poll() else 0

        longestPath = longestPath.coerceAtLeast(
            biggerNode + secondBiggerNode + 1
        )

        return biggerNode + 1
    }
}

fun main() {
    // Input
    val parent = intArrayOf(-1, 0, 0, 1, 1, 2)
    val s = "abacbe"
    // Output
    LeetCode_2246().longestPath(parent, s).let {
        println(it)
        require(it == 3)
    }
}
