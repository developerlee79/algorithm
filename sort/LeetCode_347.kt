package sort

class LeetCode_347 {

    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val frequencyMap = hashMapOf<Int, Int>()
        val bucket = arrayOfNulls<MutableList<Int>>(nums.size + 1)

        nums.forEach {
            frequencyMap.merge(it, 1) { a, b -> a + b }
        }

        frequencyMap.entries.forEach { (key, value) ->
            if (bucket[value] == null) {
                bucket[value] = mutableListOf()
            }
            bucket[value]?.add(key)
        }

        val resultList = mutableListOf<Int>()

        var n = bucket.size - 1

        while (n >= 0 && resultList.size < k) {
            bucket[n]?.toList()?.let { resultList.addAll(it) }
            n--
        }

        return resultList.toIntArray()
    }
}

fun main() {
    // Input
    val nums = intArrayOf(1, 1, 1, 2, 2, 3)
    val k = 2
    // Output
    LeetCode_347().topKFrequent(nums, k).run {
        println(this.joinToString())
        require(this.contentEquals(intArrayOf(1, 2)))
    }
}
