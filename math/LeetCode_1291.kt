package math

class LeetCode_1291 {

    fun sequentialDigits(low: Int, high: Int): List<Int> {
        val digits = mutableListOf<Int>()

        for (i in 1..9) {
            var curr = i
            var next = i + 1

            while (curr <= high && next <= 9) {
                curr *= 10
                curr += next

                if (curr in low..high) {
                    digits.add(curr)
                }

                next++
            }
        }

        return digits.sorted()
    }
}

fun main() {
    // Input
    val low = 100
    val high = 300
    // Output
    LeetCode_1291().sequentialDigits(low, high).run {
        println(this)
        require(
            listOf(123, 234) == this
        )
    }
}
