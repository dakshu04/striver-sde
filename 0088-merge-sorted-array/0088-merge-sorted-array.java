class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int left = m - 1;//TC->O(m+n)
        int right = n - 1;//SC->O(1)
        int k = m + n - 1; //length of nums1
        while(left >= 0 && right >= 0) {
            if(nums1[left] > nums2[right]) {
                nums1[k--] = nums1[left--];
            } else {
                nums1[k--] = nums2[right--];
            }
        }
        while(right >= 0) {
            nums1[k--] = nums2[right--];
        }

    }
}