package simulation

class LeetCode_2739 {

    fun distanceTraveled(mainTank: Int, additionalTank: Int): Int {
        var currentFuel = mainTank
        var currentAdditionalFuel = additionalTank

        while (currentFuel >= 5) {
            currentFuel -= 5

            if (currentAdditionalFuel > 0) {
                currentFuel++
                currentAdditionalFuel--
            }
        }

        return (mainTank * 10) + ((additionalTank - currentAdditionalFuel) * 10)
    }
}

fun main() {
    // Input
    val mainTank = 5
    val additionalTank = 10
    // Output
    LeetCode_2739().distanceTraveled(mainTank, additionalTank).run {
        println(this)
        require(60 == this)
    }
}
