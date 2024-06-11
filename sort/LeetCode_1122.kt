package sort

class LeetCode_1122 {

    fun relativeSortArray(arr1: IntArray, arr2: IntArray): IntArray {
        val numberMap = hashMapOf<Int, Int>()
        val sortList = mutableListOf<Int>()

        arr2.forEach { numberMap[it] = 0 }

        arr1.forEach { num ->
            if (numberMap.containsKey(num)) {
                numberMap.merge(num, 1) { a, b -> a + b }
            } else {
                sortList.add(num)
            }
        }

        sortList.sort()

        val sortedArray = IntArray(arr1.size)

        var sortedIndex = 0

        arr2.forEach { num ->
            repeat(numberMap[num]!!) {
                sortedArray[sortedIndex++] = num
            }
        }

        for (i in sortList.indices) {
            sortedArray[sortedIndex++] = sortList[i]
        }

        return sortedArray
    }
}

fun main() {
    // Input
    val arr1 = intArrayOf(2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19)
    val arr2 = intArrayOf(2, 1, 4, 3, 9, 6)
    // Output
    LeetCode_1122().relativeSortArray(arr1, arr2).run {
        println(this)
        require(
            intArrayOf(2, 2, 2, 1, 4, 3, 3, 9, 6, 7, 19).contentEquals(this)
        )
    }
}
