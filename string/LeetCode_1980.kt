package string

class LeetCode_1980 {

    private fun Int.toBinaryString(length: Int): String {
        val binaryString = this.toString(2)
        return "0".repeat(length - binaryString.length) + binaryString
    }

    fun findDifferentBinaryString(nums: Array<String>): String {
        val maxValue = 1.shl(nums.size)

        val numSet = BooleanArray(maxValue)
        nums.forEach {
            numSet[it.toInt(2)] = true
        }

        for (i in 0 .. maxValue) {
            if (!numSet[i]) {
                return i.toBinaryString(nums.size)
            }
        }

        return ""
    }

}

fun main() {
    // Input
    val nums = arrayOf("01", "10")
    // Output
    LeetCode_1980().findDifferentBinaryString(nums).run {
        println(this)
        require("11" == this || "10" == this)
    }
}
