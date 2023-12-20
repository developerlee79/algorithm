package graph

class LeetCode_1462 {

    fun checkIfPrerequisite(numCourses: Int, prerequisites: Array<IntArray>, queries: Array<IntArray>): List<Boolean> {
        val prerequisiteMap = Array(numCourses) { BooleanArray(numCourses) }

        prerequisites.forEach { prerequisite ->
            prerequisiteMap[prerequisite[1]][prerequisite[0]] = true
        }

        val checkList = BooleanArray(queries.size)

        queries.forEachIndexed { i, query ->
            checkList[i] = findCourseInMap(prerequisiteMap, query[0], query[1], BooleanArray(numCourses))
        }

        return checkList.toList()
    }

    private fun findCourseInMap(prerequisiteMap: Array<BooleanArray>, targetCourse: Int, currentIndex: Int, visited: BooleanArray): Boolean {
        if (prerequisiteMap[currentIndex][targetCourse]) {
            return true
        }

        if (visited[currentIndex]) {
            return false
        }

        visited[currentIndex] = true

        prerequisiteMap[currentIndex].forEachIndexed { course, isContain ->
            if (isContain && findCourseInMap(prerequisiteMap, targetCourse, course, visited)) {
                return true
            }
        }

        return false
    }
}

fun main() {
    // Input
    val numCourses = 2
    val prerequisites = arrayOf(
        intArrayOf(1, 0)
    )
    val queries = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(1, 0)
    )
    // Output
    LeetCode_1462().checkIfPrerequisite(numCourses, prerequisites, queries).run {
        println(this)
        require(
            listOf(false, true) == this
        )
    }
}
