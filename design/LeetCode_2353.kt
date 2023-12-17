package design

import java.util.*

class LeetCode_2353 {

    private class Food(
        var name: String,
        var cuisine: String,
        var rating: Int
    )

    class FoodRatings(
        foods: Array<String>,
        cuisines: Array<String>,
        ratings: IntArray
    ) {

        private val cuisineMap = HashMap<String, String>()
        private val priorityQueueHashMap = HashMap<String, PriorityQueue<Food>>()

        init {
            for (i in foods.indices) {
                val food = Food(foods[i], cuisines[i], ratings[i])

                priorityQueueHashMap.putIfAbsent(food.cuisine, PriorityQueue { a: Food, b: Food ->
                    if (a.rating == b.rating) a.name.compareTo(b.name) else b.rating - a.rating
                })

                priorityQueueHashMap[food.cuisine]?.add(food)
                cuisineMap[food.name] = food.cuisine
            }
        }

        fun changeRating(food: String, newRating: Int) {
            val cuisine = cuisineMap[food]
            val pq = priorityQueueHashMap[cuisine]!!

            var removeFood: Food? = null

            for (f in pq) {
                if (f!!.name == food) removeFood = f
            }

            pq.remove(removeFood)
            removeFood!!.rating = newRating
            pq.offer(removeFood)
        }

        fun highestRated(cuisine: String): String {
            return priorityQueueHashMap[cuisine]!!.peek()!!.name
        }
    }

}
