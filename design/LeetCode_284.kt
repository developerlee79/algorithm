package design

class LeetCode_284 {

    class PeekingIterator(
        private val iterator: Iterator<Int>
    ) : Iterator<Int> {

        private var top = 0
        private var isPeeked = false

        fun peek(): Int {
            if (!isPeeked) {
                this.top = this.iterator.next()
                this.isPeeked = true
            }

            return this.top
        }

        override fun next(): Int {
            return if (isPeeked) {
                isPeeked = false
                this.top
            } else {
                this.iterator.next()
            }
        }

        override fun hasNext(): Boolean {
            return isPeeked || this.iterator.hasNext()
        }
    }
}

fun main() {
    // Input
    val iterator = iterator<Int> { 1..3 }
    val peekingIterator = LeetCode_284.PeekingIterator(iterator)
    // Output
    assert(1 == peekingIterator.next())
    assert(2 == peekingIterator.peek())
    assert(2 == peekingIterator.next())
    assert(3 == peekingIterator.next())
    assert(!peekingIterator.hasNext())
}
