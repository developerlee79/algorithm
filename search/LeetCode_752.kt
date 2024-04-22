package search

import java.util.LinkedList
import java.util.Queue

class LeetCode_752 {

    fun openLock(deadends: Array<String>, target: String): Int {
        val visited = HashSet<String>()

        val initState = "0000"

        deadends.forEach { deadend ->
            if (target == deadend || initState == deadend) {
                return -1
            }

            visited.add(deadend)
        }

        val queue: Queue<String> = LinkedList()
        queue.add(initState)
        visited.add(initState)

        var count = 0

        while (queue.isNotEmpty()) {
            val queueSize = queue.size

            repeat(queueSize) {
                val lock = queue.poll()

                if (lock == target) {
                    return count
                }

                addTurnedWheelsToQueue(queue, visited, lock, true)
                addTurnedWheelsToQueue(queue, visited, lock, false)
            }

            count++
        }

        return -1
    }

    private fun addTurnedWheelsToQueue(
        queue: Queue<String>,
        visited: HashSet<String>,
        lock: String,
        isTurnLeft: Boolean
    ) {
        repeat(4) { rockNumber ->
            val turnedWheel = turnWheel(lock, rockNumber, isTurnLeft)

            if (visited.add(turnedWheel)) {
                queue.add(turnedWheel)
            }
        }
    }

    private fun turnWheel(target: String, rockNumber: Int, isTurnLeft: Boolean): String {
        val currentWheel = StringBuilder(target)

        val targetNumber = currentWheel[rockNumber]

        if (isTurnLeft) {
            currentWheel[rockNumber] = if (targetNumber == '9') '0' else targetNumber + 1
        } else {
            currentWheel[rockNumber] = if (targetNumber == '0') '9' else targetNumber - 1
        }

        return currentWheel.toString()
    }
}

fun main() {
    // Input
    val deadends = arrayOf("0201", "0101", "0102", "1212", "2002")
    val target = "0202"
    // Output
    LeetCode_752().openLock(deadends, target).run {
        println(this)
        require(6 == this)
    }
}
