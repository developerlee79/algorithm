package design

import kotlin.random.Random

class LeetCode_380 {

    /**
     * Solution : Map
     * Time Complexity : O(1)
     * Space Complexity : O(N)
    */
    class RandomizedSet {

        private val randomMap = hashMapOf<Int, Int>()
        private val valueList = mutableListOf<Int>()

        fun insert(`val`: Int): Boolean {
            if (randomMap.containsKey(`val`)) {
                return false
            }

            randomMap[`val`] = valueList.size
            return valueList.add(`val`)
        }

        fun remove(`val`: Int): Boolean {
            if (!randomMap.containsKey(`val`)) {
                return false
            }

            val indexOfDeleted = randomMap.remove(`val`)
            val lastValue = valueList.removeLast()

            if (`val` != lastValue) {
                valueList[indexOfDeleted!!] = lastValue
                randomMap[lastValue] = indexOfDeleted
            }

            return true
        }

        fun getRandom(): Int = valueList[Random.nextInt(valueList.size)]
    }

    class RandomizedSetElementAt {

        private val randomSet = hashSetOf<Int>()

        fun insert(`val`: Int): Boolean = randomSet.add(`val`)

        fun remove(`val`: Int): Boolean = randomSet.remove(`val`)

        fun getRandom(): Int = randomSet.elementAt(Random.nextInt(randomSet.size))
    }
}

fun main() {
    // Input
    val randomizedSet = LeetCode_380.RandomizedSet()
    // Output
    require(randomizedSet.insert(1))
    require(!randomizedSet.remove(2))
    require(randomizedSet.insert(2))
    require(randomizedSet.getRandom() in 1 .. 2)
    require(randomizedSet.remove(1))
    require(!randomizedSet.insert(2))
    require(randomizedSet.getRandom() == 2)
}
