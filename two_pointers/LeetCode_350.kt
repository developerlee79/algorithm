package two_pointers

class LeetCode_350 {

    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        nums1.sort()
        nums2.sort()

        var firstIndex = 0
        var secondIndex = 0
        val resultList = mutableListOf<Int>()

        while (firstIndex in nums1.indices && secondIndex in nums2.indices) {
            if (nums1[firstIndex] == nums2[secondIndex]) {
                resultList.add(nums1[firstIndex])
                firstIndex++
                secondIndex++
            } else if (nums1[firstIndex] > nums2[secondIndex]) {
                secondIndex++
            } else {
                firstIndex++
            }
        }

        return resultList.toIntArray()
    }
}

fun main() {
    // Input
    val nums1 = intArrayOf(1, 2, 2, 1)
    val nums2 = intArrayOf(2, 2)
    // Output
    LeetCode_350().intersect(nums1, nums2).run {
        println(this.joinToString())
        require(
            intArrayOf(2, 2,).contentEquals(this)
        )
    }
}
