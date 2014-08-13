/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int n) {
        ListNode newHead = new ListNode(-1);
        if(head == null || n<1) return head;
        newHead.next = head;
        ListNode prev = newHead;
        
        int len = 1;
        for(;len<n;len++) {
            if(head.next!=null)head = head.next;
            else break;
        }
        
        if(len == n && head.next == null) 
            return newHead.next;
        else if(len<n) {
            n %= len;
            n = len - n;
            for(int i=0; i<n; i++) {
                prev = prev.next;
            }
        } else {
            while(head.next!=null) {
                head = head.next;
                prev = prev.next;
            }
        }
        
        head.next = newHead.next;
        newHead.next = prev.next;
        prev.next = null;
        
        return newHead.next;
        
    }
}