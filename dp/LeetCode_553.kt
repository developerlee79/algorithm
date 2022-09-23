package dp

class LeetCode_553 {

    /**
     * Problem - Optimal Division (553)
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * @param nums integer array
     * @return Return the corresponding expression that has the maximum value in string format
    */
    fun optimalDivision(nums: IntArray): String {
        if (nums.size <= 3) {
            when (nums.size) {
                1 -> return nums[0].toString()
                2 -> return nums[0].toString() + "/" + nums[1]
                3 -> return nums[0].toString() + "/" + "(" + nums[1] + "/" + nums[2] + ")"
            }
        }

        val optimalString = StringBuilder(nums[0].toString() + "/")
        recursive(nums.copyOfRange(1, nums.size), optimalString)
        return optimalString.append(")").toString()
    }

    private fun recursive(target: IntArray, stringBuilder: StringBuilder): Double {
        if (target.size == 2) {
            stringBuilder.append("(")
                .append(target[0])
                .append("/")
                .append(target[1])
            return target[0].toDouble() / target[1]
        }

        val leftOptimalString = StringBuilder()
        val leftOptimal = recursive(target.copyOfRange(0, target.lastIndex), leftOptimalString) / target.last()

        val rightOptimalString = StringBuilder()
        val rightOptimal = target[0] / recursive(target.copyOfRange(1, target.size), rightOptimalString)

        return if (leftOptimal <= rightOptimal) {
            stringBuilder.append(leftOptimalString).append("/").append(target.last())
            leftOptimal
        } else {
            stringBuilder.append(rightOptimalString)
            stringBuilder.insert(0, "(" + target[0] + "/")
            stringBuilder.append("))")
            rightOptimal
        }
    }
}

fun main() {
    // input
    val nums = intArrayOf(1000, 100, 10, 2)
    // output
    val result = LeetCode_553().optimalDivision(nums)
    assert("1000/(100/10/2)" == result)
    println(result)
}
