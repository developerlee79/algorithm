package string

class LeetCode_1647 {

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
    val s = "aaabbbcc"
    LeetCode_1647().minDeletions(s).run {
        println(this)
        require(2 == this)
    }
}
