package bit_manipulation

class LeetCode_393 {

    /**
     * Solution - Binary String
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     *
     * Check first n bit which value is 1 to validate utf-8.
     *
     * Edge case :
     * 1. 1-byte char : when 128 > num, it's always be 1-byte char.
     * 2. 4+n-byte char : when count of 1 > 4, it's invalid encoding.
     *
     * @param data integer array representing the 1 byte of data
     * @return return whether it is a valid UTF-8 encoding
    */
    fun validUtf8(data: IntArray): Boolean {
        var i = 0
        while (i < data.size) {
            val num = data[i++]

            if (128 > num) {
                continue
            }

            val binaryString = Integer.toBinaryString(num)

            var sequence = binaryString.takeWhile { it == '1' }.length - 1

            if (sequence == 0 || sequence > 4 || sequence > data.size - i) {
                return false
            }

            while (sequence > 0) {
                val binary = Integer.toBinaryString(data[i++])

                if (binary.length != 8 || binary.substring(0, 2) != "10") {
                    return false
                }

                sequence--
            }
        }

        return true
    }
}

fun main() {
    val data = intArrayOf(250, 145, 145, 145, 145)
    println(LeetCode_393().validUtf8(data))
}
