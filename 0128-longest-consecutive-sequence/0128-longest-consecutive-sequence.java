class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;//TC->O(n),SC->(n)
        HashSet<Integer> hs = new HashSet<>();
        for(int i : nums) {
            hs.add(i);
        }
        int longestSeq = 0;
        for(int num : hs) {
            if(!hs.contains(num - 1)) {
                int currVal = num;
                int currSeq = 1;
                while(hs.contains(currVal + 1)) {
                    currVal++;
                    currSeq++;
                }
                longestSeq = Math.max(currSeq, longestSeq);
            }
        }
        return longestSeq;
    }
}