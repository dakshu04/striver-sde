class Solution {
    public String getPermutation(int n, int k) {
        List<String> permutations = new ArrayList<>();
        boolean[] used = new boolean[n + 1];
        backtrack(n, new StringBuilder(), used, permutations);
        Collections.sort(permutations); // Sorting to maintain lexicographical order
        return permutations.get(k - 1);
    }

    private void backtrack(int n, StringBuilder current, boolean[] used, List<String> result) {
        if (current.length() == n) {
            result.add(current.toString());
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!used[i]) {
                used[i] = true;
                current.append(i);
                backtrack(n, current, used, result);
                current.deleteCharAt(current.length() - 1);
                used[i] = false;
            }
        }
    }
}
