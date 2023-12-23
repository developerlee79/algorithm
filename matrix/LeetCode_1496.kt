package matrix

class LeetCode_1496 {

    fun isPathCrossing(path: String): Boolean {
        val coordinateSet = hashSetOf("0 0")

        var xCoordinate = 0
        var yCoordinate = 0

        for (direction in path) {
            when (direction) {
                'N' -> yCoordinate++
                'S' -> yCoordinate--
                'E' -> xCoordinate--
                'W' -> xCoordinate++
            }

            if (!coordinateSet.add("$xCoordinate $yCoordinate")) {
                return true
            }
        }

        return false
    }
}

fun main() {
    // Input
    val path = "NES"
    // Output
    LeetCode_1496().isPathCrossing(path).run {
        println(this)
        require(!this)
    }
}
