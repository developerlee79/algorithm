package Algorithm.structure.graph;

import java.util.ArrayList;

public class ListGraph {
    private ArrayList<ArrayList<Integer>> listGraph;

    public ListGraph(int initSize) {
        this.listGraph = new ArrayList<ArrayList<Integer>>();
        
        for (int i = 0; i < initSize + 1; i++) {
            listGraph.add(new ArrayList<Integer>());
        }
    }

    public ArrayList<ArrayList<Integer>> getGraph() {
        return this.listGraph;
    }

    public ArrayList<Integer> getNode(int i) {
        return this.listGraph.get(i);
    }

    public void put(int x, int y) {
        listGraph.get(x).add(y);
        listGraph.get(y).add(x);
    }

    public void putSingle(int x, int y) {
        listGraph.get(x).add(y);
    }
}
