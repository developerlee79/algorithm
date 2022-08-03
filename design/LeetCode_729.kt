package design

import java.util.*

class LeetCode_729 {

    class MyCalendar {

        private val bookSet = TreeSet { a: IntArray, b: IntArray -> a[0] - b[0] }

        /**
         * Solution - Tree Set
         * Time Complexity : O(logN)
         * Space Complexity : O(N)
         *
         * Maintain the order of the reservations with TreeSet and compare the reservations before and after the reservations to be added to ensure that the reservations are valid.
         *
         * @param start Integer representing the date which want to book
         * @param end Integer representing the date which want to book
         * @return Is the event can be added to the calendar successfully without causing a double booking
         */
        fun book(start: Int, end: Int): Boolean {
            val book = intArrayOf(start, end)
            val floor = bookSet.floor(book)
            val ceiling = bookSet.ceiling(book)

            return if (floor != null && start < floor[1]) {
                false
            } else if (ceiling != null && ceiling[0] < end) {
                false
            } else {
                bookSet.add(book)
                true
            }
        }

    }
}

fun main() {
    val myCalendar = LeetCode_729.MyCalendar()
    println(myCalendar.book(10, 20))
    println(myCalendar.book(15, 25))
    println(myCalendar.book(20, 30))
}
