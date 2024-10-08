package string

class LeetCode_1963 {

    fun minSwaps(s: String): Int {
        var count = 0

        s.forEach { char ->
            if (char == '[') {
                count++
            } else if (count > 0) {
                count--
            }
        }

        return (count + 1) / 2
    }
}

fun main() {
    // Input
    val s = "][]["
    // Output
    LeetCode_1963().minSwaps(s).run {
        println(this)
        require(1 == this)
    }
}
