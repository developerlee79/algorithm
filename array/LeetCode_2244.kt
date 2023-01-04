package array

class LeetCode_2244 {

    fun minimumRounds(tasks: IntArray): Int {
        val frequencyMap = mutableMapOf<Int, Int>()

        tasks.forEach {
            frequencyMap.merge(it, 1) { a, b -> a + b }
        }

        var count = 0

        val frequencyKeys = frequencyMap.keys

        while (frequencyKeys.isNotEmpty()) {
            val key = frequencyKeys.first()

            frequencyMap[key]?.let { value ->
                if (value == 1) {
                    return -1
                } else if (value % 3 == 0) {
                    frequencyMap[key] = frequencyMap[key]!! - 3
                } else {
                    frequencyMap[key] = frequencyMap[key]!! - 2
                }

                if (frequencyMap[key] == 0) {
                    frequencyMap.remove(key)
                }

                count++
            }
        }

        return count
    }
}

fun main() {
    // Input
    val tasks = intArrayOf(
        2, 2, 3, 3, 2, 4, 4, 4, 4, 4
    )
    // Output
    LeetCode_2244().minimumRounds(tasks).let {
        println(it)
        require(it == 4)
    }
}
