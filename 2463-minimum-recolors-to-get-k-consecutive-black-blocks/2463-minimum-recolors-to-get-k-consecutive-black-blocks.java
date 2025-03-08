class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        int left = 0;
        int whiteCnt = 0;
        int minOperations = Integer.MAX_VALUE;
        for(int right = 0 ; right < n; right++)  {
            if(blocks.charAt(right) == 'W') {
                whiteCnt++;
            }
            if(right - left + 1 == k) {
                minOperations = Math.min(minOperations, whiteCnt);
                if(blocks.charAt(left) == 'W') {
                    whiteCnt--;
                }
                left++;
            }
        }
        return minOperations;
    }
}