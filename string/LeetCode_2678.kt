package string

class LeetCode_2678 {

    fun countSeniors(details: Array<String>): Int {
        var count = 0

        for (detail in details) {
            val age = detail.substring(11, 13).toInt()

            if (age > 60) {
                count++
            }
        }

        return count
    }
}

fun main() {
    // Input
    val details = arrayOf("7868190130M7522", "5303914400F9211", "9273338290F4010")
    // Output
    LeetCode_2678().countSeniors(details).run {
        println(this)
        require(2 == this)
    }
}
