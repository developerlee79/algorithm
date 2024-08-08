package math

import java.util.Stack

class LeetCode_273 {

    private val numberMap = mapOf(
        0 to "Zero",
        1 to "One",
        2 to "Two",
        3 to "Three",
        4 to "Four",
        5 to "Five",
        6 to "Six",
        7 to "Seven",
        8 to "Eight",
        9 to "Nine",
        10 to "Ten",
        11 to "Eleven",
        12 to "Twelve",
        13 to "Thirteen",
        14 to "Fourteen",
        15 to "Fifteen",
        16 to "Sixteen",
        17 to "Seventeen",
        18 to "Eighteen",
        19 to "Nineteen",
        20 to "Twenty",
        30 to "Thirty",
        40 to "Forty",
        50 to "Fifty",
        60 to "Sixty",
        70 to "Seventy",
        80 to "Eighty",
        90 to "Ninety",
        100 to "Hundred",
        1000 to "Thousand",
        1000000 to "Million",
        1000000000 to "Billion"
    )

    fun numberToWords(num: Int): String {
        if (num == 0) {
            return numberMap[0]!!
        }

        var num = num

        val wordStack = Stack<String>()

        val divide = 1000
        var counter = 1

        while (num > 0) {
            var left = num % divide
            num -= left
            num /= divide

            val firstDigit = left % 10
            left -= firstDigit

            val secondDigit = left % 100
            left -= secondDigit

            if (counter > 1 && (firstDigit > 0 || secondDigit > 0 || left > 0)) {
                wordStack.add(numberMap[counter])
            }

            if (secondDigit == 10) {
                wordStack.add(numberMap[firstDigit + secondDigit])
            } else {
                if (firstDigit > 0) {
                    wordStack.add(numberMap[firstDigit])
                }

                if (secondDigit > 0) {
                    wordStack.add(numberMap[secondDigit])
                }
            }

            if (left > 0) {
                val thirdDigit = left / 100
                wordStack.add("${numberMap[thirdDigit]} ${numberMap[100]}")
            }

            counter *= 1000
        }

        val words = StringBuilder()

        while (wordStack.isNotEmpty()) {
            words.append(wordStack.pop())
                .append(" ")
        }

        return words.dropLast(1).toString()
    }
}

fun main() {
    // Input
    val num = 123
    // Output
    LeetCode_273().numberToWords(num).run {
        println(this)
        require("One Hundred Twenty Three" == this)
    }
}
