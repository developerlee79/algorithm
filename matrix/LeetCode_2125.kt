package matrix

class LeetCode_2125 {

    fun numberOfBeams(bank: Array<String>): Int {
        var beams = 0
        var deviceInLastRow = 0

        for (devices in bank) {
            val deviceInRow = devices.count { it == '1' }

            if (deviceInRow != 0) {
                beams += deviceInLastRow * deviceInRow
                deviceInLastRow = deviceInRow
            }
        }

        return beams
    }
}

fun main() {
    // Input
    val bank = arrayOf("011001", "000000", "010100", "001000")
    // Output
    LeetCode_2125().numberOfBeams(bank).run {
        println(this)
        require(8 == this)
    }
}
