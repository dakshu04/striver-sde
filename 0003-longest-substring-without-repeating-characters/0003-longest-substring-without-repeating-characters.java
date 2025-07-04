class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashSet<Character> set = new HashSet<>();
        int start = 0;
        int end = 0;
        int maxLen = 0;
        while(end < n) {
            if(!set.contains(s.charAt(end))) {
                set.add(s.charAt(end));
                maxLen = Math.max(maxLen, end - start + 1);
                end++;
            } else {
                set.remove(s.charAt(start));
                start++;
            }
        }
        return maxLen;
    }
}