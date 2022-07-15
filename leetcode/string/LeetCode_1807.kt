package string

class LeetCode_1807 {

    /**
     * Solution - Hash Map
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * Use hash map to mapping key - value in knowledge.
     * After that, just find bracket in iteration and add replaced value at stringbuilder.
     *
     * @param s string that contains some bracket pairs with each pair containing a non-empty key
     * @param knowledge  2D string array knowledge where each knowledge[i] = [key, value]
     * @return resulting string after evaluating all the bracket pairs
    */
    fun evaluate(s: String, knowledge: List<List<String>>): String {
        val knowledgeMap = knowledge.associate { it[0] to it[1] }

        val resultString = StringBuilder()

        var i = 0
        while (i < s.length) {
            if (s[i] == '(') {
                i++

                val targetString = StringBuilder()
                while (s[i] != ')') {
                    targetString.append(s[i++])
                }

                val str = targetString.toString()
                resultString.append(
                    if (knowledgeMap.contains(str))
                        knowledgeMap[str]!!
                    else
                        "?"
                )
            } else {
                resultString.append(s[i])
            }
            i++
        }

        return resultString.toString()
    }
}

fun main() {
    val s = "(name)is(age)yearsold"
    val knowledge = listOf(
        listOf("name", "bob"),
        listOf("age", "two")
    )
    println(LeetCode_1807().evaluate(s, knowledge))
}
