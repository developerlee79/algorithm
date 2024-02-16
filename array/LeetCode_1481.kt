package array

class LeetCode_1481 {

    fun findLeastNumOfUniqueInts(arr: IntArray, k: Int): Int {
        val frequencyMap = HashMap<Int, Int>()

        arr.forEach { num ->
            frequencyMap.merge(num, 1) { a, b -> a + b }
        }

        var count = frequencyMap.size
        var k = k

        frequencyMap.values.sorted().forEach {
            if (k - it < 0) {
                return@forEach
            }

            k -= it
            count--
        }

        return count
    }
}

fun main() {
    // Input
    val arr = intArrayOf(5, 5, 4)
    val k = 1
    // Output
    LeetCode_1481().findLeastNumOfUniqueInts(arr, k).run {
        println(this)
        require(1 == this)
    }
}
