package simulation

class LeetCode_1945 {

    fun getLucky(s: String, k: Int): Int {
        val digitBuilder = StringBuilder()

        s.forEach {
            digitBuilder.append(it - 'a' + 1)
        }

        var digits = digitBuilder.toString()

        repeat(k) {
            digits = transform(digits)
        }

        return digits.toInt()
    }

    private fun transform(digits: String): String {
        var totalNumber = 0

        digits.forEach {
            totalNumber += it.digitToInt()
        }

        return totalNumber.toString()
    }
}

fun main() {
    // Input
    val s = "iiii"
    val k = 1
    // Output
    LeetCode_1945().getLucky(s, k).run {
        println(this)
        require(36 == this)
    }
}
