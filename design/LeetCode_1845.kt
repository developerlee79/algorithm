package design

import java.util.PriorityQueue

class LeetCode_1845 {

    class SeatManager(n: Int) {

        private val seatQueue = PriorityQueue<Int>()

        init {
            seatQueue.addAll(1..n)
        }

        fun reserve(): Int {
            return seatQueue.poll()
        }

        fun unreserve(seatNumber: Int) {
            seatQueue.add(seatNumber)
        }

    }

}

fun main() {
    // Input
    val n = 5
    val seatManager = LeetCode_1845.SeatManager(n)
    // Output
    require(1 == seatManager.reserve())
    require(2 == seatManager.reserve())
    seatManager.unreserve(2)
    require(2 == seatManager.reserve())
    require(3 == seatManager.reserve())
    require(4 == seatManager.reserve())
    require(5 == seatManager.reserve())
    seatManager.unreserve(5)
    require(5 == seatManager.reserve())
}
