package array

class LeetCode_3005 {

    fun maxFrequencyElements(nums: IntArray): Int {
        val frequencyMap = HashMap<Int, Int>()

        var maxFrequency = 0

        nums.forEach { num ->
            frequencyMap.merge(num, 1) { a, b -> a + b }

            maxFrequency = maxOf(
                maxFrequency,
                frequencyMap[num]!!
            )
        }

        var count = 0

        frequencyMap.keys.forEach { key ->
            if (frequencyMap[key]!! == maxFrequency) {
                count += frequencyMap[key]!!
            }
        }

        return count
    }
}