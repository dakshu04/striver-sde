class Solution {
    //TC->O(n log n) + O(2ⁿ)
    //SC->O(2ⁿ * n)
    private void fun(int start, int[] nums, List<Integer> current, List<List<Integer>> subsets) {
        subsets.add(new ArrayList<>(current)); // Add current subset

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue; // Skip duplicates
            } 
            current.add(nums[i]);
            fun(i + 1, nums, current, subsets); // Use i + 1 instead of start + 1
            current.remove(current.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        Arrays.sort(nums); // Sort to handle duplicates
        fun(0, nums, new ArrayList<>(), subsets);
        return subsets;
    }
}
