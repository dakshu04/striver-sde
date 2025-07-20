class Solution {
    public boolean fun(int[] nums, int idx, int target, int[][] dp) {
        if(idx == 0) {
            return nums[idx] == target;
        }
        if(dp[idx][target] != -1) return dp[idx][target] == 1;
        boolean notTake = fun(nums, idx - 1, target, dp);
        boolean take = false;
        if(nums[idx] <= target) {
            take = fun(nums, idx - 1, target - nums[idx], dp);
        }
        dp[idx][target] = notTake || take ? 1 : 0;
        return dp[idx][target] == 1;
    }
    public boolean canPartition(int[] nums) {
        int total = 0;
        int n = nums.length;
        for(int num : nums) {
            total += num;
        }
        int amount = total / 2;
        int[][] dp = new int[n][amount+1];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        if(total % 2 != 0) {
            return false;
        } else {
            return fun(nums, n-1, amount, dp);
        }
    }
}