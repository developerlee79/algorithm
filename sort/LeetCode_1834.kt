package sort

import java.util.PriorityQueue

class LeetCode_1834 {

    private class Task(
        val enqueueTime: Int,
        val processingTime: Int,
        val index: Int,
    )

    fun getOrder(tasks: Array<IntArray>): IntArray {
        val sortedTask = tasks.mapIndexed { index, task ->
            Task(
                enqueueTime = task.first(),
                processingTime = task.last(),
                index = index
            )
        }.sortedBy { it.enqueueTime }

        val priorityQueue = PriorityQueue<Task> { a, b ->
            when {
                a.processingTime > b.processingTime -> 1
                a.processingTime < b.processingTime -> -1
                a.index < b.index -> -1
                else -> 1
            }
        }

        val orderOfTasks = IntArray(tasks.size)
        var orderOfTasksIndex = 0

        var index = 0
        var currentTime = 0

        while (priorityQueue.isNotEmpty() or (index in sortedTask.indices)) {
            if (priorityQueue.isEmpty()) {
                currentTime = currentTime.coerceAtLeast(sortedTask[index].enqueueTime)
            }

            while (index in sortedTask.indices && sortedTask[index].enqueueTime <= currentTime) {
                priorityQueue.add(
                    sortedTask[index++]
                )
            }

            priorityQueue.poll().let {
                orderOfTasks[orderOfTasksIndex++] = it.index
                currentTime += it.processingTime
            }
        }

        return orderOfTasks
    }
}

fun main() {
    // Input
    val tasks = arrayOf(
        intArrayOf(1, 2),
        intArrayOf(2, 4),
        intArrayOf(3, 2),
        intArrayOf(4, 1),
    )
    // Output
    LeetCode_1834().getOrder(tasks).let {
        println(it.joinToString())
        require(
            it.contentEquals(
                intArrayOf(0, 2, 3, 1)
            )
        )
    }
}
