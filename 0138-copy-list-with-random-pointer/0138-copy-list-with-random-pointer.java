/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
         if (head == null) return null;

        // Step 1: Create interleaved nodes
        Node cur = head;
        while (cur != null) {
            Node copy = new Node(cur.val);
            copy.next = cur.next;
            cur.next = copy;
            cur = copy.next;
        }

        // Step 2: Assign random pointers
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        // Step 3: Separate the copied list from the original list
        Node dummy = new Node(0);
        Node copyCur = dummy, copyHead = dummy;
        cur = head;
        while (cur != null) {
            copyCur.next = cur.next;
            cur.next = cur.next.next;
            cur = cur.next;
            copyCur = copyCur.next;
        }

        return dummy.next; 
    }
}