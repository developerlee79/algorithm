import java.util.PriorityQueue;

public class leetcode_smallest_in_sortMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        for (int[] R : matrix) {
            for (int a : R){
                heap.add(a);
                if(heap.size() > k)
                    heap.poll();
            }
        }
        return heap.peek();
    }
}
