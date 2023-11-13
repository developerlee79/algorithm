package search

import java.util.LinkedList
import java.util.Queue

class LeetCode_815 {

    fun numBusesToDestination(routes: Array<IntArray>, source: Int, target: Int): Int {
        if (source == target) {
            return 0
        }

        val routeMap = constructRouteMap(routes)

        if (!routeMap.containsKey(source) || !routeMap.containsKey(target)) {
            return -1
        }

        val stationQueue: Queue<Int> = LinkedList()
        stationQueue.add(source)

        val visitedStation = hashSetOf<Int>()
        val visitedBus = hashSetOf<Int>()

        var busCount = 1

        while (stationQueue.isNotEmpty()) {
            val queueSize = stationQueue.size

            for (i in 0 until queueSize) {
                val currentStation = stationQueue.poll()

                routeMap[currentStation]?.forEach { busId ->
                    if (!visitedBus.add(busId)) {
                        return@forEach
                    }

                    for (nextStation in routes[busId]) {
                        if (visitedStation.contains(nextStation)) {
                            continue
                        }

                        if (nextStation == target) {
                            return busCount
                        }

                        stationQueue.add(nextStation)
                        visitedStation.add(nextStation)
                    }
                }
            }

            busCount++
        }

        return -1
    }

    private fun constructRouteMap(routes: Array<IntArray>): HashMap<Int, MutableList<Int>> {
        val routeMap = hashMapOf<Int, MutableList<Int>>()

        for (busId in routes.indices) {
            for (station in routes[busId]) {
                routeMap.computeIfAbsent(station) { mutableListOf() }.add(busId)
            }
        }

        return routeMap
    }

}

fun main() {
    // Input
    val routes = arrayOf(
        intArrayOf(1, 2, 7),
        intArrayOf(3, 6, 7),
    )
    val source = 1
    val target = 6
    // Output
    LeetCode_815().numBusesToDestination(routes, source, target).run {
        println(this)
        require(2 == this)
    }
}
