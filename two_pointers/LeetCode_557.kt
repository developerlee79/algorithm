package two_pointers

class LeetCode_557 {

    fun reverseWords(s: String): String {
        val chars = s.toCharArray()
        var i = 0
        var j = 1

        while (j <= chars.size) {
            if (j == chars.size || chars[j] == ' ') {
                reverse(chars, i, j - 1)
                i = j + 1
            }
            j++
        }

        return String(chars)
    }
    private fun reverse(chars: CharArray, i: Int, j: Int) {
        var i = i
        var j = j
        while (i < j) {
            swap(chars, i++, j--)
        }
    }
    private fun swap(arr: CharArray, x: Int, y: Int) {
        val tmp = arr[x]
        arr[x] = arr[y]
        arr[y] = tmp
    }

}

fun main() {
    // Input
    val s = "Let's take LeetCode contest"
    // Output
    LeetCode_557().reverseWords(s).run {
        println(this)
        require("s'teL ekat edoCteeL tsetnoc" == this)
    }
}
