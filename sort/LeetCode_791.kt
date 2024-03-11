package sort

class LeetCode_791 {

    fun customSortString(order: String, s: String): String {
        val frequencyMap = hashMapOf<Char, Int>()

        s.forEach { char ->
            frequencyMap.merge(char, 1) { a, b -> a + b }
        }

        val resultString = StringBuilder()

        order.forEach { char ->
            if (frequencyMap.containsKey(char)) {
                resultString.append(char.toString().repeat(frequencyMap[char]!!))
                frequencyMap.remove(char)
            }
        }

        frequencyMap.keys.forEach { key ->
            resultString.append(key.toString().repeat(frequencyMap[key]!!))
        }

        return resultString.toString()
    }
}

fun main() {
    // Input
    val order = "cba"
    val s = "abcd"
    // Output
    LeetCode_791().customSortString(order, s).run {
        println(this)
        require("cbad" == this)
    }
}
