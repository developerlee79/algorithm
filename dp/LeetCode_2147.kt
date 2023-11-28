package dp

class LeetCode_2147 {

    fun numberOfWays(corridor: String): Int {
        val n = corridor.length

        var plants = 0L
        var segments = 0

        var i = 0

        while (i < n && corridor[i] == 'P') {
            i++
        }

        while (i < n) {
            if (corridor[i] == 'S') {
                var j = i + 1

                while (j < n && corridor[j] != 'S') {
                    j++
                }

                if (j == n) {
                    return 0
                }

                i = j + 1
                segments++
            }

            var currentPlants = 0
            while (i < n && corridor[i] == 'P') {
                i++
                currentPlants++
            }

            if (i != n && currentPlants != 0) {
                if (plants == 0L) {
                    plants += currentPlants + 1
                } else {
                    plants = (plants * (currentPlants + 1)) % 1000000007
                }
            }
        }

        if (segments < 2) {
            return segments
        } else if (plants == 0L) {
            return 1
        }

        return (plants % 1000000007).toInt()
    }
}

fun main() {
    // Input
    val corridor = "SSPPSPS"
    // Output
    LeetCode_2147().numberOfWays(corridor).run {
        println(this)
        require(3 == this)
    }
}
