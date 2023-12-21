package string

class LeetCode_1433 {

    fun checkIfCanBreak(s1: String, s2: String): Boolean {
        val sortedS1 = s1.toCharArray().sortedArray()
        val sortedS2 = s2.toCharArray().sortedArray()

        var isLeftBigger: Boolean? = null

        for (i in s1.indices) {
            if (sortedS1[i] == sortedS2[i]) {
                continue
            } else {
                val result = sortedS1[i] > sortedS2[i]

                if (isLeftBigger == null) {
                    isLeftBigger = result
                } else if (isLeftBigger != result) {
                    return false
                }
            }
        }

        return true
    }
}

fun main() {
    // Input
    val s1 = "abc"
    val s2 = "xya"
    // Output
    LeetCode_1433().checkIfCanBreak(s1, s2).run {
        println(this)
        require(this)
    }
}
