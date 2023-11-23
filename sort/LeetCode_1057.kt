package sort

import java.util.PriorityQueue
import kotlin.math.abs

class LeetCode_1057 {

    private class WorkerDistance(
        val distance: Int,
        val workerId: Int,
        val bikeId: Int
    ) {

        fun compareTo(otherDistance: WorkerDistance): Int {
            if (this.distance != otherDistance.distance) {
                return this.distance.compareTo(otherDistance.distance)
            }

            if (this.workerId == otherDistance.workerId) {
                return this.bikeId.compareTo(otherDistance.bikeId)
            }

            return this.workerId.compareTo(otherDistance.workerId)
        }
    }

    fun assignBikes(workers: Array<IntArray>, bikes: Array<IntArray>): IntArray {
        val n = workers.size

        val priorityQueue = PriorityQueue<WorkerDistance> { a, b -> a.compareTo(b) }

        for (i in workers.indices) {
            val worker = workers[i]

            for (j in bikes.indices) {
                priorityQueue.add(
                    WorkerDistance(findDistance(bikes[j], worker), i, j)
                )
            }
        }

        val assignArray = IntArray(n) { -1 }
        val assignedBike = BooleanArray(bikes.size)

        var i = 0

        while (i < n) {
            val workerDistance = priorityQueue.poll()

            if (assignArray[workerDistance.workerId] == -1 && !assignedBike[workerDistance.bikeId]) {
                assignArray[workerDistance.workerId] = workerDistance.bikeId
                assignedBike[workerDistance.bikeId] = true
                i++
            }
        }

        return assignArray
    }

    private fun findDistance(firstArray: IntArray, secondArray: IntArray) =
        abs(firstArray[0] - secondArray[0]) + abs(firstArray[1] - secondArray[1])

}

fun main() {
    // Input
    val workers = arrayOf(
        intArrayOf(0, 0),
        intArrayOf(1, 1),
        intArrayOf(2, 0)
    )
    val bikes = arrayOf(
        intArrayOf(1, 0),
        intArrayOf(2, 2),
        intArrayOf(2, 1)
    )
    // Output
    LeetCode_1057().assignBikes(workers, bikes).run {
        println(this.joinToString())
        require(
            intArrayOf(0, 2, 1).contentEquals(this)
        )
    }
}
