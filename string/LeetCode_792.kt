package string

import java.util.*

class LeetCode_792 {

    /**
     * Solution - Hash Map
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * Solve the problem by saving words with HashMap using Queue.
     * Store those string s characters along with words[] starting with those characters.
     * Then, Check the characters in s one by one, erase the first character of the items in queue that start with that character, and then move it to queue match with next character.
     * If all characters remain after checking, the word is not matched.
     *
     * @param s string
     * @param words array of strings
     * @return number of words[i] that is a subsequence of s
     */
    fun numMatchingSubseq(s: String, words: Array<String>): Int {
        val wordMap = mutableMapOf<Char, Queue<String>>()
        var count = 0

        for (c in s) {
            wordMap.putIfAbsent(c, LinkedList())
        }

        for (word in words) {
            val startingChar = word[0]
            if (wordMap.contains(startingChar)) {
                wordMap[startingChar]!!.add(word)
            }
        }

        for (c in s) {
            val queue = wordMap[c]!!

            val size = queue.size
            for (k in 0 until size) {
                val wordString = queue.poll()

                if (wordString.substring(1).isEmpty()) {
                    count++
                } else if (wordMap.containsKey(wordString[1])) {
                    wordMap[wordString[1]]!!.add(wordString.substring(1))
                }
            }
        }

        return count
    }

    /**
     * Solution - Brute Force
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * Check all words with a brute force.
     *
     * @param s string
     * @param words array of strings
     * @return number of words[i] that is a subsequence of s
    */
    fun numMatchingSubseqBruteforce(s: String, words: Array<String>): Int {
        var count = 0

        for (word in words) {
            var index = -1
            var match = true
            for (c in word) {
                index = s.indexOf(c, index + 1)
                if (index == -1) {
                    match = false
                    break
                }
            }
            if (match) {
                count++
            }
        }

        return count
    }
}

fun main() {
    val s = "abcde"
    val words = arrayOf("a", "bb", "acd", "ace")
    println(LeetCode_792().numMatchingSubseq(s, words))
    println(LeetCode_792().numMatchingSubseqBruteforce(s, words))
}
