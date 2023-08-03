package backtracking

class LeetCode_17 {

    private val phoneButtons = arrayOf(
        "",
        "", "abc", "def",
        "ghi", "jkl", "mno",
        "pqrs", "tuv", "wxyz"
    )

    fun letterCombinations(digits: String): List<String> {
        var resultArray = mutableListOf<String>()

        if (digits.isEmpty()) {
            return resultArray
        }

        resultArray.add("")

        digits.toCharArray().forEach { digit ->
            val currentList = mutableListOf<String>()

            phoneButtons[digit.digitToInt()].forEach { button ->
                resultArray.forEach {
                    currentList.add(it + button)
                }
            }

            resultArray = currentList
        }

        return resultArray
    }
}

fun main() {
    // Input
    val digits = "23"
    // Output
    LeetCode_17().letterCombinations(digits).run {
        println(this)
        require(
            listOf(
                "ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"
            ).containsAll(this)
        )
    }
}
