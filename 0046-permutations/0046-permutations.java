class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>(); // Store all permutations
        backtrack(0, nums, ans); // Start recursion
        return ans;
    }
    private void backtrack(int index, int[] nums, List<List<Integer>> ans) {
        // Base case: If index reaches end, store the permutation
        if (index == nums.length) {
            List<Integer> ds = new ArrayList<>();
            for (int num : nums) ds.add(num);
            ans.add(new ArrayList<>(ds)); // Add a copy of the current permutation
            return;
        }
        // Try placing each number at the current index
        for(int i = index; i < nums.length; i++) {
            swap(nums, i, index); // Swap to fix the current element
            backtrack(index + 1, nums, ans); // Recurse for next index
            swap(nums, i, index); // Backtrack (undo the swap)
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}