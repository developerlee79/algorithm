package string

class LeetCode_859 {

    fun buddyStrings(s: String, goal: String): Boolean {
        if (s.length != goal.length) {
            return false
        }

        val charSet = HashSet<Char>(26)

        var diffIndex = -1
        var hasDuplicate = false

        var i = 0

        while (i < s.length) {
            if (s[i] != goal[i]) {
                if (diffIndex == -1) {
                    diffIndex = i
                } else {
                    if (s[diffIndex] == goal[i] && s[i] == goal[diffIndex]) {
                        i++
                        return s.substring(i) == goal.substring(i)
                    }
                    return false
                }
            }
            if (!charSet.add(s[i])) {
                hasDuplicate = true
            }
            i++
        }

        return diffIndex == -1 && hasDuplicate
    }
}

fun main() {
    // Input
    val s = "ab"
    val goal = "ba"
    // Output
    LeetCode_859().buddyStrings(s, goal).run {
        println(this)
        require(this)
    }
}
