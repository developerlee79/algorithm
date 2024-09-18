package sort

class LeetCode_179 {

    private val largestNumberOrder = Comparator<String> { num1, num2 -> (num2 + num1).compareTo(num1 + num2) }

    fun largestNumber(nums: IntArray): String {
        val largestNumberBuilder = StringBuilder()

        val sortedNumStringList = nums.map { it.toString() }.sortedWith(largestNumberOrder)

        if (sortedNumStringList.first() == "0") {
            return "0"
        }

        sortedNumStringList.forEach {
            largestNumberBuilder.append(it)
        }

        return largestNumberBuilder.toString()
    }
}

fun main() {
    // Input
    val nums = intArrayOf(10, 2)
    // Output
    LeetCode_179().largestNumber(nums).run {
        println(this)
        require("210" == this)
    }
}
