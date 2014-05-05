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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode temp = head;
        ListNode next = head.next;
        head = next;
        
        do {
            temp.next = next.next;
            next.next = temp;
            if(temp.next == null) break;
            else temp = temp.next;
            if(temp.next !=null) {
               next.next.next = temp.next;
               next = temp.next;
            }
            else break;
        } while (true);
        
        return head;
        
        
    }
}