class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int start = intervals[0][0];
        int end = intervals[0][1]; 
        int[][] ans = new int[n][2];
        int idx = 0;
        for(int i = 1; i < n; i++) {
            if(end >= intervals[i][0]) {
                end = Math.max(intervals[i][1], end);
            } else {
                ans[idx++] = new int[]{start, end};
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        ans[idx++] = new int[]{start, end};
        return Arrays.copyOf(ans, idx);
    }
}