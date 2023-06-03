package tree

import java.util.LinkedList
import java.util.Queue

class LeetCode_1376 {

    fun numOfMinutes(n: Int, headID: Int, manager: IntArray, informTime: IntArray): Int {
        val employeeMap = hashMapOf<Int, MutableList<Int>>()

        manager.forEachIndexed { index, it ->
            employeeMap.computeIfAbsent(it) { mutableListOf() }.add(index)
        }

        val employeeQueue: Queue<Pair<Int, Int>> = LinkedList()
        employeeQueue.offer(Pair(headID, 0))

        var minutes = 0

        while (employeeQueue.isNotEmpty()) {
            val currentEmployee = employeeQueue.poll()
            val currentIndex = currentEmployee.first
            val currentMinutes = currentEmployee.second

            minutes = maxOf(minutes, currentMinutes)

            employeeMap[currentIndex]?.forEach { idx ->
                employeeQueue.add(Pair(idx, informTime[currentIndex] + currentMinutes))
            }
        }

        return minutes
    }
}

fun main() {
    // Input
    val n = 6
    val headID = 2
    val manager = intArrayOf(2, 2, -1, 2, 2, 2)
    val informTime = intArrayOf(0, 0, 1, 0, 0, 0)
    // Output
    LeetCode_1376().numOfMinutes(n, headID, manager, informTime).run {
        println(this)
        require(1 == this)
    }
}
