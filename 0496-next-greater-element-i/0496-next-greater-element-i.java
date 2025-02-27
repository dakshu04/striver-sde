class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> hashMap = new HashMap();
        for(int i = nums2.length - 1; i >= 0; i--){
            while(!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                hashMap.put(nums2[i], -1);
            } else {
                hashMap.put(nums2[i], stack.peek());
            }
            stack.push(nums2[i]);
        }
        
        int[] res = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++) {
            res[i] = hashMap.get(nums1[i]);
        }
        
        return res;
    }
}