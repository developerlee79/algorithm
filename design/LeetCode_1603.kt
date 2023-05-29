package design

class LeetCode_1603 {

    class ParkingSystem(
        private var big: Int,
        private var medium: Int,
        private var small: Int
    ) {

        fun addCar(carType: Int) =
            when (carType) {
                1 -> big-- > 0
                2 -> medium-- > 0
                3 -> small-- > 0
                else -> false
            }
    }
}

fun main() {
    // Input
    val big = 1
    val medium = 1
    val small = 0
    val parkingSystem = LeetCode_1603.ParkingSystem(big, medium, small)
    // Output
    require(parkingSystem.addCar(1))
    require(parkingSystem.addCar(2))
    require(!parkingSystem.addCar(3))
    require(!parkingSystem.addCar(1))
}
