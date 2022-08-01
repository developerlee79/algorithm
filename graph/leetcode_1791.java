package graph;

public class leetcode_1791 {
    public static void main(String[] args) {
        leetcode_1791 leetcode = new leetcode_1791();
        int[][] edges = {{1, 2}, {2, 3}, {4, 2}};
        System.out.println(leetcode.findCenter(edges));
    }

    // Solution..??
    // Time Complexity - O(1)
    // Space Complexity - O(1)
    // THIS IS NOT A PROBLEM
    public int findCenter(int[][] edges) {
        return edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1] ? edges[0][0] : edges[0][1];
    }
}
