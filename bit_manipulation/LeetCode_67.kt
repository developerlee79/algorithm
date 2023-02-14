package bit_manipulation

class LeetCode_67 {

    fun addBinary(a: String, b: String): String {
        var i = a.lastIndex
        var j = b.lastIndex

        val stringBuilder = StringBuilder()
        var carry = false

        while (i >= 0 || j >= 0) {
            var sum = 0

            if (carry) {
                sum += 1
            }

            if (i >= 0) {
                sum += a[i--].digitToInt()
            }

            if (j >= 0) {
                sum += b[j--].digitToInt()
            }

            carry = sum > 1

            stringBuilder.append(sum % 2)
        }

        if (carry) {
            stringBuilder.append(1)
        }

        return stringBuilder.reverse().toString()
    }
}

fun main() {
    // Input
    val a = "11"
    val b = "1"
    // Output
    LeetCode_67().addBinary(a, b).let {
        println(it)
        require(it == "100")
    }
}
