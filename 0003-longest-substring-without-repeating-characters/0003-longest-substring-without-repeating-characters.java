class Solution {
    public int lengthOfLongestSubstring(String s) {//TC-O(N), SC-O(1)
        // int[] index = new int[128]; // ASCII character set
        // int left = 0, maxLen = 0;
        
        // for (int right = 0; right < s.length(); right++) {
        //     left = Math.max(left, index[s.charAt(right)]);
        //     maxLen = Math.max(maxLen, right - left + 1);
        //     index[s.charAt(right)] = right + 1; // Store index + 1
        // }
        
        // return maxLen;

        int n = s.length();
        int maxLen = 0;
        
        for (int i = 0; i < n; i++) {
            HashSet<Character> set = new HashSet<>();
            for (int j = i; j < n; j++) {
                if (set.contains(s.charAt(j))) break; // Stop when duplicate found
                set.add(s.charAt(j));
                maxLen = Math.max(maxLen, j - i + 1);
            }
        }
        return maxLen;
    }
}