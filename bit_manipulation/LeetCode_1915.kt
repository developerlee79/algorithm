package bit_manipulation

class LeetCode_1915 {

    fun wonderfulSubstrings(word: String): Long {
        var wonderfulCount = 0L

        val count = LongArray(1024)
        count[0] = 1L

        var currentCount = 0

        for (ch in word) {
            currentCount = currentCount xor(1 shl ch - 'a')

            wonderfulCount += count[currentCount]++

            for (j in 0..9) {
                wonderfulCount += count[currentCount xor (1 shl j)]
            }
        }

        return wonderfulCount
    }
}

fun main() {
    // Input
    val word = "aba"
    // Output
    LeetCode_1915().wonderfulSubstrings(word).run {
        println(this)
        require(4L == this)
    }
}
