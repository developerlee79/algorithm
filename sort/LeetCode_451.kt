package sort

class LeetCode_451 {

    fun frequencySort(s: String): String {
        val frequencyMap = s.groupingBy { it }.eachCount()

        val bucket = arrayOfNulls<MutableList<Char>>(s.length + 1)

        frequencyMap.keys.forEach {
            if (bucket[frequencyMap[it]!!] == null) {
                bucket[frequencyMap[it]!!] = mutableListOf()
            }
            bucket[frequencyMap[it]!!]!!.add(it)
        }

        val sb = StringBuilder()

        for (i in bucket.size - 1 downTo 0) {
            if (bucket[i] != null) {
                for (c in bucket[i]!!) {
                    for (j in 0 until i) {
                        sb.append(c)
                    }
                }
            }
        }

        return sb.toString()
    }
}

fun main() {
    // Input
    val s = "Aabb"
    // Output
    val result = LeetCode_451().frequencySort(s)
    println(result)
    require("bbAa" == result)
}
