class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int prev1 = cost[1];
        int prev2 = cost[0];
        for(int idx = 2; idx < n; idx++) {
            int curr = cost[idx] + Math.min(prev1, prev2);
            prev2 = prev1;
            prev1 = curr;
        }
        return Math.min(prev1, prev2);
    }
}
