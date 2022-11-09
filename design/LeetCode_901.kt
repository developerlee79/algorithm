package design

import java.util.Stack

class LeetCode_901 {

    class StockSpanner {

        private val stockStack = Stack<Pair<Int, Int>>()

        /**
         * Solution : Monotonic Stack
         * Time Complexity : O(N)
         * Space Complexity : O(N)
         *
         * The idea is to exclude unnecessary calculations by add the number of unnecessary (less than that) stocks between each value into the pair.
         *
         * @param price integer
         * @return the span of that stock's price for the current day
         */
        fun next(price: Int): Int {
            var span = 1

            while (stockStack.isNotEmpty() && stockStack.peek().first <= price) {
                span += stockStack.pop().second
            }

            stockStack.push(Pair(price, span))

            return span
        }
    }
}

fun main() {
    // Input
    val stockSpanner = LeetCode_901.StockSpanner()
    // Output
    println(stockSpanner.next(100))
    println(stockSpanner.next(80))
    println(stockSpanner.next(60))
    println(stockSpanner.next(70))
    println(stockSpanner.next(60))
    println(stockSpanner.next(75))
    println(stockSpanner.next(85))
}
