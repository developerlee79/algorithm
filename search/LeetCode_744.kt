package search

class LeetCode_744 {

    fun nextGreatestLetter(letters: CharArray, target: Char): Char {
        val n = letters.size

        if (target >= letters.last()) {
            return letters.first()
        }

        var left = 0
        var right = n - 1

        while (left < right) {
            val mid = (right - left) / 2 + left

            if (letters[mid] <= target) {
                left = mid + 1
            } else {
                right = mid
            }
        }

        return letters[right]
    }
}

fun main() {
    // Input
    val letters = charArrayOf('c', 'f', 'j')
    val target = 'a'
    // Output
    LeetCode_744().nextGreatestLetter(letters, target).run {
        println(this)
        require('c' == this)
    }
}
