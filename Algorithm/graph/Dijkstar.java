package Algorithm;

import java.util.HashMap;
import java.util.Queue;
import java.util.Vector;

public class Dijkstar {
    public static void main(String[] args) {
        Dijkstar dl = new Dijkstar();
        dl.dijkstra(1);   
        dl.quijkstra(1);
    }

    int number = 6;
    int INF = 10000000 ;
    int[][] node = {
            {0, 2, 5, 1, INF, INF},
            {2, 0, 3, 2, INF, INF},
            {5, 3, 0, 3, 1, 5},
            {1, 2, 3, 0, 1, INF},
            {INF, INF, 1, 1, 0, 2},
            {INF, INF, 5, INF, 2, 0}
    };
    boolean[] v = new boolean[6];
    int[] d = new int[6];

    int getSmallIndex() {
         int min = INF;
         int index = 0;

         for (int i = 0; i < number; i++) {
             if (d[i] < min && !v[i]) {
                 min = d[i];
                 index = i;
             }
         }

         return index;
    }

    void dijkstra(int start) {
        for (int i = 0; i < number; i++) {
             d[i] = node[start][i];
        }
        v[start] = true;
        for (int i = 0; i < number - 2; i++) {
            int current = getSmallIndex();
            v[current] = true;
            for (int j = 0; j < 6; j++) {
                if(!v[6]) {
                    if (d[current] + node[current][j] < d[j])
                        d[j] = d[current] + node[current][j];
                }
            }
        }
    }
}
