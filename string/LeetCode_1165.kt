package string

import kotlin.math.abs

class LeetCode_1165 {

    fun calculateTime(keyboard: String, word: String): Int {
        val keyboardMap = IntArray(26)

        for (i in keyboard.indices) {
            keyboardMap[keyboard[i] - 'a'] = i
        }

        var timeCount = 0
        var currentPointer = 0

        word.forEach {
            timeCount += abs(currentPointer - keyboardMap[it - 'a'])
            currentPointer = keyboardMap[it - 'a']
        }

        return timeCount
    }
}

fun main() {
    // Input
    val keyboard = "abcdefghijklmnopqrstuvwxyz"
    val word = "cba"
    // Output
    LeetCode_1165().calculateTime(keyboard, word).run {
        println(this)
        require(4 == this)
    }
}
