package tree;

import java.util.PriorityQueue;

public class leetcode_703 {
    public static void main(String[] args) {
        int[] nums = {4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(3, nums);
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));
    }

    // Solution - Priority queue
    // Time Complexity : initialize - O(N) / add - O(1)
    // Space Complexity : initialize - O(N) / add - O(1)
    // Most important thing in this problem is add method.
    // it add value in queue progressively. when queue size exceeds, it means we have to pick out kth value.
    // if added value is larger than the existing kth value, existing value is fall behind and polled.
    // because the priority queue is sorted in order at insertion.
    // if added value is less than the existing kth value, added value is fall behind and polled.
    // therefore, the k-th order is maintained.
    // at last, peek the result of this operation(current kth value).
    static class KthLargest {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int k;

        KthLargest(int k, int[] nums) {
            this.k = k;

            for (int i : nums)
                add(i);
        }

        int add(int val) {
            queue.add(val);

            if (queue.size() > k)
                queue.poll();

            return queue.peek();
        }
    }
}
