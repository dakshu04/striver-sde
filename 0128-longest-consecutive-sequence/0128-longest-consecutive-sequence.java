class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num :  nums) {
            set.add(num);
        }
        int maxSeq = 0;
        for(int num : set) {
            if(!set.contains(num - 1)) {
                int currSeq = 1;
                int currVal = num;
                while(set.contains(currVal + 1)) {
                    currSeq++;
                    currVal++;
                }
                maxSeq = Math.max(maxSeq, currSeq);
            }
        }
        return maxSeq;
    }
}