class Solution {
    public int fun(int[] nums, int[] memo, int idx) {
        if(idx < 0) return 0;
        if(memo[idx] != -1) return memo[idx];
        int robCurr = nums[idx] + fun(nums, memo, idx - 2);
        int skipCurr = fun(nums, memo, idx - 1);
        return memo[idx] = Math.max(robCurr, skipCurr);
    }
    public int rob(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return fun(nums, memo, nums.length - 1);
    }
}