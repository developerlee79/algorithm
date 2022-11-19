package math

class LeetCode_263 {

    fun isUgly(n: Int): Boolean {
        if (n <= 0) {
            return false
        }

        var n = n

        while (n > 1) {
            n /=
                if (n % 2 == 0) 2
                else if (n % 3 == 0) 3
                else if (n % 5 == 0) 5
                else return false
        }

        return true
    }
}

fun main() {
    // Input
    val n = 6
    // Output
    val result = LeetCode_263().isUgly(n)
    println(result)
    require(result)
}
