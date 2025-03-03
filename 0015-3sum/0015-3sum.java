class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums); // Sort the array to handle duplicates efficiently
        List<List<Integer>> ans = new ArrayList<>();
        //TC->O(n^2), Sc->O(n)
        for (int i = 0; i < n - 2; i++) {//we need at least three numbers
            if (i > 0 && nums[i] == nums[i - 1]) continue; // Skip duplicates

            HashSet<Integer> hs = new HashSet<>();//SC->//O(n)
            for (int j = i + 1; j < n; j++) {
                int third = -(nums[i] + nums[j]);
                if (hs.contains(third)) {//SC->O(n)
                    List<Integer> currAns = Arrays.asList(nums[i], nums[j], third);//this is not arraylist
                    ans.add(currAns);

                    // Skip duplicates for `j`
                    while (j + 1 < n && nums[j] == nums[j + 1]) j++;
                }
                hs.add(nums[j]);
            }
        }
        return ans;
    }
}
