package math

class LeetCode_858 {

    /**
     * Solution - Math
     * Time Complexity : O(logN)
     * Space Complexity : O(1)
     *
     * Since the room is square, the location where the laser is reflected is the "mirror" location of the current location. So you can think of the same room as a concept of "expansion".
     * If the number of light reflections is odd, the corner is on the left, and the number of reflections is two.
     * Otherwise, the corner is on the right, and the number of reflections is 0 or 1.
     * If the room has an even number of "extended", the number of reflections is 1. If not, it's zero.
     *
     * @param p length of wall
     * @param q where the laser beam meets the east wall at the southwest corner
     * @return number of the receptor that the ray meets first
     */
    fun mirrorReflection(p: Int, q: Int): Int {
        var m = q
        var n = p

        while (m % 2 == 0 && n % 2 == 0) {
            m /= 2
            n /= 2
        }

        return if (!isOdd(m) && isOdd(n))
            0
        else if (isOdd(m) && isOdd(n))
            1
        else if (isOdd(m) && !isOdd(n))
            2
        else
            -1
    }

    private fun isOdd(num: Int): Boolean {
        return num % 2 != 0
    }
}

fun main() {
    val p = 2
    val q = 1
    println(LeetCode_858().mirrorReflection(p, q))
}
