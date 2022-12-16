package design

import java.util.Stack

class LeetCode_232 {

    class MyQueue {

        private val inputStack = Stack<Int>()
        private val outputStack = Stack<Int>()

        fun push(x: Int) {
            inputStack.push(x)
        }

        fun pop(): Int {
            this.peek()
            return outputStack.pop()
        }

        fun peek(): Int {
            if (outputStack.isEmpty()) {
                while (inputStack.isNotEmpty()) {
                    outputStack.push(inputStack.pop())
                }
            }
            return outputStack.peek()
        }

        fun empty(): Boolean =
            inputStack.isEmpty() && outputStack.isEmpty()

    }
}

fun main() {
    // Input
    val myQueue = LeetCode_232.MyQueue()
    // Output
    myQueue.push(1)
    myQueue.push(2)
    println(myQueue.peek())
    println(myQueue.pop())
    println(myQueue.empty())
}
