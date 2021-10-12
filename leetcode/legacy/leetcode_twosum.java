public class leetcode_twosum {
    public int[] twoSum(int[] nums, int target) {
        int[] resultArr = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];

            for (int j = 1; j < nums.length; j++) {
                if (i != j && temp + nums[j] == target) {
                    resultArr = new int[]{i, j};
                }
            }
        }

        return resultArr;
    }
}
