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
    public ListNode middleNode(ListNode head) {
        ListNode temp = head;
        int size = 0;
        while(temp != null) {
            size++;
            temp = temp.next;
        }
        int mid = size / 2 + 1;
        temp = head;
        while(temp !=  null) {
            mid = mid - 1;
            if(mid == 0) {
                break;
            }
            temp = temp.next;
        }
        return temp;
    }
}