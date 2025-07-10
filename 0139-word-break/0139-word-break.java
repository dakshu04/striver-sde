class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] dp = new Boolean[s.length()];
        return canBreak(0, s, new HashSet<>(wordDict), dp);
    }

    public boolean canBreak(int idx, String s, Set<String> dict, Boolean[] dp) {
        if (idx == s.length()) return true;
        if (dp[idx] != null) return dp[idx];

        for (int end = idx + 1; end <= s.length(); end++) {
            if (dict.contains(s.substring(idx, end)) && canBreak(end, s, dict, dp)) {
                return dp[idx] = true;
            }
        }

        return dp[idx] = false;
    }
}
