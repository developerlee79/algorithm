package string

class LeetCode_293 {

    fun generatePossibleNextMoves(currentState: String): List<String> {
        val moveList = mutableListOf<String>()
        val n = currentState.length

        for (i in 0 until n - 1) {
            if (currentState[i] == '-' || currentState[i + 1] == '-') {
                continue
            }

            val stateBuilder = StringBuilder(currentState)
            stateBuilder.setCharAt(i, '-')
            stateBuilder.setCharAt(i + 1, '-')

            moveList.add(stateBuilder.toString())
        }

        return moveList
    }
}

fun main() {
    // Input
    val currentState = "++++"
    // Output
    LeetCode_293().generatePossibleNextMoves(currentState).run {
        println(this)
        require(
            listOf("--++", "+--+", "++--") == this
        )
    }
}
