package sort

import java.util.*


class LeetCode_406 {

    /**
     * Solution - Greedy Sort
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * Use greedy style sort & linked list to solve the problem.
     * Because larger people don't have to care about the location of smaller people, they sort them in the order of height, and they sort the arrangement by putting smaller people in between.
     *
     * @param people integer array which are the attributes of some people in a queue
     * @return queue that is represented by the input array people
    */
    fun reconstructQueue(people: Array<IntArray>): Array<IntArray> {
        Arrays.sort(people) { a, b ->
            if (a[0] == b[0])
                a[1] - b[1]
            else
                b[0] - a[0]
        }

        val ordered = LinkedList<IntArray>()
        for (p in people) {
            ordered.add(p[1], p)
        }

        return ordered.toArray(Array(people.size) { IntArray(2) })
    }
}

fun main() {
    val people = arrayOf(
        intArrayOf(7, 0),
        intArrayOf(4, 4),
        intArrayOf(7, 1),
        intArrayOf(5, 0),
        intArrayOf(6, 1),
        intArrayOf(5, 2)
    )
    println(LeetCode_406().reconstructQueue(people).contentDeepToString())
}
