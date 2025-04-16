class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];  // Final result array
        Deque<Integer> dq = new ArrayDeque<>(); // Stores indexes of useful elements in window
        int ri = 0; // Pointer for filling result array

        for (int i = 0; i < n; i++) {
            // Step 1: Remove indexes of elements not in the current window
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }
            // Step 2: Remove all elements smaller than current from the back of the deque
            // Because they are useless — won't be max in this window or any future one
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }
            // Step 3: Add current element's index to the deque
            dq.offerLast(i);
            // Step 4: If window is formed (i >= k - 1), take max (front of deque)
            if (i >= k - 1) {
                result[ri++] = nums[dq.peekFirst()];
            }
        }
        return result;
    }
}
