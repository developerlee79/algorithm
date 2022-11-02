package string

import java.util.LinkedList
import java.util.Queue

class LeetCode_433 {

    /**
     * Solution : Breath-First Search
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * @param start 8-character long string with choices from 'A', 'C', 'G', 'T'
     * @param end   8-character long string with choices from 'A', 'C', 'G', 'T'
     * @param bank gene bank bank that records all the valid gene mutations. A gene must be in bank to make it a valid gene string
     * @return return the minimum number of mutations needed to mutate from start to end. If there is no such a mutation, return -1
    */
    fun minMutation(start: String, end: String, bank: Array<String>): Int {
        val geneSet = bank.toHashSet()

        if (start == end || !geneSet.contains(end)) {
            return -1
        }

        val genes = listOf('A', 'T', 'G', 'C')

        val queue: Queue<String> = LinkedList()
        queue.add(start)

        var countOfMutation = 0

        while (queue.isNotEmpty()) {
            val queueSize = queue.size

            repeat(queueSize) {
                val str = queue.poll()

                if (str == end) {
                    return countOfMutation
                }

                val charArray = str.toCharArray()

                repeat(8) {
                    val tmp = charArray[it]

                    for (gene in genes) {
                        if (gene != charArray[it]) {
                            charArray[it] = gene
                            val newString = String(charArray)
                            if (geneSet.remove(newString)) {
                                queue.add(newString)
                            }
                        }
                    }
                    charArray[it] = tmp
                }
            }
            countOfMutation++
        }

        return -1
    }
}

fun main() {
    // Input
    val start = "AACCGGTT"
    val end =   "AAACGGTA"
    val bank = arrayOf(
        "AACCGGTA",
        "AACCGCTA",
        "AAACGGTA",
    )
    // Output
    val result = LeetCode_433().minMutation(start, end, bank)
    println(result)
    require(result == 2)
}
