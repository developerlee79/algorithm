package sort

import java.util.PriorityQueue

class LeetCode_621 {

    fun leastInterval(tasks: CharArray, n: Int): Int {
        val taskMap = IntArray(26)

        tasks.forEach { task -> taskMap[task - 'A']++ }

        val taskQueue = PriorityQueue<Int>(reverseOrder())
        taskQueue.addAll(taskMap.filter { it > 0 })

        var cycle = 0

        while (taskQueue.isNotEmpty()) {
            val queueSize = taskQueue.size
            val repeatSize = minOf(queueSize, n + 1)

            val tempList = mutableListOf<Int>()

            repeat(repeatSize) {
                val currentTask = taskQueue.poll()

                if (currentTask > 1) {
                    tempList.add(currentTask - 1)
                }
            }

            taskQueue.addAll(tempList)

            cycle += if (taskQueue.isNotEmpty()) n + 1 else queueSize
        }

        return cycle
    }
}

fun main() {
    // Input
    val tasks = charArrayOf('A', 'A', 'A', 'B', 'B', 'B')
    val n = 2
    // Output
    LeetCode_621().leastInterval(tasks, n).run {
        println(this)
        require(8 == this)
    }
}
