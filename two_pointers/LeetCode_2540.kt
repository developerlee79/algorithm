package two_pointers

class LeetCode_2540 {

    fun getCommon(nums1: IntArray, nums2: IntArray): Int {
        val n = nums1.size
        val m = nums2.size

        var pointerOne = 0
        var pointerTwo = 0

        while (pointerOne < n && pointerTwo < m) {
            if (nums1[pointerOne] == nums2[pointerTwo]) {
                return nums1[pointerOne]
            } else if (nums1[pointerOne] > nums2[pointerTwo]) {
                pointerTwo++
            } else {
                pointerOne++
            }
        }

        return -1
    }
}

fun main() {
    // Input
    val nums1 = intArrayOf(1, 2, 3)
    val nums2 = intArrayOf(2, 4)
    // Output
    LeetCode_2540().getCommon(nums1, nums2).run {
        println(this)
        require(2 == this)
    }
}
