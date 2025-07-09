class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        int[] dp = new int[n];
        int prev1 = Math.max(nums[0], nums[1]);
        int prev2 = nums[0];
        for(int idx = 2; idx < n; idx++) {
            int curr = Math.max(prev1, nums[idx] + prev2);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}
