package leetcode.graph;

import java.util.*;

public class leetcode_743 {
    public static void main(String[] args) {
        leetcode_743 leetcode = new leetcode_743();
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int n = 4, k = 2;
        System.out.println(leetcode.networkDelayTime(times, n, k));
    }

    /**
     * @param times Network of N node which labeled from 1 to n
     * @param n Target Node
     * @param k Source Node
     * @return The time it takes for all the n nodes to receive the signal from node k
     *
     * Solution - BFS (Dijkstra)
     * Time Complexity : O(NlogN)
     * Space Complexity : O(N)
     *
     * Use Dijkstra algorithm to solve problem.
     * Inserts all nodes into a map configured with [node: Connected Node Information].
     * Initialize queue configured with int[distance up to here / next node] for Breadth-First Search.
     * Check if it is a visited node by circulating with a BFS, and check visited and reduce n (total node count).
     * If current node have another connected (candidate) node, add that node to the queue along with the distance up to current node.
     * Returns the count that you have added so far if you have searched all the nodes.
     */
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, Map<Integer, Integer>> networkMap = new HashMap<>();
        for (int[] time : times) {
            networkMap.putIfAbsent(time[0], new HashMap<>());
            networkMap.get(time[0]).put(time[1], time[2]);
        }

        Queue<int[]> networkQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        networkQueue.add(new int[]{0, k});

        boolean[] visited = new boolean[n + 1];

        int count = 0;
        while (!networkQueue.isEmpty()) {
            int[] node = networkQueue.remove();
            int currentNode = node[1], distanceToCurrent = node[0];

            if (visited[currentNode]) {
                continue;
            }
            visited[currentNode] = true;

            count = distanceToCurrent;
            if (n-- == 0) {
                return count;
            }

            if (networkMap.containsKey(currentNode)) {
                for (int nextNode : networkMap.get(currentNode).keySet()) {
                    networkQueue.add(new int[]{distanceToCurrent + networkMap.get(currentNode).get(nextNode), nextNode});
                }
            }
        }

        return n == 0 ? count : -1;
    }
}
