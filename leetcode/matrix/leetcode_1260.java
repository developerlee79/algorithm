package matrix;

import java.util.*;

public class leetcode_1260 {
    public static void main(String[] args) {
        leetcode_1260 leetcode = new leetcode_1260();
        int[][] grid = {{3, 8, 1, 9}, {19, 7, 2, 5}, {4, 6, 11, 10}, {12, 0, 21, 13}};
        int k = 9;
        System.out.println(Arrays.toString(leetcode.shiftGrid(grid, k).toArray()));
        System.out.println(Arrays.toString(leetcode.shiftGridWithReverseArray(grid, k).toArray()));
        System.out.println(Arrays.toString(leetcode.shiftGridWithIndexPointer(grid, k).toArray()));
    }

    // Solution 1 - Deque
    // Time Complexity : O(N)
    // Space Complexity : O(N)
    // Append all matrix elements at queue and shift(add tail element at head) it k times to make kth shifted matrix.
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> resultArrayList = new ArrayList<>();

        Deque<Integer> queue = new ArrayDeque<>();

        for (int[] row : grid) {
            for (int i : row) {
                queue.add(i);
            }
        }

        for (int i = 0; i < k; i++) {
            queue.addFirst(queue.pollLast());
        }

        for (int[] ints : grid) {
            List<Integer> list = new LinkedList<>();
            for (int j = 0; j < ints.length; j++) {
                list.add(queue.poll());
            }
            resultArrayList.add(list);
        }

        return resultArrayList;
    }

    // Solution 2 - Reverse array
    // Time Complexity : O(N)
    // Space Complexity : O(N)
    // Basic idea is same as Rotate Array(189) - flip array's subsets.
    // A matrix basically a linear array of m * n by default.
    // Therefore, converts the matrix into a one-dimensional array doesn't no cause any problem in calculate.
    // At first, flip array 0 to pointer(location of k at matrix)
    //  S                                  P
    // {3, 8, 1, 9, 19, 7, 2, 5, 4, 6, 11, 10, 12, 0, 21, 13}
    // {10, 11, 6, 4, 5, 2, 7, 19, 9, 1, 8, 3, 12, 0, 21, 13}
    //
    // Second, flip array array - k (right in front of last pointer) to end of array.
    //                                         P           E
    // {10, 11, 6, 4, 5, 2, 7, 19, 9, 1, 8, 3, 12, 0, 21, 13}
    // {10, 11, 6, 4, 5, 2, 7, 19, 9, 1, 8, 3, 13, 21, 0, 12}
    //
    // At last flip whole array to complete shifting elements.
    // {10, 11, 6, 4, 5, 2, 7, 19, 9, 1, 8, 3, 13, 21, 0, 12}
    // {12, 0, 21, 13, 3, 8, 1, 9, 19, 7, 2, 5, 4, 6, 11, 10}
    public List<List<Integer>> shiftGridWithReverseArray(int[][] grid, int k) {
        List<Integer> oneDimensionalArr = new ArrayList<>();
        for (int[] arr : grid) {
            for (int i : arr) {
                oneDimensionalArr.add(i);
            }
        }

        int arraySize = oneDimensionalArr.size();
        k = k % arraySize;
        reverse(oneDimensionalArr, 0, arraySize - k - 1);
        reverse(oneDimensionalArr, arraySize - k, arraySize - 1);
        reverse(oneDimensionalArr, 0, arraySize - 1);

        List<List<Integer>> resultArrayList = new LinkedList<>();
        List<Integer> subsetArrayList = new LinkedList<>();
        for (Integer integer : oneDimensionalArr) {
            subsetArrayList.add(integer);
            if (subsetArrayList.size() >= grid[0].length) {
                resultArrayList.add(subsetArrayList);
                subsetArrayList = new LinkedList<>();
            }
        }

        return resultArrayList;
    }

    // Solution 3 - Index pointer
    // Time Complexity : O(N)
    // Space Complexity : O(N)
    public List<List<Integer>> shiftGridWithIndexPointer(int[][] grid, int k) {
        List<List<Integer>> resultArrayList = new LinkedList<>();

        int rowLen = grid[0].length, gridArea = rowLen * grid.length;
        int start = gridArea - k % gridArea, idx = -1, x, y;
        for (int i = start; i < gridArea + start; i++) {
            x = i % gridArea / rowLen;
            y = i % gridArea % rowLen;

            if ((i - start) % rowLen == 0) {
                resultArrayList.add(new LinkedList<>());
                idx++;
            }

            resultArrayList.get(idx).add(grid[x][y]);
        }

        return resultArrayList;
    }

    static void reverse(List<Integer> arr, int x, int y) {
        while (x < y) {
            swap(arr, x++, y--);
        }
    }

    static void swap(List<Integer> arr, int x, int y) {
        int tmp = arr.get(x);
        arr.set(x, arr.get(y));
        arr.set(y, tmp);
    }
}
