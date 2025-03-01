class Solution {
    private boolean binarySearch(int[] matrix, int target) {
        int start = 0;
        int end = matrix.length - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(matrix[mid] == target) {
                return true;
            } else if(matrix[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i = 0; i < n; i++) {
            if(matrix[i][0] <= target && target <= matrix[i][m - 1]) {
                return binarySearch(matrix[i], target);
            }
        }
        return false;
    }
}