class Solution {
    private int solve(int start, int end, int[] nums) {
        int prev = nums[start];
        int prev2 = 0;
        for (int i = start + 1; i <= end; i++) {
            int pick = nums[i];
            if (i > start + 1) {
                pick += prev2;
            }
            int nonPick = prev;
            int curr = Math.max(pick, nonPick);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        // Solve once excluding the first house, and once excluding the last house
        return Math.max(solve(1, n - 1, nums), solve(0, n - 2, nums));
    }
}
