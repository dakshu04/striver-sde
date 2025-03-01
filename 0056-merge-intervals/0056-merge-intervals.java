class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);//ascemding
        int start = intervals[0][0];
        int end = intervals[0][1];
        int[][] ans = new int[n][2];
        int idx = 0;
        for(int i = 1; i < n; i++) {
            if(intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
            } else {
                ans[idx++] = new int[]{start, end};
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        // Step 3: Store the last merged interval
        ans[idx++] = new int[]{start, end};
        return Arrays.copyOf(ans, idx); //only till idx will return
    }
}