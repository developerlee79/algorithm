package graph

class LeetCode_990 {

    /**
     * Problem : Satisfiability of Equality Equations (990)
     * Solution : Union Find
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     *
     * Use union find to memorize equations.
     *
     * @param equations array of strings equations that represent relationships between variables
     * @return Return true if it is possible to assign integers to variable names to satisfy all the given equations, or false otherwise
    */
    fun equationsPossible(equations: Array<String>): Boolean {
        val alphabetArray = IntArray(26)

        for (i in 0..25) {
            alphabetArray[i] = i
        }

        for (equation in equations) {
            if (equation[1] == '=') {
                val firstParam = findRoot(alphabetArray, equation[0] - 'a')
                val secondParam = findRoot(alphabetArray, equation[3] - 'a')

                if (firstParam != secondParam) {
                    alphabetArray[secondParam] = firstParam
                }
            }
        }

        for (equation in equations) {
            if (equation[1] == '!') {
                if (findRoot(alphabetArray, equation[0] - 'a') ==
                    findRoot(alphabetArray, equation[3] - 'a')) {
                    return false
                }
            }
        }

        return true
    }

    private fun findRoot(array: IntArray, value: Int): Int {
        return if (array[value] == value)
            value
        else findRoot(array, array[value]).also { array[value] = it }
    }
}

fun main() {
    // given
    val equations = arrayOf("a==b", "b!=a")
    // when
    val result = LeetCode_990().equationsPossible(equations)
    // then
    assert(!result)
    println(result)
}
