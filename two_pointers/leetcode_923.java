package two_pointers;

import java.util.HashMap;
import java.util.Map;

public class leetcode_923 {
    public static void main(String[] args) {
        leetcode_923 leetcode = new leetcode_923();
        int[] arr = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
        System.out.println(leetcode.threeSumMulti(arr, 8));
    }

    // Solution - Hashmap brute force
    // Time Complexity - O(N)
    // Space Complexity - O(N)
    // loop i & j on all number.
    // initialize cnt to (cnt + getOrDefault from map(target - ith element / 0)) % 1000000007 (modulo value)
    // put arr[i] + arr[j], getOrDefault(arr[i] + arr[j], 0) + 1 at map in j loop (iterative till j < i)
    //
    // Example - [1, 1, 2, 2, 2, 2], 5
    // First loop : cnt = 0 + 0(map doesn't have key 4) % mod = 0
    //              j loop doesn't work - because i = 0
    // Second loop : cnt = 0 + 0 % mod = 0
    //              tmp = 2(1 + 1), map.put(2, 1(cause map doesn't have key '2' yet, 0 + 1)) - j loop end
    // Third loop : cnt = 0 + 3(5 - 2) % mod = 3
    //              tmp = 3(2 + 1), map.put(3, 1)
    //              tmp = 3(2 + 1), map.put(3, 2) - j loop end
    //
    // At the end of the loop, cnt must be number of 3Sum tuples.
    public int threeSumMulti(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            cnt = (cnt + map.getOrDefault(target - arr[i], 0)) % 1000000007;

            for (int j = 0; j < i; j++) {
                int tmp = arr[i] + arr[j];
                map.put(tmp, map.getOrDefault(tmp, 0) + 1);
            }
        }
        return cnt;
    }
}
