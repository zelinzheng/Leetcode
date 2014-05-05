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
public class ReverseNodesInKGroup  {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        
        ListNode preHead = new ListNode(0);
        ListNode curr = head;
        boolean notEnough = false;
        ListNode last = preHead;
        while(curr!=null) {
            int i=0;
            ListNode lastCache = null;
            while(i<k) {
                if(curr!=null) {
                    if(i==0) lastCache = curr;
                    ListNode temp = curr.next;
                    curr.next = last.next;
                    last.next = curr;
                    curr = temp;
                    i++;
                } else {
                    notEnough = true;
                    break;
                }
            }
            if(!notEnough) {
                last = lastCache;
            } else {
                curr = last.next;
                last.next = null;
                while(curr!=null) {
                    ListNode temp = curr.next;
                    curr.next = last.next;
                    last.next = curr;
                    curr = temp;
                }
            }
        }
        
        return preHead.next;
    }
}