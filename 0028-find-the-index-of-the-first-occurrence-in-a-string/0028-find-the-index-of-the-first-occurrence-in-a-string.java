class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        for(int i = 0; i <= n - m; i++) {
            String s = haystack.substring(i, i + m);
            if(s.contains(needle)) {
                return i;
            }
        }
        return -1;
    }
}