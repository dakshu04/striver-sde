class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int cnt = 0;
        //TC->O(n+m),SC->O(1)
        int m = n1 + n2;
        int idx1 = -1;
        int idx2 = -1;
        if(m % 2 == 1)  {
            idx1 = m / 2;
        } else {
            idx1 = m / 2 - 1;
            idx2 = m / 2;
        }
        int idx1El = -1;
        int idx2El = -1;
        int i = 0, j = 0;
        while(i < n1 && j < n2) {
            if(nums1[i] < nums2[j]) {
                if(cnt == idx1) idx1El = nums1[i];
                if(cnt == idx2) idx2El = nums1[i];
                cnt++;
                i++;
            } else {
                if(cnt == idx1) idx1El = nums2[j];
                if(cnt == idx2) idx2El = nums2[j];
                cnt++;
                j++;
            }
        }
        while(i < n1) {
            if(cnt == idx1) idx1El = nums1[i];
            if(cnt == idx2) idx2El = nums1[i];
            cnt++;
            i++;
        }
        while(j < n2) {
            if(cnt == idx1) idx1El = nums2[j];
            if(cnt == idx2) idx2El = nums2[j];
            cnt++;
            j++;
        }
        if(m % 2 == 1) {
            return idx1El;
        }
        return (idx1El + idx2El) / 2.0;
    }
}