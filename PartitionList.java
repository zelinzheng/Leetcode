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
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode small = fakeHead;
        
        while(small.next!=null && small.next.val < x) {
            small = small.next;
        }
        
        ListNode large = small.next;
        ListNode curr = small;
        
        while(curr.next!=null) {
            if(curr.next.val<x) {
                small.next = curr.next;
                curr.next = curr.next.next;
                small.next.next = large;
                small = small.next;
            } else {
                curr = curr.next;
            }
        }
        
        return fakeHead.next;
    }
}