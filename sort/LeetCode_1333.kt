package sort

class LeetCode_1333 {

    /**
     * Solution : Map
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * Firstable, We have to filter the restaurants by given condition.
     * Filter vegan friendly & price & distance with filter function.
     * Then, sort the filtered list by rating and id desc and create result array with their ids.
     *
     * @param restaurants of this Function
     * @param veganFriendly of this Function
     * @param maxPrice of this Function
     * @param maxDistance of this Function
     * @return restaurants Value Of This Function
    */
    fun filterRestaurants(restaurants: Array<IntArray>, veganFriendly: Int, maxPrice: Int, maxDistance: Int): List<Int> =
        restaurants.filter {
            (veganFriendly == 0 || (veganFriendly == 1 && it[2] == veganFriendly)) && it[3] <= maxPrice && it[4] <= maxDistance
        }.sortedWith(
            compareBy<IntArray>({ it[1] }, { it[0] }).reversed()
        ).map {
            it[0]
        }.toList()
}

fun main() {
    // Input
    val restaurants = arrayOf(
        intArrayOf(1, 4, 1, 40, 10),
        intArrayOf(2, 8, 0, 50, 5),
        intArrayOf(3, 8, 1, 30, 4),
        intArrayOf(4, 10, 0, 10, 3),
        intArrayOf(5, 1, 1, 15, 1),
    )
    val veganFriendly = 1
    val maxPrice = 50
    val maxDistance = 10
    // Output
    val result = LeetCode_1333().filterRestaurants(restaurants, veganFriendly, maxPrice, maxDistance)
    println(result)
    require(listOf(3, 1, 5) == result)
}
