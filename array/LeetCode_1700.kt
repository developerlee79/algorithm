package array

class LeetCode_1700 {

    fun countStudents(students: IntArray, sandwiches: IntArray): Int {
        var squareStudent = 0

        students.forEach { student -> if (student == 0) squareStudent++ }

        var circularStudent = students.size - squareStudent

        for (i in students.indices) {
            if (sandwiches[i] == 0) {
                if (squareStudent == 0) {
                    return circularStudent
                }

                squareStudent--
            } else {
                if (circularStudent == 0) {
                    return squareStudent
                }

                circularStudent--
            }
        }

        return 0
    }
}

fun main() {
    // Input
    val students = intArrayOf(1, 1, 0, 0)
    val sandwiches = intArrayOf(0, 1, 0, 1)
    // Output
    LeetCode_1700().countStudents(students, sandwiches).run {
        println(this)
        require(0 == this)
    }
}
