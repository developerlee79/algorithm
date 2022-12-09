package util

import java.util.LinkedList
import java.util.Queue

data class TreeNode(var `val`: Int) {

    var left: TreeNode? = null
    var right: TreeNode? = null

    override fun toString(): String {
        val stringBuilder = StringBuilder("TreeNode = [ ")
        search(this, stringBuilder)
        return stringBuilder.append("]").toString()
    }

    private fun search(node: TreeNode?, stringBuilder: StringBuilder) {
        if (node == null) {
            stringBuilder.append("null ")
            return
        }

        stringBuilder.append("${node.`val`} ")

        search(node.left, stringBuilder)
        search(node.right, stringBuilder)
    }

    companion object {

        /**
         * Returns root [TreeNode] of binary tree which created according to the given integer vararg [values]
         */
        fun of(vararg values: Int?): TreeNode? {
            if (values.isEmpty() || values.first() == null) {
                return null
            }

            val nodeQueue: Queue<TreeNode> = LinkedList()
            val valueQueue: Queue<Int> = LinkedList()

            for(i in 1 until values.size) {
                valueQueue.add(values[i])
            }

            val root = TreeNode(values.first()!!)
            nodeQueue.add(root)

            while (valueQueue.isNotEmpty()) {
                val currentNode = nodeQueue.poll()

                val leftValue = if (valueQueue.isNotEmpty()) {
                    valueQueue.poll()
                } else {
                    null
                }

                val rightValue = if (valueQueue.isNotEmpty()) {
                    valueQueue.poll()
                } else {
                    null
                }

                leftValue?.let {
                    currentNode.left = TreeNode(it)
                    nodeQueue.add(currentNode.left)
                }

                rightValue?.let {
                    currentNode.right = TreeNode(it)
                    nodeQueue.add(currentNode.right)
                }
            }

            return root
        }
    }
}
