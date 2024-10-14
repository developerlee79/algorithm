package string

class LeetCode_247 {

    private val pairs = arrayOf(
        arrayOf("1", "1"),
        arrayOf("8", "8"),
        arrayOf("6", "9"),
        arrayOf("9", "6")
    )

    fun findStrobogrammatic(n: Int): List<String> {
        return constructStrabogrammaticList(n, n)
    }

    private fun constructStrabogrammaticList(n: Int, m: Int): List<String> {
        if (n == 0) {
            return listOf("")
        } else if (n == 1) {
            return listOf("0", "1", "8")
        }

        val strabogrammaticList = mutableListOf<String>()

        constructStrabogrammaticList(n - 2, m).forEach { num ->
            if (n != m) {
                strabogrammaticList.add("0${num}0")
            }

            pairs.forEach { pair ->
                strabogrammaticList.add("${pair[0]}${num}${pair[1]}")
            }
        }

        return strabogrammaticList
    }
}

fun main() {
    // Input
    val n = 2
    // Output
    LeetCode_247().findStrobogrammatic(n).run {
        println(this)
        require(
            listOf("11", "69", "88", "96") == this
        )
    }
}
