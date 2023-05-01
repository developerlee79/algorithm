package array

class LeetCode_1491 {

    fun average(salary: IntArray): Double {
        var sum = 0.0

        var min = Int.MAX_VALUE
        var max = Int.MIN_VALUE

        val n: Int = salary.size

        for (num in salary) {
            sum += num.toDouble()
            min = minOf(min, num)
            max = maxOf(max, num)
        }

        return (sum - min - max) / (n - 2)
    }
}

fun main() {
    // Input
    val salary = intArrayOf(4000, 3000, 1000, 2000)
    // Output
    LeetCode_1491().average(salary).run {
        println(this)
        require(2500.00000 == this)
    }
}
