package two_pointers

import kotlin.math.abs

class LeetCode_1471 {

    /**
     * Solution - Two Pointers
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * Compare the conditions as shown in the problem with two pointers.
     * First pointer : start from 0++. it means arr[i]
     * Second pointer : start from arr.len--. it means arr[j]
     *
     * @param arr array of integers
     * @param k a value indicate how strong the result
     * @return list of the strongest k values in the array in arbitrary order
     */
    fun getStrongest(arr: IntArray, k: Int): IntArray {
        arr.sort()
        val resultArray = IntArray(k)

        val median = arr[(arr.size - 1) / 2]
        var firstPointer = 0
        var secondPointer = arr.size - 1
        for (i in 0 until k) {
            val firstValue = abs(arr[firstPointer] - median)
            val secondValue = abs(arr[secondPointer] - median)
            resultArray[i] =
                if (firstValue > secondValue)
                    arr[firstPointer++]
                else if (firstValue < secondValue)
                    arr[secondPointer--]
                else
                    if (firstPointer > secondPointer)
                        arr[firstPointer++]
                    else
                        arr[secondPointer--]
        }

        return resultArray
    }
}

fun main() {
    val arr = intArrayOf(1, 1, 3, 5, 5)
    val k = 2
    println(LeetCode_1471().getStrongest(arr, k).joinToString())
}
