class Solution {
    public boolean isPalindrome(String s, int start, int end) {
        while(start < end) {
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
    public String fun(String s, int start, int end, String[][] dp) {
        if(start > end) return "";
        if(isPalindrome(s, start, end)) return s.substring(start, end + 1);
        if(dp[start][end] != null) return dp[start][end];
        String left = fun(s, start + 1, end, dp);
        String right = fun(s, start, end - 1, dp);
        return dp[start][end] = left.length() > right.length() ? left : right;
    }
    public String longestPalindrome(String s) {
        int n = s.length();
        String[][] dp = new String[n][n];
        return fun(s, 0, n - 1, dp);
    }
}