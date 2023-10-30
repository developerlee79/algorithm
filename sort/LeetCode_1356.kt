package sort

class LeetCode_1356 {

    fun sortByBits(arr: IntArray): IntArray {
        val comparator = Comparator<Int> { num1, num2 ->
            val bitCount1 = num1.countOneBits()
            val bitCount2 = num2.countOneBits()

            if (bitCount1 == bitCount2) {
                num1.compareTo(num2)
            } else {
                bitCount1.compareTo(bitCount2)
            }
        }

        return arr.sortedWith(comparator).toIntArray()
    }
}

fun main() {
    // Input
    val arr = intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8)
    // Output
    LeetCode_1356().sortByBits(arr).run {
        println(this)
        require(
            intArrayOf(0, 1, 2, 4, 8, 3, 5, 6, 7).contentEquals(this)
        )
    }
}
