package two_pointers

class LeetCode_287 {

    fun findDuplicate(nums: IntArray): Int {
        var slowPointer = nums[0]
        var fastPointer = nums[0]

        while (true) {
            slowPointer = nums[slowPointer]
            fastPointer = nums[nums[fastPointer]]

            if (slowPointer == fastPointer) {
                break
            }
        }

        var pointer = nums[0]

        while (slowPointer != pointer) {
            slowPointer = nums[slowPointer]
            pointer = nums[pointer]
        }

        return slowPointer
    }
}

fun main() {
    // Input
    val nums = intArrayOf(1, 3, 4, 2, 2)
    // Output
    LeetCode_287().findDuplicate(nums).run {
        println(this)
        require(2 == this)
    }
}
