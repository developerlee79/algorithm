package array

class LeetCode_1503 {

    fun getLastMoment(n: Int, left: IntArray, right: IntArray): Int {
        var lastMoment = 0

        for (rightAnt in left) {
            lastMoment = maxOf(lastMoment, rightAnt)
        }

        for (leftAnt in right) {
            lastMoment = maxOf(lastMoment, n - leftAnt)
        }

        return lastMoment
    }

}

fun main() {
    // Input
    val n = 4
    val left = intArrayOf(4, 3)
    val right = intArrayOf(0, 1)
    // Output
    LeetCode_1503().getLastMoment(n, left, right).run {
        println(this)
        require(4 == this)
    }
}
