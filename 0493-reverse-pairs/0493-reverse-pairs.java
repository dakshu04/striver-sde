class Solution {
    // TC-> O(logN * (N+N)) = O(2N*logN).
    // SC-> O(N) used in merge sort
    private int countPairs(int[] arr, int low, int mid, int high) {
        int cnt = 0;
        int right = mid + 1;
        
        for (int i = low; i <= mid; i++) {
            while (right <= high && arr[i] > 2L * arr[right]) {
                right++;
            }
            cnt += right - (mid + 1);
        }
        return cnt;
    }

    private void merge(int[] arr, int low, int mid, int high) {
        int left = low, right = mid + 1;
        int[] temp = new int[high - low + 1];
        int idx = 0;
        
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[idx++] = arr[left++];
            } else {
                temp[idx++] = arr[right++];
            }
        }
        
        while (left <= mid) {
            temp[idx++] = arr[left++];
        }
        
        while (right <= high) {
            temp[idx++] = arr[right++];
        }
        
        System.arraycopy(temp, 0, arr, low, temp.length);
    }

    private int mergeSort(int[] arr, int low, int high) {
        if (low >= high) return 0;
        int mid = (low + high) / 2;
        int cnt = mergeSort(arr, low, mid);
        cnt += mergeSort(arr, mid + 1, high);
        cnt += countPairs(arr, low, mid, high);
        merge(arr, low, mid, high);
        return cnt;
    }

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }
}
