package array

class LeetCode_605 {

    fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
        var i = 0
        var n = n

        while (i in flowerbed.indices && n > 0) {
            if (i + 1 < flowerbed.size && flowerbed[i + 1] == 1){
                i++
            } else if (flowerbed[i] != 1) {
                n--
            }
            i += 2
        }

        return n == 0
    }
}

fun main() {
    // Input
    val flowerbed = intArrayOf(1, 0, 0, 0, 1)
    val n = 1
    // Output
    LeetCode_605().canPlaceFlowers(flowerbed, n).let {
        println(it)
        require(it)
    }
}
