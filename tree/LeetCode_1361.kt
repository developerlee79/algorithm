package tree

import java.util.LinkedList
import java.util.Queue

class LeetCode_1361 {

    fun validateBinaryTreeNodes(n: Int, leftChild: IntArray, rightChild: IntArray): Boolean {
        val nodeCount = IntArray(n)

        for (i in 0 until n) {
            if (leftChild[i] != -1) {
                nodeCount[leftChild[i]]++
            }
            if (rightChild[i] != -1) {
                nodeCount[rightChild[i]]++
            }
        }

        var root = -1

        repeat (n) {
            if (nodeCount[it] == 0) {
                if (root == -1) {
                    root = it
                } else {
                    return false
                }
            }
        }

        if (root == -1) {
            return false
        }

        val visited = BooleanArray(n)

        val nodeQueue: Queue<Int> = LinkedList()
        nodeQueue.offer(root)

        while (nodeQueue.isNotEmpty()) {
            val node = nodeQueue.poll()

            if (visited[node]) {
                return false
            }

            visited[node] = true

            if (leftChild[node] != -1) {
                nodeQueue.offer(leftChild[node])
            }

            if (rightChild[node] != -1) {
                nodeQueue.offer(rightChild[node])
            }
        }

        return visited.count { it } == n
    }

}

fun main() {
    // Input
    val n = 4
    val leftChild = intArrayOf(1, -1, 3, -1)
    val rightChild = intArrayOf(2, -1, -1, -1)
    // Output
    LeetCode_1361().validateBinaryTreeNodes(n, leftChild, rightChild).run {
        println(this)
        require(this)
    }
}
