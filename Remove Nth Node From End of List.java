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
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int i =0;
        while(i<n-1) {
            temp = temp.next;
            i++;
        }
        
        ListNode nth = head;
        ListNode previous = null;
        while( temp.next!=null) {
            temp = temp.next;
            if(previous == null) previous = head;
            else previous = nth;
            nth = nth.next;
             
        } 
        
        if(nth == head) {
            head = head.next;
        } else if(nth.next == null) {
            previous.next = null;
        } else {
            previous.next = nth.next;
        }
        
        return head;
    }
}