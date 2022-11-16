package search

class LeetCode_374 {

    open class GuessGame(
        private val answer: Int
    ) {

        protected fun guess(num: Int) =
            if (num > answer) -1
            else if (num < answer) 1
            else 0
    }

    class Solution(answer: Int) : GuessGame(answer) {

        fun guessNumber(n: Int): Int {
            var low = 1
            var high = n

            while (low < high) {
                val mid = low + (high - low) / 2

                when (guess(mid)) {
                    0 -> return mid
                    1 -> low = mid + 1
                    else -> high = mid
                }
            }

            return low
        }
    }
}

fun main() {
    // Input
    val guessGame = LeetCode_374.Solution(6)
    // Output
    val result = guessGame.guessNumber(10)
    println(result)
    require(result == 6)
}
