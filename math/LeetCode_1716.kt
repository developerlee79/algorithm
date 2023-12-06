package math

class LeetCode_1716 {

    fun totalMoney(n: Int): Int {
        val weeks = n / 7
        var money = (weeks * 28) + 7 * weeks * (weeks - 1) / 2

        if (n % 7 != 0) {
            val extraDays = n % 7
            var additonal = weeks + 1

            for (i in 0 until extraDays) {
                money += additonal
                additonal++
            }
        }

        return money
    }

}

fun main() {
    // Input
    val n = 4
    // Output
    LeetCode_1716().totalMoney(n).run {
        println(this)
        require(10 == this)
    }
}
