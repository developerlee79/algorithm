package string

class LeetCode_1876 {

    fun countGoodSubstrings(s: String): Int {
        val frequencyMap = HashMap<Char, Int>()

        var count = 0

        for (i in s.indices) {
            if (i > 2) {
                frequencyMap.merge(s[i - 3], 1) { a, b -> a - b }

                if (frequencyMap[s[i - 3]] == 0) {
                    frequencyMap.remove(s[i - 3])
                }
            }

            if (frequencyMap.size == 2 && !frequencyMap.containsKey(s[i])) {
                count++
            }

            frequencyMap.merge(s[i], 1) { a, b -> a + b }
        }

        return count
    }
}

fun main() {
    // Input
    val s = "xyzzaz"
    // Output
    LeetCode_1876().countGoodSubstrings(s).run {
        println(this)
        require(1 == this)
    }
}
