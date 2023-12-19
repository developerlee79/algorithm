package matrix

class LeetCode_661 {

    fun imageSmoother(img: Array<IntArray>): Array<IntArray> {
        val n = img.size
        val m = img[0].size

        val smootherImage = Array(n) { IntArray(m) }

        for (i in 0 until n) {
            for (j in 0 until m) {
                smootherImage[i][j] = findAverage(img, i, j, n, m)
            }
        }

        return smootherImage
    }

    private val directions = arrayOf(
        intArrayOf(-1, -1),
        intArrayOf(-1, 0),
        intArrayOf(-1, 1),
        intArrayOf(0, -1),
        intArrayOf(0, 1),
        intArrayOf(1, -1),
        intArrayOf(1, 0),
        intArrayOf(1, 1)
    )

    private fun findAverage(img: Array<IntArray>, i: Int, j: Int, n: Int, m: Int): Int {
        var cellCount = 1
        var cellSum = img[i][j]

        for (direction in directions) {
            val iDirection = direction[0] + i
            val jDirection = direction[1] + j

            if (iDirection in 0 until n && jDirection in 0 until m) {
                cellCount++
                cellSum += img[iDirection][jDirection]
            }
        }

        return cellSum.floorDiv(cellCount)
    }
}

fun main() {
    // Input
    val img = arrayOf(
        intArrayOf(1, 1, 1),
        intArrayOf(1, 0, 1),
        intArrayOf(1, 1, 1),
    )
    // Output
    LeetCode_661().imageSmoother(img).run {
        println(this.contentDeepToString())
        require(
            arrayOf(
                intArrayOf(0, 0, 0),
                intArrayOf(0, 0, 0),
                intArrayOf(0, 0, 0),
            ).contentDeepEquals(this)
        )
    }
}
