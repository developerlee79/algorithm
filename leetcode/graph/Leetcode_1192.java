package leetcode.graph;

import java.util.*;

public class Leetcode_1192 {
    public static void main(String[] args) {
        Leetcode_1192 leetcode = new Leetcode_1192();
        int n = 4;
        List<List<Integer>> connections = Arrays.asList(Arrays.asList(0, 1), Arrays.asList(1, 2), Arrays.asList(2, 0), Arrays.asList(1, 3));
        System.out.println(leetcode.criticalConnections(n, connections));
    }

    /**
     * @param n Number of nodes on the network
     * @param connections List of edges connecting network nodes
     * @return 'critical connections' - Articulation point
     *
     * Solution - Tarjan's Algorithm
     * Time Complexity : O(V + E)
     * Space Complexity : O(N)
     *
     * Use the Tarjan's Algorithm to locate 'critical connections' of the network.
     * Basically Tarjan's Algorithm use DFS for search.
     * Because undirected graphs cannot search with DFS immediately, prepare to search with DFS by mapping values to Map which consist of <Node : Neighbor Node List>.
     * When a DFS starts, it navigates neighboring nodes and increases the number of searches.
     * After searching to the end, if the number of references is less than the neighboring node visited - that is, No Cycle - add the connection to the list of results because it is "critical connections".
     */
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        Map<Integer, List<Integer>> graphMap = new HashMap<>();

        for (List<Integer> conn : connections) {
            int currentNode = conn.get(0);
            int connectedNode = conn.get(1);
            graphMap.putIfAbsent(currentNode, new ArrayList<>());
            graphMap.putIfAbsent(connectedNode, new ArrayList<>());
            graphMap.get(currentNode).add(connectedNode);
            graphMap.get(connectedNode).add(currentNode);
        }

        int[] discoveredCount = new int[n];
        int[] farthestNode = new int[n];
        boolean[] visited = new boolean[n];
        List<List<Integer>> criticalConnectionList = new ArrayList<>();

        dfs(graphMap, criticalConnectionList, 0, -1, discoveredCount, farthestNode, visited);

        return criticalConnectionList;
    }

    private int time = 0;

    private void dfs(Map<Integer, List<Integer>> graphMap, List<List<Integer>> criticalConnectionList, int currentNode, int parentNode, int[] discoveredCount, int[] farthestNode, boolean[] visited) {
        visited[currentNode] = true;
        discoveredCount[currentNode] = time++;
        farthestNode[currentNode] = discoveredCount[currentNode];

        List<Integer> neighbors = graphMap.get(currentNode);
        if (neighbors == null) {
            return;
        }

        for (Integer connectedNode : neighbors) {
            if (connectedNode == parentNode) {
                continue;
            }

            if (!visited[connectedNode]) {
                dfs(graphMap, criticalConnectionList, connectedNode, currentNode, discoveredCount, farthestNode, visited);

                farthestNode[currentNode] = Math.min(farthestNode[currentNode], farthestNode[connectedNode]);

                if (discoveredCount[currentNode] < farthestNode[connectedNode]) {
                    criticalConnectionList.add(Arrays.asList(currentNode, connectedNode));
                }
            } else {
                farthestNode[currentNode] = Math.min(farthestNode[currentNode], discoveredCount[connectedNode]);
            }
        }
    }
}
