import java.util.*;

public class leetcode_1046 {
    public static void main(String[] args) {
        leetcode_1046 leetcode = new leetcode_1046();
        int[] stones = {2, 7, 4, 1, 8, 1};
        System.out.println(leetcode.lastStoneWeight(stones));
    }

    // Solution - Priority queue
    // Time Complexity : O(NlogN)
    // Space Complexity : O(N)
    // Put all elements into a priority queue what order of highest number.
    // poll two highest element and add difference at queue.
    // iterative till no more two elements left.
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i : stones)
            queue.add(i);

        while (queue.size() > 1)
            queue.add(Math.abs(queue.poll() - queue.poll()));

        return queue.poll();
    }
}
