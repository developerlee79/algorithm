package sort

class LeetCode_944 {

    fun minDeletionSize(strs: Array<String>): Int {
        var count = 0

        val countingArray = CharArray(strs.first().length)

        strs.forEach { str ->
            str.forEachIndexed { j, char ->
                countingArray[j] = when {
                    countingArray[j] == 'A' -> return@forEachIndexed
                    countingArray[j] > char -> {
                        count++
                        'A'
                    }
                    else -> char
                }
            }
        }

        return count
    }
}

fun main() {
    // Input
    val strs = arrayOf(
        "abc",
        "bce",
        "cae"
    )
    // Output
    LeetCode_944().minDeletionSize(strs).let {
        println(it)
        require(it == 1)
    }
}
