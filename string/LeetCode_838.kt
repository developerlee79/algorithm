package string

class LeetCode_838 {

    /**
     * Problem : Push Dominoes (838)
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * @param dominoes string that presents dominoes in a line
     * @return return a string representing the final state after push
     */
    fun pushDominoes(dominoes: String): String {
        val stringBuilder = StringBuilder()

        var lastRight = -1
        var sumOfNoDirectionDominoes = 0
        for (i in dominoes.indices) {
            if (dominoes[i] == 'L') {
                if (lastRight == -1) {
                    for (j in 0..sumOfNoDirectionDominoes) {
                        stringBuilder.append("L")
                    }
                    sumOfNoDirectionDominoes = 0
                } else {
                    val modular = sumOfNoDirectionDominoes % 2

                    for (j in 0 until sumOfNoDirectionDominoes / 2 + modular) {
                        stringBuilder.append("R")
                    }

                    if (modular == 0) {
                        stringBuilder.append(".")
                    }

                    for (j in sumOfNoDirectionDominoes / 2  until sumOfNoDirectionDominoes) {
                        stringBuilder.append("L")
                    }

                    lastRight = -1
                    sumOfNoDirectionDominoes = 0
                }
            } else if (dominoes[i] == 'R') {
                if (lastRight != -1) {
                    for (j in 0 until sumOfNoDirectionDominoes) {
                        stringBuilder.append('R')
                    }
                    sumOfNoDirectionDominoes = 0
                }

                if (sumOfNoDirectionDominoes > 0) {
                    for (j in 0 until sumOfNoDirectionDominoes) {
                        stringBuilder.append(".")
                    }
                    sumOfNoDirectionDominoes = 0
                }

                sumOfNoDirectionDominoes++
                lastRight = i
            } else {
                if (i > 0 && i < dominoes.length - 1) {
                    if (dominoes[i - 1] == 'L' && dominoes[i + 1] == 'R') {
                        stringBuilder.append(".")
                        continue
                    }
                }

                sumOfNoDirectionDominoes++
            }
        }

        if (sumOfNoDirectionDominoes != 0) {
            if (lastRight != -1) {
                for (i in 0 until sumOfNoDirectionDominoes) {
                    stringBuilder.append("R")
                }
            } else {
                for (i in 0 until sumOfNoDirectionDominoes) {
                    stringBuilder.append(".")
                }
            }
        }

        return stringBuilder.toString()
    }
}

fun main() {
    // given
    val dominoes = ".L.R...LR..L.."
    // when
    val result = LeetCode_838().pushDominoes(dominoes)
    // then
    println(result)
    assert("LL.RR.LLRRLL.." == result)
}
