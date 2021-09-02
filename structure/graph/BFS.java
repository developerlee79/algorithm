package Algorithm.search;

import java.util.LinkedList;

public class BFS {
    int node;
    LinkedList<Integer>[] listGraph;

    public BFS(int nd) {
        node = nd;
        listGraph = new LinkedList[nd];

        for (int i = 0; i < nd; i++) {
            listGraph[i] = new LinkedList<>();
        }
    }

    void addEdge(int nd, int nextNd) {
        listGraph[nd].add(nextNd);
    }

    void search(int n) {
        boolean[] visited = new boolean[node];
        LinkedList<Integer> queue = new LinkedList<>();

        visited[n] = true;
        queue.add(n);

        while (queue.size() != 0) {
            n = queue.poll();
            System.out.println(n);

            for (int a : listGraph[n]) {
                if (!visited[a]) {
                    visited[a] = true;
                    queue.add(a);
                }
            }
        }
    }

    public static void main(String[] args) {
        BFS bfs = new BFS(5);

        bfs.addEdge(0, 1);
        bfs.addEdge(0, 2);
        bfs.addEdge(1, 2);
        bfs.addEdge(2, 0);
        bfs.addEdge(2, 3);
        bfs.addEdge(3, 4);
        bfs.addEdge(4, 4);

        bfs.search(2);
    }
}
