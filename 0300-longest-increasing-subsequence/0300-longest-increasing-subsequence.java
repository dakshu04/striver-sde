class Solution {
    public int lengthOfLIS(int[] arr) {
        int n = arr.length;
        int[] next = new int[n + 1];
        int[] curr = new int[n + 1];
        //TC->O(n^2){nestedLoop}
        //SC->O(n){two 1D array}
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int prevIdx = ind - 1; prevIdx >= -1; prevIdx--) {
                int len = 0 + next[prevIdx + 1];
                if (prevIdx == -1 || arr[ind] > arr[prevIdx]) {
                    len = Math.max(len, 1 + next[ind + 1]);
                }
                curr[prevIdx + 1] = len;
            }
            next = cur.clone(); 
        }
        return next[0];
    }
}