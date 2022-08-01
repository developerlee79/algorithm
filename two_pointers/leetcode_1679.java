package two_pointers;

import java.util.HashMap;
import java.util.Map;

public class leetcode_1679 {
    public static void main(String[] args) {
        leetcode_1679 leetcode = new leetcode_1679();
        int[] nums = {2, 5, 4, 4, 1, 3, 4, 4, 1, 4, 4, 1, 2, 1, 2, 2, 3, 2, 4, 2};
        int k = 3;
        System.out.println(leetcode.maxOperations(nums, k));
    }

    // Solution - Two Pointers
    // Time Complexity : O(N)
    // Space Complexity : O(N)
    // Solve the problem with the target - num method
    // Which is one of the representative Map solution for the "Two Sum" problem.
    // Searching the array and find key what contains in the map & available value != 0 to reduce the available count and increase cnt.
    // When creating elements in a map, generate target - num as a key and an available count(value) as 1 or added from exists value.
    // By doing this, you can use the containKey to find out if there is a value that can be target in addition to the num in the next search.
    // The available count means the number of independent (already not used in the operation) of that value.
    public int maxOperations(int[] nums, int k) {
        int cnt = 0;

        Map<Integer, Integer> pairMap = new HashMap<>();
        for (int num : nums) {
            if (pairMap.containsKey(num) && pairMap.get(num) != 0) {
                pairMap.replace(num, pairMap.get(num) - 1);
                cnt++;
            } else {
                pairMap.merge(k - num, 1, Integer::sum);
            }
        }

        return cnt;
    }
}
