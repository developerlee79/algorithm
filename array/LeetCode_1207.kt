package array

class LeetCode_1207 {

    fun uniqueOccurrences(arr: IntArray): Boolean {
        val frequencyMap = hashMapOf<Int, Int>()

        arr.forEach {
            frequencyMap.merge(it, 1) { a, b -> a + b }
        }

        val frequencySet = hashSetOf<Int>()

        return frequencyMap.values.all { frequencySet.add(it) }
    }
}
