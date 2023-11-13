package sort

class LeetCode_2785 {

    private fun Char.isVowel(): Boolean {
        return when (this) {
            'a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U' -> true
            else -> false
        }
    }

    fun sortVowels(s: String): String {
        val vowelList = findVowelFromString(s)

        if (vowelList.isEmpty()) {
            return s
        }

        vowelList.sort()

        val sortedString = StringBuilder()

        var vowelIndex = 0

        for (char in s) {
            if (char.isVowel()) {
                sortedString.append(vowelList[vowelIndex++])
            } else {
                sortedString.append(char)
            }
        }

        return sortedString.toString()
    }

    private fun findVowelFromString(target: String): MutableList<Char> {
        val vowelList = mutableListOf<Char>()

        for (char in target) {
            if (char.isVowel()) {
                vowelList.add(char)
            }
        }

        return vowelList
    }
}

fun main() {
    // Input
    val s = "lEetcOde"
    // Output
    LeetCode_2785().sortVowels(s).run {
        println(this)
        require("lEOtcede" == this)
    }
}
