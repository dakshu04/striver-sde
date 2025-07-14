/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int getDecimalValue(ListNode head) {
        ListNode temp = head;
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        while(temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }
        int size = list.size() - 1;
        for(int num : list) {
            sum += num * Math.pow(2, size);
            size--;
        }
        return sum;
    }
}