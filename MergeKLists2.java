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
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if(lists == null || lists.size()==0) return null;
        int last = lists.size()-1;
        while(last>0) {
            int begin = 0;
            while(begin<last) {
                lists.set(begin, hp(lists.get(begin++), lists.get(last--)));
            }
        }
        
        return lists.get(0);
    }
    
    private ListNode hp (ListNode l1 , ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        
        ListNode head = null;
        ListNode curr = null;
        
        if(l1.val<l2.val) {
            head = l1;
            curr = head;
            l1 = l1.next;
        } else {
            head = l2;
            curr = head;
            l2 = l2.next;
        }
        
        while(l1!=null || l2!=null) {
            if(l2 == null || l1!=null && l1.val<l2.val) {
                curr.next = l1;
                curr = curr.next;
                l1 = l1.next;
            } else {
                curr.next = l2;
                curr = curr.next;
                l2 = l2.next;
            }
        }
        
        return head;
    }
}