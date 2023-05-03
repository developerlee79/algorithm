package array

class LeetCode_2215 {

    fun findDifference(nums1: IntArray, nums2: IntArray): List<List<Int>> {
        val resultList = List<MutableList<Int>>(2) { mutableListOf() }

        val set1 = nums1.toSet()
        val set2 = nums2.toSet()

        set1.forEach {
            if (!set2.contains(it)) {
                resultList[0].add(it)
            }
        }

        set2.forEach {
            if (!set1.contains(it)) {
                resultList[1].add(it)
            }
        }

        return resultList
    }
}

fun main() {
    // Input
    val nums1 = intArrayOf(1, 2, 3)
    val nums2 = intArrayOf(2, 4, 6)
    // Output
    LeetCode_2215().findDifference(nums1, nums2).run {
        println(this)
        require(
            listOf(listOf(1, 3), listOf(4, 6)) == this
        )
    }
}
