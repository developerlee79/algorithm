package graph

import java.util.LinkedList
import java.util.Queue

class LeetCode_841 {

    fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
        val visitedRoom = BooleanArray(rooms.size)

        val queue: Queue<List<Int>> = LinkedList()
        queue.offer(rooms.first())
        visitedRoom[0] = true

        while (queue.isNotEmpty()) {
            queue.poll().forEach {
                if (!visitedRoom[it]) {
                    queue.offer(rooms[it])
                    visitedRoom[it] = true
                }
            }
        }

        return visitedRoom.all { it }
    }
}

fun main() {
    // Input
    val rooms = listOf(
        listOf(1),
        listOf(2),
        listOf(3),
        listOf(),
    )
    // Output
    LeetCode_841().canVisitAllRooms(rooms).let {
        println(it)
        require(it)
    }
}
