class Solution {
    private int robLinear(int[] nums, int start, int end) {
        int prev2 = 0;
        int prev1 = 0;
        for (int i = start; i <= end; i++) {
            int curr = Math.max(prev1, nums[i] + prev2);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        int case1 = robLinear(nums, 0, n - 2); // exclude last
        int case2 = robLinear(nums, 1, n - 1); // exclude first

        return Math.max(case1, case2);
    }
}
