package string

class LeetCode_165 {

    fun compareVersion(version1: String, version2: String): Int {
        val v1 = version1.split('.')
        val v2 = version2.split('.')

        for (i in 0 until maxOf(v1.size, v2.size)) {
            val num1 = if (i < v1.size) v1[i].toInt() else 0
            val num2 = if (i < v2.size) v2[i].toInt() else 0

            if (num1 < num2) {
                return -1
            }

            if (num1 > num2) {
                return 1
            }
        }

        return 0
    }

}

fun main() {
    // Input
    val version1 = "1.01"
    val version2 = "1.001"
    // Output
    LeetCode_165().compareVersion(version1, version2).run {
        println(this)
        require(0 == this)
    }
}
