package two_pointers

class LeetCode_844 {

    fun backspaceCompare(s: String, t: String): Boolean {
        var firstPointer = s.lastIndex
        var secondPointer = t.lastIndex

        while (firstPointer >= 0 || secondPointer >= 0) {
            var firstEraseCount = 0

            while (firstPointer >= 0) {
                if (s[firstPointer] == '#') {
                    firstEraseCount++
                } else if (firstEraseCount > 0) {
                    firstEraseCount--
                } else {
                    break
                }
                firstPointer--
            }

            var secondEraseCount = 0

            while (secondPointer >= 0) {
                if (t[secondPointer] == '#') {
                    secondEraseCount++
                } else if (secondEraseCount > 0) {
                    secondEraseCount--
                } else {
                    break
                }
                secondPointer--
            }

            if (firstPointer < 0 && secondPointer < 0) {
                return true
            } else if (firstPointer < 0 || secondPointer < 0) {
                return false
            } else if (s[firstPointer] != t[secondPointer]) {
                return false
            }

            firstPointer--
            secondPointer--
        }

        return true
    }

}

fun main() {
    // Input
    val s = "ab##"
    val t = "c#d#"
    // Output
    LeetCode_844().backspaceCompare(s, t).run {
        println(this)
        require(this)
    }
}
