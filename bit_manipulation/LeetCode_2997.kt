package bit_manipulation

class LeetCode_2997 {

    fun minOperations(nums: IntArray, k: Int): Int {
        val xorValue = nums.calculateXOR()

        var smallerValue = minOf(k, xorValue)
        var biggerValue = maxOf(k, xorValue)

        var operations = 0

        while (biggerValue > 0) {
            if (smallerValue.and(1) != biggerValue.and(1)) {
                operations++
            }

            if (smallerValue > 0) {
                smallerValue = smallerValue.shr(1)
            }

            biggerValue = biggerValue.shr(1)
        }

        return operations
    }

    private fun IntArray.calculateXOR(): Int {
        var xorValue = this[0]

        for (i in 1 until this.size) {
            xorValue = xorValue.xor(this[i])
        }

        return xorValue
    }
}

fun main() {
    // Input
    val nums = intArrayOf(2, 1, 3, 4)
    val k = 1
    // Output
    LeetCode_2997().minOperations(nums, k).run {
        println(this)
        require(2 == this)
    }
}
