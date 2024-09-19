package math

class LeetCode_241 {

    private val expressionMap = hashMapOf<String, MutableList<Int>>()

    fun diffWaysToCompute(expression: String): List<Int> {
        if (expressionMap.containsKey(expression)) {
            return expressionMap[expression]!!
        }

        val expressionList = mutableListOf<Int>()

        expression.forEachIndexed { i, exp ->
            if (exp == '*' || exp == '+' || exp == '-') {
                val leftExpressionList = diffWaysToCompute(expression.substring(0, i))
                val rightExpressionList = diffWaysToCompute(expression.substring(i + 1))

                leftExpressionList.forEach { leftExpression ->
                    rightExpressionList.forEach { rightExpression ->
                        when (exp) {
                            '+' -> expressionList.add(leftExpression + rightExpression)
                            '-' -> expressionList.add(leftExpression - rightExpression)
                            '*' -> expressionList.add(leftExpression * rightExpression)
                        }
                    }
                }
            }
        }

        if (expressionList.isEmpty()) {
            expressionList.add(expression.toInt())
        }

        expressionMap[expression] = expressionList

        return expressionList
    }
}

fun main() {
    // Input
    val expression = "2-1-1"
    // Output
    LeetCode_241().diffWaysToCompute(expression).run {
        println(this)
        require(
            listOf(0, 2) == this
        )
    }
}
