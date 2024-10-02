package array

class LeetCode_1133 {

    fun largestUniqueNumber(nums: IntArray): Int {
        val numberMap = hashMapOf<Int, Int>()

        nums.forEach { num ->
            numberMap.merge(num, 1) { a, b -> a + b }
        }

        var largestUnique = -1

        numberMap.forEach { (num, occurrence) ->
            if (occurrence != 1) {
                return@forEach
            }

            largestUnique = maxOf(largestUnique, num)
        }

        return largestUnique
    }
}

fun main() {
    // Input
    val nums = intArrayOf(5, 7, 3, 9, 4, 9, 8, 3, 1)
    // Output
    LeetCode_1133().largestUniqueNumber(nums).run {
        println(this)
        require(8 == this)
    }
}
