package array

class LeetCode_904 {

    fun totalFruit(fruits: IntArray): Int {
        var maxFruits = 0

        var startIndex = 0

        val fruitMap = hashMapOf<Int, Int>()

        fruits.forEachIndexed { index, fruit ->
            fruitMap.merge(fruit, 1) { a, b -> a + b }

            while (fruitMap.size > 2) {
                val firstFruit = fruits[startIndex]

                fruitMap.merge(firstFruit, 1) { a, b -> a - b }

                if (fruitMap[firstFruit] == 0) {
                    fruitMap.remove(firstFruit)
                }

                startIndex++
            }

            maxFruits = maxOf(maxFruits, index - startIndex + 1)
        }

        return maxFruits
    }
}

fun main() {
    // Input
    val fruits = intArrayOf(1, 2, 1)
    // Output
    LeetCode_904().totalFruit(fruits).let {
        println(it)
        require(it == 3)
    }
}
