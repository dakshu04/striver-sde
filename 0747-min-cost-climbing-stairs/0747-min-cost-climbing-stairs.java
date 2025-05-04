class Solution {
    //TC->O(n), SC->O(1) - Optimization
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        if(n == 1) return cost[0];
        int prev2 = cost[0];
        int prev1 = cost[1];
        for(int i = 2; i < cost.length; i++) {
            int curr = cost[i] + Math.min(prev1, prev2);
            prev2 = prev1;
            prev1 = curr;
        }
        return Math.min(prev1, prev2);
    }
}