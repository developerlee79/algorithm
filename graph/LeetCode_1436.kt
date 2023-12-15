package graph

class LeetCode_1436 {

    fun destCity(paths: List<List<String>>): String {
        val pathSet = HashSet<String>(paths.size)

        for (path in paths) {
            pathSet.add(path[0])
        }

        for (path in paths) {
            if (!pathSet.contains(path[0])) {
                return path[0]
            } else if (!pathSet.contains(path[1])) {
                return path[1]
            }
        }

        return ""
    }
}

fun main() {
    // Input
    val paths = listOf(
        listOf("London", "New York"),
        listOf("New York", "Lima"),
        listOf("Lima", "Sao Paulo")
    )
    // Output
    LeetCode_1436().destCity(paths).run {
        println(this)
        require("Sao Paulo" == this)
    }
}
