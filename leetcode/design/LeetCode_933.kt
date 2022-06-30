package design

import java.util.LinkedList
import java.util.Queue

class LeetCode_933 {

    class RecentCounter {

        private val pingQueue: Queue<Int> = LinkedList()

        /**
         * Solution - Queue
         * Time Complexity : O(1)
         * Space Complexity : O(N)
         *
         * Use Queue to count the recent requests.
         *
         * @param t Ping!
         * @return number of requests that has happened in the past 3000 milliseconds
        */
        fun ping(t: Int): Int {
            val pingRange = t - 3000

            while (pingQueue.isNotEmpty() && pingQueue.peek() < pingRange) {
                pingQueue.poll()
            }
            pingQueue.add(t)

            return pingQueue.size
        }
    }
}

fun main() {
    val obj = LeetCode_933.RecentCounter()
    println(obj.ping(1))
    println(obj.ping(100))
    println(obj.ping(3001))
    println(obj.ping(3002))
}
