package Algorithm.structure.graph;

public class ArrGraph {
    private int[][] arrGraph;

    public ArrGraph(int initSize) {
        this.arrGraph = new int[initSize+1][initSize+1];
    }

    public int[][] getGraph() {
        return this.arrGraph;
    }

    public void put(int x, int y) {
        arrGraph[x][y] = arrGraph[y][x] = 1;
    }

    public void putSingle(int x, int y) {
        arrGraph[x][y] = 1;
    }
}
