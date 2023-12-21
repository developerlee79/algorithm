package array

class LeetCode_2053 {

    fun kthDistinct(arr: Array<String>, k: Int): String {
        val stringMap = HashMap<String, Boolean>()

        arr.forEach { str ->
            stringMap[str] = !stringMap.containsKey(str)
        }

        var count = 0

        arr.forEach { str ->
            if (stringMap[str]!! && ++count == k) {
                return str
            }
        }

        return ""
    }
}

fun main() {
    // Input
    val arr = arrayOf("d", "b", "c", "b", "c", "a")
    val k = 2
    // Output
    LeetCode_2053().kthDistinct(arr, k).run {
        println(this)
        require("a" == this)
    }
}
