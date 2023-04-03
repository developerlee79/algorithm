package two_pointers

class LeetCode_881 {

    fun numRescueBoats(people: IntArray, limit: Int): Int {
        people.sort()

        var boatCount = 0

        var left = 0
        var right = people.lastIndex

        while (left <= right) {
            val sumOfCurrentWeight = people[left] + people[right]

            if (sumOfCurrentWeight <= limit) {
                left++
            }

            right--
            boatCount++
        }

        return boatCount
    }
}

fun main() {
    // Input
    val people = intArrayOf(3, 5, 3, 4)
    val limit = 5
    // Output
    LeetCode_881().numRescueBoats(people, limit).let {
        println(it)
        require(it == 4)
    }
}
