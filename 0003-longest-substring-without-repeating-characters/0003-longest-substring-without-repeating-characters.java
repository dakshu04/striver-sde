class Solution {
    public int lengthOfLongestSubstring(String s) {//TC-O(N), SC-O(1)
        int[] index = new int[128]; // ASCII character set
        int left = 0, maxLen = 0;
        
        for (int right = 0; right < s.length(); right++) {
            left = Math.max(left, index[s.charAt(right)]);
            maxLen = Math.max(maxLen, right - left + 1);
            index[s.charAt(right)] = right + 1; // Store index + 1
        }
        
        return maxLen;
    }
}