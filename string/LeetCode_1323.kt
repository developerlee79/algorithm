package string

class LeetCode_1323 {

    /**
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * We only need to change first 6 in num.
     * So... replace first!
     *
     * @param num positive integer
     * @return Return the maximum number you can get by changing at most one digit (6 becomes 9, and 9 becomes 6)
    */
    fun maximum69Number (num: Int): Int =
        num.toString().replaceFirst("6", "9").toInt()
}

fun main() {
    // Input
    val num = 9669
    // Output
    val result = LeetCode_1323().maximum69Number(num)
    println(result)
    require(result == 9969)
}
