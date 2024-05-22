package matrix

class LeetCode_2061 {

    private val directions = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(1, 0),
        intArrayOf(0, -1),
        intArrayOf(-1, 0)
    )

    private var direction = 0

    private var cleanRoomCount = 0

    fun numberOfCleanRooms(room: Array<IntArray>): Int {
        val visited = Array(room.size) { IntArray(room[0].size) }
        cleanRoom(room, 0, 0, visited)
        return cleanRoomCount
    }

    private fun cleanRoom(room: Array<IntArray>, x: Int, y: Int, visited: Array<IntArray>) {
        if (x !in room.indices || y !in room[x].indices || room[x][y] == 1) {
            val x = x - directions[direction][0]
            val y = y - directions[direction][1]

            changeDirection()

            return cleanRoom(room, x, y, visited)
        }

        if (visited[x][y] == direction + 1) {
            return
        }

        if (visited[x][y] == 0) {
            visited[x][y] = direction + 1
            cleanRoomCount++
        }

        cleanRoom(room, x + directions[direction][0], y + directions[direction][1], visited)
    }

    private fun changeDirection() {
        direction++

        if (direction == directions.size) {
            direction = 0
        }
    }
}

fun main() {
    // Input
    val room = arrayOf(
        intArrayOf(0, 0, 0),
        intArrayOf(1, 1, 0),
        intArrayOf(0, 0, 0)
    )
    // Output
    LeetCode_2061().numberOfCleanRooms(room).run {
        println(this)
        require(7 == this)
    }
}
