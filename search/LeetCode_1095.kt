package search

class LeetCode_1095 {

    class MountainArray(
        private val array: IntArray
    ) {

        fun get(index: Int) = array[index]

        fun length() = array.size

    }

    fun findInMountainArray(target: Int, mountainArr: MountainArray): Int {
        val middle = findTopIndex(mountainArr)

        val leftSide = searchLeft(middle, mountainArr, target)

        if (leftSide > -1) {
            return leftSide
        }

        return searchRight(middle, mountainArr, target)
    }

    private fun findTopIndex(mountainArr: MountainArray): Int {
        var left = 0
        var right = mountainArr.length() - 1

        var topIndex = 0

        while (left < right) {
            val middle = (left + right) / 2

            if (mountainArr.get(middle) < mountainArr.get(middle + 1)) {
                left = middle + 1
                topIndex = middle + 1
            } else {
                right = middle
            }
        }

        return topIndex
    }

    private fun searchLeft(topIndex: Int, mountainArr: MountainArray, target: Int): Int {
        var left = 0
        var right = topIndex

        while (left <= right) {
            val middle = (left + right) / 2

            val currentNum = mountainArr.get(middle)

            if (currentNum == target) {
                return middle
            } else if (currentNum < target) {
                left = middle + 1
            } else {
                right = middle - 1
            }
        }

        return -1
    }

    private fun searchRight(topIndex: Int, mountainArr: MountainArray, target: Int): Int {
        var left = topIndex
        var right = mountainArr.length() - 1

        while (left <= right) {
            val middle = (left + right) / 2

            val currentNum = mountainArr.get(middle)

            if (currentNum == target) {
                return middle
            } else if (currentNum < target) {
                right = middle - 1
            } else {
                left = middle + 1
            }
        }

        return -1
    }

}

fun main() {
    // Input
    val target = 3
    val array = intArrayOf(1, 2, 3, 4, 5, 3, 1)
    val mountainArr = LeetCode_1095.MountainArray(array)
    // Output
    LeetCode_1095().findInMountainArray(target, mountainArr).run {
        println(this)
        require(2 == this)
    }
}
