package tree

class LeetCode_1519 {

    fun countSubTrees(n: Int, edges: Array<IntArray>, labels: String): IntArray {
        val countOfNodes = IntArray(n) { 1 }

        val nodeMap = hashMapOf<Int, MutableList<Int>>()

        edges.forEach {
            nodeMap.computeIfAbsent(it.first()) { mutableListOf() }.add(it.last())
            nodeMap.computeIfAbsent(it.last()) { mutableListOf() }.add(it.first())
        }

        dfs(nodeMap, 0, -1, labels, countOfNodes)

        return countOfNodes
    }

    private fun dfs(nodeMap: HashMap<Int, MutableList<Int>>, currentIndex: Int, nodeParentIndex: Int, labels: String, resultArray: IntArray): IntArray {
        val alphabetArray = IntArray(26)

        nodeMap[currentIndex]?.forEach {
            if (it != nodeParentIndex) {
                val subArray = dfs(nodeMap, it, currentIndex, labels, resultArray)

                repeat(26) { i ->
                    alphabetArray[i] += subArray[i]
                }
            }
        }

        resultArray[currentIndex] = alphabetArray[labels[currentIndex].minus('a')]++ + 1

        return alphabetArray
    }
}

fun main() {
    // Input
    val n = 7
    val edges = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(0, 2),
        intArrayOf(1, 4),
        intArrayOf(1, 5),
        intArrayOf(2, 3),
        intArrayOf(2, 6),
    )
    val labels = "abaedcd"
    // Output
    LeetCode_1519().countSubTrees(n, edges, labels).let {
        println(it.joinToString())
        require(
            intArrayOf(2, 1, 1, 1, 1, 1, 1).contentEquals(it)
        )
    }
}
