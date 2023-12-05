package simulation

class LeetCode_1688 {

    fun numberOfMatches(n: Int) = n - 1

}

fun main() {
    // Input
    val n = 7
    // Output
    LeetCode_1688().numberOfMatches(n).run {
        println(this)
        require(6 == this)
    }
}
