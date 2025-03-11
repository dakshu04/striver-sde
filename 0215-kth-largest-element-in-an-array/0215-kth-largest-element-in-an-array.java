// class Solution {//TC->O(nlogk),SC->O(k)Using MaxHeap
//     public int findKthLargest(int[] nums, int k) {
//         PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
//         for(int num : nums) {
//             pq.add(num);
//         }
//         int ans = -1;
//         for(int i = 0; i < k; i++) {
//             ans = pq.poll();
//         }
//         return ans;
//     }
// }
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // Min heap
        
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll(); // Remove smallest element, keeping k largest elements
            }
        }
        
        return pq.peek(); // The root is the k-th largest element
    }
}