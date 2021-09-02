package Algorithm.structure.graph;

public class DFS {
    int nodeNum;
    ListGraph listGraph;

    public DFS(int n) {
        nodeNum = n;
        listGraph = new ListGraph(nodeNum);
    }

    void addNode(int x, int y) {
        listGraph.put(x, y);
    }

    public static void main(String[] args) {
        DFS dfs = new DFS(4);

        dfs.addNode(0, 1);
        dfs.addNode(0, 2);
        dfs.addNode(1, 2);
        dfs.addNode(2, 0);
        dfs.addNode(2, 3);
        dfs.addNode(3, 3);

        boolean[] validNode = new boolean[dfs.nodeNum];
        dfs.search(validNode, 2);
    }

    void search(boolean[] validNode, int n) {
        validNode[n] = true;
        System.out.println(n);

        for (int nd : listGraph.getNode(n)) {
            if (!validNode[nd]) search(validNode, nd);
        }
    }
}
