package math

import kotlin.math.abs

class LeetCode_2849 {

    fun isReachableAtTime(sx: Int, sy: Int, fx: Int, fy: Int, t: Int): Boolean {
        val xDistance = abs(sx - fx)
        val yDistance = abs(sy - fy)
        if (t == 1 && xDistance == 0 && yDistance == 0) return false
        return maxOf(xDistance, yDistance) <= t
    }

}

fun main() {
    // Input
    val sx = 2
    val sy = 4
    val fx = 7
    val fy = 7
    val t = 6
    // Output
    LeetCode_2849().isReachableAtTime(sx, sy, fx, fy, t).run {
        println(this)
        require(this)
    }
}
