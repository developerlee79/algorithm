package array

class LeetCode_2391 {

    fun garbageCollection(garbage: Array<String>, travel: IntArray): Int {
        val garbageLocations = Array(3) { intArrayOf(-1, 0) }

        for (i in garbage.indices.reversed()) {
            for (trashType in garbage[i]) {
                when (trashType) {
                    'G' -> {
                        if (garbageLocations[0][0] == -1) {
                            garbageLocations[0][0] = i
                        }
                        garbageLocations[0][1]++
                    }

                    'P' -> {
                        if (garbageLocations[1][0] == -1) {
                            garbageLocations[1][0] = i
                        }
                        garbageLocations[1][1]++
                    }

                    'M' -> {
                        if (garbageLocations[2][0] == -1) {
                            garbageLocations[2][0] = i
                        }
                        garbageLocations[2][1]++
                    }
                }
            }
        }

        val prefixSum = IntArray(travel.size + 1)

        for (i in 1 until travel.size + 1) {
            prefixSum[i] = prefixSum[i - 1] + travel[i - 1]
        }

        var totalMinutes = 0

        for (garbageLocation in garbageLocations) {
            if (garbageLocation[0] != -1) {
                totalMinutes += garbageLocation[1] + prefixSum[garbageLocation[0]]
            }
        }

        return totalMinutes
    }
}

fun main() {
    // Input
    val garbage = arrayOf("G", "P", "GP", "GG")
    val travel = intArrayOf(2, 4, 3)
    // Output
    LeetCode_2391().garbageCollection(garbage, travel).run {
        println(this)
        require(21 == this)
    }
}
