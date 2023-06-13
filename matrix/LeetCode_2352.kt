package matrix

class LeetCode_2352 {

    fun equalPairs(grid: Array<IntArray>): Int {
        var pair = 0

        for (i in grid.indices) {
            val pairMap = HashMap<Int, Int>()

            for (j in grid.indices) {
                pairMap[j] = grid[i][j]
            }

            for (j in grid.indices) {
                var isPair = true

                for (k in grid.indices) {
                    if (pairMap[k] != grid[k][j]) {
                        isPair = false
                        break
                    }
                }

                if (isPair) {
                    pair++
                }
            }
        }

        return pair
    }
}

fun main() {
    // Input
    val grid = arrayOf(
        intArrayOf(3, 1, 2, 2),
        intArrayOf(1, 4, 4, 5),
        intArrayOf(2, 4, 2, 2),
        intArrayOf(2, 4, 2, 2),
    )
    // Output
    LeetCode_2352().equalPairs(grid).run {
        println(this)
        require(3 == this)
    }
}
