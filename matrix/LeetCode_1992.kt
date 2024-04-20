package matrix

class LeetCode_1992 {

    fun findFarmland(land: Array<IntArray>): Array<IntArray> {
        val n = land.size
        val m = land[0].size

        val farmLandList = mutableListOf<IntArray>()
        val visited = Array(n) { BooleanArray(m) }

        var i = 0

        while (i < n) {
            var j = 0

            while (i < n && j < m) {
                if (visited[i][j] || land[i][j] == 0) {
                    j++
                    continue
                }

                val width = searchLandWidth(land, i + 1, j)
                val height = searchLandHeight(land, i, j + 1)

                farmLandList.add(intArrayOf(i, j, width, height))

                fillVisitedArray(visited, i..width, j..height)

                j++
            }

            i++
        }

        return farmLandList.toTypedArray()
    }

    private fun searchLandWidth(land: Array<IntArray>, x: Int, y: Int): Int {
        if (x !in land.indices || land[x][y] == 0) {
            return x - 1
        }

        return searchLandWidth(land, x + 1, y)
    }

    private fun searchLandHeight(land: Array<IntArray>, x: Int, y: Int): Int {
        if (y !in land[x].indices || land[x][y] == 0) {
            return y - 1
        }

        return searchLandHeight(land, x, y + 1)
    }

    private fun fillVisitedArray(visited: Array<BooleanArray>, xRange: IntRange, yRange: IntRange) {
        for (i in xRange) {
            for (j in yRange) {
                visited[i][j] = true
            }
        }
    }
}

fun main() {
    // Input
    val land = arrayOf(
        intArrayOf(1, 0, 0),
        intArrayOf(0, 1, 1),
        intArrayOf(0, 1, 1)
    )
    // Output
    LeetCode_1992().findFarmland(land).run {
        println(this.contentDeepToString())
        require(
            arrayOf(
                intArrayOf(0, 0, 0, 0),
                intArrayOf(1, 1, 2, 2)
            ).contentDeepEquals(this)
        )
    }
}
