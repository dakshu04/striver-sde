class Solution {
    public int minCapability(int[] nums, int k) {
        // Initialize the search space for binary search
        // 'left' is the minimum possible value in the array
        // 'right' is the maximum possible value in the array
        int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;
        
        // Find the min and max values in the array to define the search range
        for (int num : nums) {
            left = Math.min(left, num);  // Update left with the smallest number
            right = Math.max(right, num); // Update right with the largest number
        }
        
        // Perform binary search on the minimum capability required
        while (left < right) {
            int mid = left + (right - left) / 2; // Find the middle value
            
            // Check if we can pick 'k' non-adjacent elements with 'mid' as the max value
            if (canPickK(nums, k, mid)) {
                right = mid; // If possible, try to minimize further
            } else {
                left = mid + 1; // If not possible, increase the range
            }
        }
        
        return left; // The smallest possible max capability
    }

    // Helper function to check if we can pick 'k' non-adjacent elements
    // such that all chosen elements are <= 'maxCapability'
    private boolean canPickK(int[] nums, int k, int maxCapability) {
        int count = 0; // Number of elements picked
        int i = 0; // Index for iteration
        
        while (i < nums.length) {
            // If the current element is within the allowed capability
            if (nums[i] <= maxCapability) {
                count++; // Pick this element
                i++; // Skip the next element to maintain non-adjacency
            }
            i++; // Move to the next element
        }
        
        return count >= k; // Return true if we successfully picked at least 'k' elements
    }
}
