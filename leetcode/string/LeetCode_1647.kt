package string

class LeetCode_1647 {

    /**
     * Solution - Frequency Map & Set
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * Solve the problem with the frequency map & set.
     * First, use the reachCount method to find the frequency of appearance by character.
     * Then, repeat all frequencies. If the frequency already exists in Set, decrease the frequency of appearance until it be a good string.
     * If it does not exist, add at Set for next iteration.
     *
     * @param s string
     * @return minimum number of characters you need to delete to make s *good.
     *     *good : string which have no two different character with same frequency
    */
    fun minDeletions(s: String): Int {
        val frequencyMap = s.groupingBy { it }.eachCount()
        val frequencySet = mutableSetOf<Int>()

        var count = 0

        frequencyMap.forEach { frequency ->
            var currentFrequency = frequency.value
            while (currentFrequency > 0 && frequencySet.contains(currentFrequency)) {
                count++
                currentFrequency--
            }
            frequencySet.add(currentFrequency)
        }

        return count
    }
}

fun main() {
    val s = "ceabaacb"
    println(LeetCode_1647().minDeletions(s))
}
