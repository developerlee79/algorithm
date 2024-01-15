package graph

import java.util.LinkedList
import java.util.Queue

class LeetCode_210 {

    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val courseMap = hashMapOf<Int, MutableList<Int>>()
        val linkCounter = IntArray(numCourses)

        for (prerequisite in prerequisites) {
            courseMap.computeIfAbsent(prerequisite[1]) { mutableListOf() }.add(prerequisite[0])
            linkCounter[prerequisite[0]]++
        }

        val courseQueue: Queue<Int> = LinkedList()

        repeat(numCourses) {
            if (linkCounter[it] == 0) {
                courseQueue.add(it)
            }
        }

        val courseList = mutableListOf<Int>()

        while (courseQueue.isNotEmpty()) {
            val currentCourse = courseQueue.poll()
            courseList.add(currentCourse)

            courseMap[currentCourse]?.forEach {
                linkCounter[it]--

                if (linkCounter[it] == 0) {
                    courseQueue.add(it)
                }
            }
        }

        if (courseList.size != numCourses) {
            return intArrayOf()
        }

        return courseList.toIntArray()
    }
}

fun main() {
    // Input
    val numCourses = 2
    val prerequisites = arrayOf(
        intArrayOf(1, 0)
    )
    // Output
    LeetCode_210().findOrder(numCourses, prerequisites).run {
        println(this.joinToString())
        require(
            intArrayOf(0, 1).contentEquals(this)
        )
    }
}
