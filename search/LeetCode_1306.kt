package search

class LeetCode_1306 {

    fun canReach(arr: IntArray, start: Int): Boolean {
        return search(arr, start, BooleanArray(arr.size))
    }

    private fun search(arr: IntArray, index: Int, visited: BooleanArray): Boolean {
        if (index !in arr.indices || visited[index]) {
            return false
        }

        if (arr[index] == 0) {
            return true
        }

        visited[index] = true

        return search(arr, index - arr[index], visited) || search(arr, index + arr[index], visited)
    }
}

fun main() {
    // Input
    val arr = intArrayOf(4, 2, 3, 0, 3, 1, 2)
    val start = 5
    // Output
    LeetCode_1306().canReach(arr, start).let {
        println(it)
        require(it)
    }
}
