package string

class LeetCode_246 {

    fun isStrobogrammatic(num: String): Boolean {
        var i = 0
        var j = num.lastIndex

        while (i < j) {
            val left = num[i]
            val right = num[j]

            when (left) {
                '6' -> if (right != '9') return false
                '9' -> if (right != '6') return false
                '0', '1', '8' -> if (left != right) return false
                else -> return false
            }

            i++
            j--
        }

        return i != j || num[i] == '8' || num[i] == '1' || num[i] == '0'
    }
}

fun main() {
    // Input
    val num = "69"
    // Output
    LeetCode_246().isStrobogrammatic(num).run {
        println(this)
        require(this)
    }
}
