package dp

import kotlin.math.max

class LeetCode_1048 {

    /**
     * Solution - Dynamic Programming
     * Time Complexity : O(NlogN)
     * Space Complexity : O(N)
     *
     * Solve the problem by Dynamic programming with Map.
     * Sort word arrays by length so that you can check if they are "chain" in order.
     * Suppose the current word is the longest word, and find the number of "chain" by erasing the character of the current word one by one.
     * If there is a word in map that has erased one character from the current word, continue (plus one) with the "chain" of that word.
     * Compare the longest chain in every iteration to find the longest chain.
     *
     * @param words array of words where each word consists of lowercase English letters
     * @return length of the longest possible word chain* with words chosen from the given list of words
     *        * word chain : sequence of words where word is a predecessor (if insert exactly one letter anywhere in wordA without changing the order) of another word
     */
    fun longestStrChain(words: Array<String>): Int {
        val dp: MutableMap<String, Int> = mutableMapOf()
        words.sortBy { it.length }

        var longestChain = 1
        for (word in words) {
            var currentChain = 1
            val stringBuilder = StringBuilder(word)

            for (i in word.indices) {
                stringBuilder.deleteCharAt(i)
                currentChain = max(currentChain, dp.getOrDefault(stringBuilder.toString(), 0) + 1)
                stringBuilder.insert(i, word[i])
            }

            dp[word] = currentChain
            longestChain = max(longestChain, currentChain)
        }

        return longestChain
    }
}

fun main() {
    val words = arrayOf("xbc", "pcxbcf", "xb", "cxbc", "pcxbc")
    println(LeetCode_1048().longestStrChain(words))
}
