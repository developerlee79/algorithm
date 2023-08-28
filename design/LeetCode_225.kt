package design

import java.util.LinkedList
import java.util.Queue

class LeetCode_225 {

    class MyStack {

        private val stackQueue: Queue<Int> = LinkedList()

        fun push(x: Int) {
            val currentSize = stackQueue.size

            stackQueue.add(x)

            repeat (currentSize) {
                stackQueue.add(stackQueue.poll())
            }
        }

        fun pop(): Int = stackQueue.poll()

        fun top(): Int = stackQueue.peek()

        fun empty(): Boolean = stackQueue.isEmpty()

    }
}

fun main() {
    // Input
    val myStack = LeetCode_225.MyStack()
    myStack.push(1)
    myStack.push(2)
    // Output
    require(2 == myStack.top())
    require(2 == myStack.pop())
    require(!myStack.empty())
}
