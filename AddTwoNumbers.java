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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return new ListNode(0);
        ListNode result = null;
        ListNode previous = null;
        int up = 0;
        while(l1!=null || l2 !=null){
            int i = l1==null? 0 : l1.val;
            int j = l2==null? 0 : l2.val;
            
            if(l1!=null)l1 = l1.next;
            if(l2!=null) l2 = l2.next;
            
            int digit = i+j+up;
            up=digit/10;
            digit %= 10;
            
            if(previous == null ) {
                result = new ListNode(digit);
                previous = result;
            } else {
                previous.next = new ListNode(digit);
                previous = previous.next;
            }
        }
       
        if(up ==1) previous.next = new ListNode(1);
        
        return result;
    }
}
