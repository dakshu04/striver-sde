class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int m = n1 + n2;
        int[] arr = new int[m];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < n1 && j < n2) {
            if(nums1[i] < nums2[j]) {
                arr[k++] = nums1[i++];
            } else {
                arr[k++] = nums2[j++];
            }
        }
        while(i < n1) {
            arr[k++] = nums1[i++];
        }
        while(j < n2) {
            arr[k++] = nums2[j++];
        }
        // Calculate median
        if (m % 2 == 1) {
            return arr[m / 2]; // Odd length: return middle element
        }
        return (arr[m / 2] + arr[(m / 2) - 1]) / 2.0; // Even length: average of two middle elements
    }
}