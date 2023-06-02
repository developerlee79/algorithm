package dp

class LeetCode_292 {

    fun canWinNim(n: Int) = n % 4 != 0

}

fun main() {
    // Input
    val n = 4
    // Output
    LeetCode_292().canWinNim(n).run {
        println(this)
        require(!this)
    }
}
