package dp

class LeetCode_823 {

    private fun <K> HashMap<K, Long>.increaseValue(key: K, value: Long) {
        this.merge(key, value) { a, b -> a + b }
    }

    fun numFactoredBinaryTrees(arr: IntArray): Int {
        var count: Long = 0
        val mod = 1000000007

        val numberMap = hashMapOf<Int, Long>()
        arr.sort()

        for (i in arr.indices) {
            val num = arr[i]
            numberMap[num] = 1

            for (j in 0 until i) {
                val nextNum = arr[j]

                if (num % nextNum == 0) {
                    numberMap.increaseValue(num, (numberMap[nextNum]!! * (numberMap[num / nextNum] ?: 0)) % mod)
                }
            }

            count = (count + numberMap[num]!!).mod(mod).toLong()
        }

        return count.toInt()
    }
}

fun main() {
    // Input
    val arr = intArrayOf(2, 4, 5, 10)
    // Output
    LeetCode_823().numFactoredBinaryTrees(arr).run {
        println(this)
        require(7 == this)
    }
}
