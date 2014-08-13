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
public class RemoveDuplicatesfromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode pre = fakeHead;
        
        while(pre.next!=null) {
            ListNode curr = pre.next;
            if(curr.next!=null && curr.next.val == curr.val) {
                do {
                  curr = curr.next;
                }
                while(curr.next!=null&&curr.next.val == curr.val);
                    
                pre.next = curr.next;
            } else {
                pre = pre.next;
            }
        }
        return fakeHead.next;
    }
}