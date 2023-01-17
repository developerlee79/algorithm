package string

class LeetCode_926 {

    fun flipStringToMonotoneIncreasing(str: String): Int {
        if (str.isEmpty()) {
            return 0
        }

        var flipCount = 0
        var oneCount = 0

        str.forEach {
            if (it == '0') {
                if (oneCount == 0) {
                    return@forEach
                }
                flipCount++
            } else {
                oneCount++
            }

            if (flipCount > oneCount) {
                flipCount = oneCount
            }
        }

        return flipCount
    }

}

fun main() {
    // Input
    val s = "00110"
    // Output
    LeetCode_926().flipStringToMonotoneIncreasing(s).let { result ->
        println(result)
        require(result == 1)
    }
}
