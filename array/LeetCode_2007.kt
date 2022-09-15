package array

class LeetCode_2007 {

    /**
     * Solution - Hash Map
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * @param changed integer array
     * @return return original if changed is a doubled array
    */
    fun findOriginalArray(changed: IntArray): IntArray {
        if (changed.size % 2 != 0) {
            return intArrayOf()
        }

        val doubleMap = HashMap<Int, Int>()
        val originalArray = IntArray(changed.size / 2)

        for (i in changed.indices) {
            doubleMap.merge(changed[i], 1) {a, b -> a + b}
        }

        changed.sort()

        var index = 0
        for (i in changed) {
            if (doubleMap[i]!! <= 0) {
                continue
            }

            if (doubleMap.getOrDefault(i * 2, 0) <= 0) {
                return intArrayOf()
            }

            originalArray[index++] = i

            doubleMap.merge(i, 1) {a, b -> a - b}
            doubleMap.merge(i * 2, 1) {a, b -> a - b}
        }

        return originalArray
    }
}

fun main() {
    val changed = intArrayOf(1, 3, 4, 2, 6, 8)
    println(LeetCode_2007().findOriginalArray(changed).joinToString())
}
