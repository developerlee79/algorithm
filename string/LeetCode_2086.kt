package string

class LeetCode_2086 {

    fun minimumBuckets(hamsters: String): Int {
        if (hamsters.length == 1) {
            return if (hamsters[0] == 'H') {
                -1
            } else {
                0
            }
        }

        var index = 0
        var buckets = 0

        while (index < hamsters.length) {
            if (hamsters[index] == 'H') {
                if (index - 1 in hamsters.indices && index + 1 in hamsters.indices) {
                    if (hamsters[index + 1] == '.') {
                        index += 2
                    } else if (hamsters[index - 1] != '.') {
                        return -1
                    }
                } else if (index - 1 in hamsters.indices) {
                    if (hamsters[index - 1] != '.') {
                        return -1
                    }
                } else {
                    if (hamsters[index + 1] == '.') {
                        index += 2
                    } else {
                        return -1
                    }
                }

                buckets++
            }
            index++
        }

        return buckets
    }
}

fun main() {
    // Input
    val hamsters = "H..H"
    // Output
    LeetCode_2086().minimumBuckets(hamsters).let {
        println(it)
        require(it == 2)
    }
}
