package testet

class LeetCode_1441 {

    fun buildArray(target: IntArray, n: Int): List<String> {
        val operationList = mutableListOf<String>()

        var currentNumber = 1
        var index = 0

        val targetSize = target.size

        while (index < targetSize && currentNumber <= n) {
            while (target[index] != currentNumber) {
                operationList.add("Push")
                operationList.add("Pop")
                currentNumber++
            }

            operationList.add("Push")

            index++
            currentNumber++
        }

        return operationList
    }

}

fun main() {
    // Input
    val target = intArrayOf(1, 3)
    val n = 3
    // Output
    LeetCode_1441().buildArray(target, n).run {
        println(this)
        require(
            listOf("Push", "Push", "Pop", "Push") == this
        )
    }
}
