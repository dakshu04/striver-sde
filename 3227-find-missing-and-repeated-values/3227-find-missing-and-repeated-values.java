class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int totalNumbers = m * n;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                map.put(grid[i][j], map.getOrDefault(grid[i][j], 0) + 1);
            }
        }
        int repeating = -1;
        int missing = -1;
        for(int i = 1; i <= totalNumbers; i++) {
            if(map.getOrDefault(i, 0) == 2) { //if i not there then give 0 by default
                repeating = i;
            } else if(!map.containsKey(i)) {
                missing = i;
            }
        }
        return new int[]{repeating, missing};
    }
}