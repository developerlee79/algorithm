package design;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode_225 {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
    }

    // Solution - Linked list
    static class MyStack {

        private final Queue<Integer> stackQueue;

        public MyStack() {
            stackQueue = new LinkedList<>();
        }

        public void push(int x) {
            stackQueue.add(x);

            for (int i = 1; i < stackQueue.size(); i++)
                stackQueue.add(stackQueue.remove());
        }

        public int pop() {
            return stackQueue.remove();
        }

        public int top() {
            return stackQueue.peek();
        }

        public boolean empty() {
            return stackQueue.isEmpty();
        }
    }
}
