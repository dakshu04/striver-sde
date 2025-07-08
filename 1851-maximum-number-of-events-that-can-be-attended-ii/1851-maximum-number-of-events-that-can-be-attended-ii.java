class Solution {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]); // sort by startDay
        int n = events.length;
        int[][] dp = new int[n][k+1];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return dfs(0, k, events, dp); 
    }
    public int dfs(int i, int k, int[][] events, int[][] dp) {
        if (i == events.length || k == 0) return 0;
        if(dp[i][k] != -1) return dp[i][k];
        // Option 1: skip current event
        int notTake = dfs(i + 1, k, events, dp);
        // Option 2: take current event
        int next = findNext(events, events[i][1]);
        int take = events[i][2] + dfs(next, k - 1, events, dp);
        return dp[i][k] = Math.max(take, notTake);
    }
    // Binary search for the first event starting after the current ends
    private int findNext(int[][] events, int endTime) {
        int low = 0, high = events.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (events[mid][0] > endTime)
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }
}