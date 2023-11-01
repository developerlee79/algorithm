package tree

import util.TreeNode

class LeetCode_501 {

    fun findMode(root: TreeNode?): IntArray {
        val frequencyMap = hashMapOf<Int, Int>()
        val maxValue = constructFrequencyMap(root, frequencyMap, 0)

        val modeList = mutableListOf<Int>()

        frequencyMap.forEach { (key, value) ->
            if (value == maxValue) {
                modeList.add(key)
            }
        }

        return modeList.toIntArray()
    }

    private fun constructFrequencyMap(node: TreeNode?, frequencyMap: HashMap<Int, Int>, maxValue: Int): Int {
        if (node == null) {
            return maxValue
        }

        val currentMaxValue = maxOf(
            maxValue,
            frequencyMap.merge(node.`val`, 1) { a, b -> a + b }!!
        )

        return maxOf(
            currentMaxValue,
            constructFrequencyMap(node.left, frequencyMap, currentMaxValue),
            constructFrequencyMap(node.right, frequencyMap, currentMaxValue)
        )
    }
}

fun main() {
    // Input
    val root = TreeNode.of(1, null, 2, 2)
    // Output
    LeetCode_501().findMode(root).run {
        println(this.joinToString())
        require(
            intArrayOf(2).contentEquals(this)
        )
    }
}
