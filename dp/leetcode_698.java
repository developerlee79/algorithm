package dp;

public class leetcode_698 {
    public static void main(String[] args) {
        leetcode_698 lc = new leetcode_698();

        int[] nums = {4, 3, 2, 3, 5, 2, 1};
        System.out.println(lc.canPartitionKSubsets(nums, 4));
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int n : nums) sum += n;    // 전체의 합 구함
        if (sum % k != 0) return false; // 전체의 합을 k로 나눈 나머지가 0이 아니라면 return false
        if (nums.length < k) return false;  // 배열 길이가 k보다 작다면 return false
        // 원 배열,    재귀용 배열 (boolean)    재귀 시작  k    재귀 포인트       전체를 k로 나눈 값
        return canPartition(nums, new boolean[nums.length], 0, k, 0, sum / k);
    }

    private boolean canPartition(int[] nums, boolean[] used, int start, int k, int curSum, int subSum) {
        if (k == 1) return true;                // k가 1이라면 true
        if (curSum > subSum) return false;      // 0 > sum / k = false
        if (curSum == subSum) return canPartition(nums, used, 0, k - 1, 0, subSum); // 0 == sum / k -> k - 1 재귀

        for (int i = start; i < nums.length; i++) {
            if (used[i]) continue;  // i번째 요소가 사용되었다면 continue;
            used[i] = true;         // used[i]를 true
            if (canPartition(nums, used, i + 1, k, curSum + nums[i], subSum)) return true;
            used[i] = false;        // used[i] false
        }

        return false;
    }
}
