package string

class LeetCode_2138 {

    fun divideString(s: String, k: Int, fill: Char): Array<String> {
        val resultArray = mutableListOf<String>()
        val n = s.length

        var i = 0
        val divide = n % k

        while (i < n) {
            val currentDivide = s.substring(i until minOf(n, i + k))

            if (i + k >= n && divide != 0) {
                resultArray.add(currentDivide + fill.toString().repeat(k - divide))
            } else {
                resultArray.add(currentDivide)
            }

            i += k
        }

        return resultArray.toTypedArray()
    }
}